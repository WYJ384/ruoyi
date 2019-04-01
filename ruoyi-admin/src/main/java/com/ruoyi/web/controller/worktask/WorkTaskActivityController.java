package com.ruoyi.web.controller.worktask;

import java.io.IOException;
import java.util.*;

import com.ruoyi.activiti.service.ActTaskService;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.worktask.domain.WorkTask;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import com.ruoyi.worktask.service.IWorkTaskService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.worktask.domain.WorkTaskActivity;
import com.ruoyi.worktask.service.IWorkTaskActivityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 专项工作汇报内容 信息操作处理
 *
 * @author ruoyi
 * @date 2019-03-26
 */
@Controller
@RequestMapping("/worktask/workTaskActivity")
public class WorkTaskActivityController extends BaseController {
    private String prefix = "worktask/workTaskActivity";
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    HistoryService historyService;
    @Autowired
    TaskService taskService;

    @Autowired
    private ActTaskService actTaskService;
    @Autowired
    private IWorkTaskService workTaskService;
    @Autowired
    private ISysPostService postService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private IWorkTaskActivityService workTaskActivityService;
    @Autowired
    private IWorkTaskFileService workTaskFileService;

    @RequiresPermissions("worktask:workTaskActivity:view")
    @GetMapping()
    public String workTaskActivity() {
        return prefix + "/workTaskActivity";
    }

    @GetMapping("/workTaskActivityDetail")
    public String workTaskActivityDetail(String process_instance_id, ModelMap mmap) {
        mmap.put("process_instance_id",process_instance_id);
        return prefix + "/workTaskActivityDetail";
    }
    /**
     * 查询专项工作汇报内容列表
     */
    @RequiresPermissions("worktask:workTaskActivity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkTaskActivity workTaskActivity) {
        startPage();
        List<WorkTaskActivity> list = workTaskActivityService.selectWorkTaskActivityList(workTaskActivity);
        return getDataTable(list);
    }


    /**
     * 导出专项工作汇报内容列表
     */
    @RequiresPermissions("worktask:workTaskActivity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkTaskActivity workTaskActivity) {
        List<WorkTaskActivity> list = workTaskActivityService.selectWorkTaskActivityList(workTaskActivity);
        ExcelUtil<WorkTaskActivity> util = new ExcelUtil<WorkTaskActivity>(WorkTaskActivity.class);
        return util.exportExcel(list, "workTaskActivity");
    }

    /**
     * 新增专项工作汇报内容
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存专项工作汇报内容
     */
    @RequiresPermissions("worktask:workTaskActivity:add")
    @Log(title = "专项工作汇报内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkTaskActivity workTaskActivity) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//		if(!file.isEmpty()){
//			workTaskFileService.insertWorkTaskFile(file,ShiroUtils.getLoginName(),uuid);
//		}
        workTaskActivity.setId(uuid);
        workTaskActivity.setCreateBy(ShiroUtils.getLoginName());
        workTaskActivity.setCreateTime(new Date());
        return toAjax(workTaskActivityService.insertWorkTaskActivity(workTaskActivity));
    }

    /**
     * 修改专项工作汇报内容
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        WorkTaskActivity workTaskActivity = workTaskActivityService.selectWorkTaskActivityById(id);
        mmap.put("workTaskActivity", workTaskActivity);
        return prefix + "/edit";
    }

    /**
     * 修改保存专项工作汇报内容
     */
//	@RequiresPermissions("worktask:workTaskActivity:edit")
    @Log(title = "专项工作汇报内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MultipartFile file, WorkTaskActivity workTaskActivity, String userIds, String taskId, String taskKey) {
        if (file != null && (!file.isEmpty())) {
            try {
                // 上传文件路径
                String filePath = Global.getUploadPath();
                String originalFilename = file.getOriginalFilename();
                int lastIndexOf = originalFilename.lastIndexOf(".");
                String extension = originalFilename.substring(lastIndexOf);
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file, extension);
                WorkTaskFile workTaskFile = new WorkTaskFile();
                workTaskFile.setUpdateBy(ShiroUtils.getLoginName());
                workTaskFile.setUpdateTime(new Date());
                workTaskFile.setCreateBy(ShiroUtils.getLoginName());
                workTaskFile.setCreateTime(new Date());
                workTaskFile.setExtension(extension);
                workTaskFile.setFileName(originalFilename);
                workTaskFile.setFilePath(fileName);
                workTaskFile.setWorkTaskId(workTaskActivity.getId());
                workTaskFileService.insertWorkTaskFile(workTaskFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotEmpty(taskKey)) {
            if (taskKey.equals("zhurenduban")) {
                Map<String, Object> vars = new HashMap<String, Object>();
                vars.put("yuangong_users", userIds);
                actTaskService.completeTask(taskId, vars);
            } else if (taskKey.equals("gerentijiao")) {
                String workTaskId = workTaskActivity.getWorkTaskId();
                WorkTask workTask = workTaskService.selectWorkTaskById(workTaskId);
                String leaderId = workTask.getLeaderId();
                SysUser sysUser = userService.selectUserById(Long.parseLong(leaderId));
                Map<String, Object> vars = new HashMap<String, Object>();
                vars.put("fenguan_users", sysUser.getLoginName());
                actTaskService.completeTask(taskId, vars);
            } else if (taskKey.equals("lingdaopingfen")) {
                Map<String, Object> vars = new HashMap<String, Object>();
                actTaskService.completeTask(taskId, vars);
                workTaskActivity.setWorkStatus("3");//任务完成
            }
        }

        return toAjax(workTaskActivityService.updateWorkTaskActivity(workTaskActivity));
    }

    /**
     * 删除专项工作汇报内容
     */
    @RequiresPermissions("worktask:workTaskActivity:remove")
    @Log(title = "专项工作汇报内容", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(workTaskActivityService.deleteWorkTaskActivityByIds(ids));
    }




    /**
     * 启动督办任务
     */
    @Log(title = "启动督办任务", businessType = BusinessType.INSERT)
    @PostMapping("/startTask")
    @ResponseBody
    public AjaxResult startTask(WorkTaskActivity workTaskActivity) {
        workTaskActivity = workTaskActivityService.selectWorkTaskActivityById(workTaskActivity.getId());
        String businessTable = "work_task_activity";
        String businessId = workTaskActivity.getId();
        String title = "专项工作任务";
        String userId = ShiroUtils.getLoginName();
        Map<String, Object> vars = new HashMap<String, Object>();

        //查询出执行任务部门的主任或副主任
        String workTaskId = workTaskActivity.getWorkTaskId();
        WorkTask workTask = workTaskService.selectWorkTaskById(workTaskId);
        if (workTask != null) {
            List<SysUser> sysUsers = userService.selectPostByDept(Long.valueOf(workTask.getLeadDeptId()));
            if (sysUsers == null || sysUsers.size() == 0) {
                return AjaxResult.error(1, "该部门没有主任");
            }
            Iterator<SysUser> userIterator = sysUsers.iterator();
            List<String> loginNames = new ArrayList<String>();
            while (userIterator.hasNext()) {
                SysUser sysUser = userIterator.next();
                loginNames.add(sysUser.getLoginName());
            }

            vars.put("zhuren_users", StringUtils.join(loginNames, ","));
            ProcessInstance processInstance = actTaskService.startProcess("duban", businessTable, businessId, title, userId, vars);
            String instanceid = processInstance.getId();
            workTaskActivity.setProcess_instance_id(instanceid);
            workTaskActivity.setWorkStatus("2");//任务进行中
            return toAjax(workTaskActivityService.updateWorkTaskActivity(workTaskActivity));
        }
        return AjaxResult.error();
    }
    /**
     * 历史任务查询
     */
    @PostMapping("/historyTaskList")
    @ResponseBody
    public TableDataInfo  historyTaskList(String processInstanceId){
        List<HistoricTaskInstance> list= historyService // 历史相关Service
                .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
                .processInstanceId(processInstanceId) // 用流程实例id查询
                .finished() // 查询已经完成的任务
                .list();
        return getDataTable(list);
    }

}
