package com.ruoyi.web.controller.worktask;

import java.io.IOException;
import java.util.*;

import com.ruoyi.activiti.domain.HistoryTaskVo;
import com.ruoyi.activiti.domain.TaskVO;
import com.ruoyi.activiti.service.ActTaskService;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.MailSendService;
import com.ruoyi.worktask.domain.WorkTask;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import com.ruoyi.worktask.service.IWorkTaskService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    private ISysDeptService deptService;
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
    @Autowired
    private MailSendService mailSendService;

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
        if(StringUtils.isEmpty(workTaskActivity.getTargetMonth())){
            workTaskActivity.setTargetMonth(DateFormatUtils.format(new Date(),"MM"));
        }
        List<WorkTaskActivity> list = workTaskActivityService.selectWorkTaskActivityList(workTaskActivity);
        Iterator<WorkTaskActivity> taskActivityIterator = list.iterator();
        while (taskActivityIterator.hasNext()){
            workTaskActivity = taskActivityIterator.next();
            String process_instance_id = workTaskActivity.getProcess_instance_id();
            if(StringUtils.isNotEmpty(process_instance_id)){
                List<HistoricActivityInstance> historicActivityInstances=historyService // 历史相关Service
                        .createHistoricActivityInstanceQuery() // 创建历史活动实例查询
                        .processInstanceId(process_instance_id) // 执行流程实例id
                        .finished()
                        .orderByHistoricActivityInstanceStartTime().asc()
                        .list();
                for(HistoricActivityInstance hai:historicActivityInstances){
                    HistoryTaskVo historyTaskVo=new HistoryTaskVo();
                    BeanUtils.copyProperties(hai,historyTaskVo);
                    SysUser assignee = userService.selectUserByLoginName(historyTaskVo.getAssignee());
                    if(assignee!=null){
                        historyTaskVo.setAssignee(assignee.getDept().getDeptName()+assignee.getUserName());
                    }
                    String desc="";
                    if(hai.getActivityId().equalsIgnoreCase("start")){
                        HistoricVariableInstance zhuren_users = historyService.createHistoricVariableInstanceQuery()
                                .processInstanceId(process_instance_id)
                                .variableName("zhuren_users").singleResult();
                        historyTaskVo.setQueryVariables(zhuren_users.getValue().toString());
                        desc="待分配";
                    }else if(hai.getActivityId().equalsIgnoreCase("zhurenduban")){
                        HistoricVariableInstance yuangong_users = historyService.createHistoricVariableInstanceQuery()
                                .processInstanceId(process_instance_id)
                                .variableName("yuangong_users").singleResult();
                        historyTaskVo.setQueryVariables(yuangong_users.getValue().toString());
                        desc="待提交";
                    }else if(hai.getActivityId().equalsIgnoreCase("gerentijiao")){
                        HistoricVariableInstance fenguan_users = historyService.createHistoricVariableInstanceQuery()
                                .processInstanceId(process_instance_id)
                                .variableName("fenguan_users").singleResult();
                        historyTaskVo.setQueryVariables(fenguan_users.getValue().toString());
                        historyTaskVo.setDescription(historyTaskVo.getAssignee()+"提交工作内容："+workTaskActivity.getContent());
                        desc="待评分";
                    }else if(hai.getActivityId().equalsIgnoreCase("lingdaopingfen")){
                        historyTaskVo.setDescription("分管领导评分:"+workTaskActivity.getTargetScore());
                        historyTaskVo.setRepContent(workTaskActivity.getRepContent());
                        desc="任务结束";
                    }else if(hai.getActivityId().equalsIgnoreCase("end")){
                        historyTaskVo.setDescription("任务结束");
                        desc="任务结束";
                    }
                    workTaskActivity.setDelFlag(desc);
                    String queryVariables = historyTaskVo.getQueryVariables();
                    historyTaskVo.setQueryVariables("");
                    if(StringUtils.isNotEmpty(queryVariables)){
                        String[] arrUsers = queryVariables.split(",");
                        for (String loginName:arrUsers) {
                            SysUser user = userService.selectUserByLoginName(loginName);
                            if(user!=null){
                                historyTaskVo.setQueryVariables(user.getUserName()+",");

                            }
                        }
                        if(hai.getActivityId().equalsIgnoreCase("zhurenduban")){
                            historyTaskVo.setDescription("主任分配任务执行人:"+historyTaskVo.getQueryVariables());
                        }
                    }
                    workTaskActivity.getHistoryTaskVos().add(historyTaskVo);
                    workTaskActivity.setWorkStatus(historyTaskVo.getQueryVariables());
                }
            }
        }
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
    public String add( String workTaskId,ModelMap modelMap) {
        modelMap.put("workTaskId",workTaskId);
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
        //保存月度任务
        AjaxResult ajaxResult = toAjax(workTaskActivityService.insertWorkTaskActivity(workTaskActivity));
        ajaxResult = startTask(workTaskActivity);
        return ajaxResult;
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
    public AjaxResult editSave(MultipartFile file, WorkTaskActivity workTaskActivity, String userIds, String taskId, String taskKey,String submitType) {
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
        if (StringUtils.isNotEmpty(taskKey)&&submitType.equals("2")) {

            if (taskKey.equals("zhurenduban")) {
                taskService.setAssignee(taskId,ShiroUtils.getLoginName());
                taskService.setOwner(taskId,ShiroUtils.getLoginName());
                Map<String, Object> vars = new HashMap<String, Object>();
                vars.put("yuangong_users", userIds);
                actTaskService.completeTask(taskId, vars);
                try {
                    mailSendService.sendSimpleMails(userIds,"请完成NOC办公系统专项工作任务");
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else if (taskKey.equals("gerentijiao")) {
                taskService.setAssignee(taskId,ShiroUtils.getLoginName());
                taskService.setOwner(taskId,ShiroUtils.getLoginName());
                String workTaskId = workTaskActivity.getWorkTaskId();
                WorkTask workTask = workTaskService.selectWorkTaskById(workTaskId);
                String leaderId = workTask.getLeaderId();
                SysUser sysUser = userService.selectUserById(Long.parseLong(leaderId));
                Map<String, Object> vars = new HashMap<String, Object>();
                vars.put("fenguan_users", sysUser.getLoginName());
                actTaskService.completeTask(taskId, vars);
                try {
                    if(StringUtils.isNotEmpty(sysUser.getEmail())){
                        mailSendService.sendSimpleMail(sysUser.getEmail(),"NOC办公系统发送","请查看办公系的专项工作:"+workTask.getWorkName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else if (taskKey.equals("lingdaopingfen")) {
                taskService.setAssignee(taskId,ShiroUtils.getLoginName());
                taskService.setOwner(taskId,ShiroUtils.getLoginName());
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




//    /**
//     * 启动督办任务
//     */
    @Log(title = "启动督办任务", businessType = BusinessType.INSERT)
    @PostMapping("/startTask")
    @ResponseBody
    public AjaxResult startTask(WorkTaskActivity workTaskActivity) {
        workTaskActivity = workTaskActivityService.selectWorkTaskActivityById(workTaskActivity.getId());
        if(workTaskActivity.getWorkStatus().equals("2")){
            return AjaxResult.error("任务已经开始");
        }
        String businessTable = "work_task_activity";
        String businessId = "1";
        String title = "专项工作任务";
        String userId = ShiroUtils.getLoginName();
        Map<String, Object> vars = new HashMap<String, Object>();

        //查询出执行任务部门的主任或副主任
        String workTaskId = workTaskActivity.getWorkTaskId();
        WorkTask workTask = workTaskService.selectWorkTaskById(workTaskId);
        if (workTask != null) {
            String userIds = workTask.getUserIds();
            if(StringUtils.isEmpty(userIds)){
                return AjaxResult.error(1, "请选择督办主任");
            }
            String[] usersArr = userIds.split(",");
            for (String uid:usersArr){
                SysUser sysUser = userService.selectUserById(Long.valueOf(uid));
                if(sysUser!=null){
                    userIds=sysUser.getLoginName();
                }
            }
            vars.put("zhuren_users", userIds);
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

    @GetMapping("/query/{id}")
    public String query(@PathVariable("id") String id, ModelMap mmap)
    {

        WorkTaskActivity workTaskActivity= workTaskActivityService.selectWorkTaskActivityById(id);
        SysUser sysUser = new SysUser();
        WorkTask workTask = workTaskService.selectWorkTaskByExt(workTaskActivity.getWorkTaskId());
        //附件
        WorkTaskFile workTaskFile=new WorkTaskFile();
        workTaskFile.setWorkTaskId(id);
        List<WorkTaskFile> workTaskFiles = workTaskFileService.selectWorkTaskFileList(workTaskFile);

        //查询当前专项工作下的目标任务
        String activityId = workTaskActivity.getId();
        WorkTaskFile activityFile=new WorkTaskFile();
        activityFile.setWorkTaskId(activityId);
        workTaskActivity.setWorkTaskFiles(workTaskFileService.selectWorkTaskFileList(activityFile));
        String process_instance_id = workTaskActivity.getProcess_instance_id();
        if(StringUtils.isNotEmpty(process_instance_id)){
            List<HistoricActivityInstance> list=historyService // 历史相关Service
                    .createHistoricActivityInstanceQuery() // 创建历史活动实例查询
                    .processInstanceId(process_instance_id) // 执行流程实例id
                    .finished()
                    .orderByHistoricActivityInstanceStartTime().asc()
                    .list();
            for(HistoricActivityInstance hai:list){
                HistoryTaskVo historyTaskVo=new HistoryTaskVo();
                BeanUtils.copyProperties(hai,historyTaskVo);
                SysUser assignee = userService.selectUserByLoginName(historyTaskVo.getAssignee());
                if(assignee!=null){
                    historyTaskVo.setAssignee(assignee.getDept().getDeptName()+assignee.getUserName());
                }
                if(hai.getActivityId().equalsIgnoreCase("start")){
                    HistoricVariableInstance zhuren_users = historyService.createHistoricVariableInstanceQuery()
                            .processInstanceId(process_instance_id)
                            .variableName("zhuren_users").singleResult();
                    historyTaskVo.setQueryVariables(zhuren_users.getValue().toString());
                }else if(hai.getActivityId().equalsIgnoreCase("zhurenduban")){
                    HistoricVariableInstance yuangong_users = historyService.createHistoricVariableInstanceQuery()
                            .processInstanceId(process_instance_id)
                            .variableName("yuangong_users").singleResult();
                    historyTaskVo.setQueryVariables(yuangong_users.getValue().toString());
                }else if(hai.getActivityId().equalsIgnoreCase("gerentijiao")){
                    HistoricVariableInstance fenguan_users = historyService.createHistoricVariableInstanceQuery()
                            .processInstanceId(process_instance_id)
                            .variableName("fenguan_users").singleResult();
                    historyTaskVo.setQueryVariables(fenguan_users.getValue().toString());
                    historyTaskVo.setDescription(historyTaskVo.getAssignee()+"提交工作内容："+workTaskActivity.getContent());
                }else if(hai.getActivityId().equalsIgnoreCase("lingdaopingfen")){
                    historyTaskVo.setDescription("分管领导评分:"+workTaskActivity.getTargetScore());
                    historyTaskVo.setRepContent(workTaskActivity.getRepContent());

                }else if(hai.getActivityId().equalsIgnoreCase("end")){
                    historyTaskVo.setDescription("任务结束");
                }
                String queryVariables = historyTaskVo.getQueryVariables();
                historyTaskVo.setQueryVariables("");
                if(StringUtils.isNotEmpty(queryVariables)){
                    String[] arrUsers = queryVariables.split(",");
                    for (String loginName:arrUsers) {
                        SysUser user = userService.selectUserByLoginName(loginName);
                        if(user!=null){
                            historyTaskVo.setQueryVariables(historyTaskVo.getQueryVariables()+user.getUserName()+"("+loginName+")"+",");

                        }
                    }
                    if(hai.getActivityId().equalsIgnoreCase("zhurenduban")){
                        historyTaskVo.setDescription("主任分配任务执行人:"+historyTaskVo.getQueryVariables());
                    }
                }
                workTaskActivity.getHistoryTaskVos().add(historyTaskVo);
            }
        }
        //任务流程图查询
        if(workTaskActivity.getWorkStatus().equals("2")){
            TaskVO taskVO=new TaskVO();
            taskVO.setProcessId(process_instance_id);
            List<TaskVO> taskVOS = actTaskService.selectTaskList(taskVO);
            if(taskVOS!=null&&taskVOS.size()>0){
                taskVO = taskVOS.get(taskVOS.size() - 1);
                taskVO.setCreateBy("/activiti/task/trace/photo/"+taskVO.getProcessDefinitionId()+"/"+taskVO.getExecutionId());
                workTaskActivity.setTaskVO(taskVO);
            }
        }

        mmap.put("workTask", workTask);
        mmap.put("workTaskFiles", workTaskFiles);
        mmap.put("users",userService.selectUserList(sysUser));
        mmap.put("depts",deptService.selectDeptList(new SysDept()));
        mmap.put("workActivity", workTaskActivity);
        return prefix + "/query";
    }

}
