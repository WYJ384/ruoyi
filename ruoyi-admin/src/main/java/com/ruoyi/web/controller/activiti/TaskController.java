package com.ruoyi.web.controller.activiti;


import com.ruoyi.activiti.domain.TaskVO;
import com.ruoyi.activiti.service.ActTaskService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 代办任务
 */
@RequestMapping("activiti/task")
@Controller
public class TaskController extends BaseController {

    @Autowired
    ActTaskService actTaskService;

    private String prefix = "activiti/task";
    /**
     * 进入代办任务页
     * @return
     */
    @RequiresPermissions("activiti:task:view")
    @GetMapping
    public   String task() {
        return prefix + "/tasks";
    }

    /**
     * 查看我的任务  admin 查看所有任务
     * @return
     */
    @Log(title = "查询任务", businessType = BusinessType.OTHER)
    @RequiresPermissions("activiti:task:view")
    @RequestMapping("/list")
    @ResponseBody
    TableDataInfo list(TaskVO taskVO) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        taskVO.paging()[0]=pageNum;
        taskVO.paging()[1]=pageSize;
        //taskVO.setAssignee("admin");
//        if ("admin".equalsIgnoreCase(ShiroUtils.getLoginName())) {
//           // List<TaskVO> taskVOS = actTaskService.selectTaskList(taskVO);
//            //return getDataTable(taskVOS);
//        }
//        taskVO.setAssignee(String.valueOf(ShiroUtils.getLoginName()));
        taskVO.setCandidateUser(String.valueOf(ShiroUtils.getLoginName()));
        List<TaskVO> taskVOS = actTaskService.selectTaskList(taskVO);
        TableDataInfo dataTable = getDataTable(taskVOS);

        dataTable.setTotal(taskVO.getCount());
        return dataTable;
    }

    @RequiresPermissions("activiti:task:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }


    @RequiresPermissions("activiti:task:edit")
    @PostMapping("/edit/{taskId}")
    @ResponseBody
    public String edit(@PathVariable("taskId") String taskId, ModelMap map) {
        TaskVO taskVO = actTaskService.selectOneTask(taskId);
        map.put("task", taskVO);
        return prefix + "/edit";
    }


    @Log(title = "更新任务", businessType = BusinessType.OTHER)
    @RequiresPermissions("activiti:task:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TaskVO task, ModelMap map) {
        actTaskService.completeTask(task.getId(), map);
        return toAjax(1);
    }

    @Log(title = "代办任务", businessType = BusinessType.OTHER)
    @RequiresPermissions("activiti:task:view")
    @PostMapping("/todo")
    @ResponseBody
    public TableDataInfo todo(TaskVO task,ModelMap map) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        task.paging()[0]=pageNum;
        task.paging()[1]=pageSize;
        task.setAssignee(ShiroUtils.getLoginName());
        List<TaskVO> taskVOs = actTaskService.selectTodoTask(task);
        TableDataInfo dataTable = getDataTable(taskVOs);
        dataTable.setTotal(task.getCount());
        return dataTable;
    }
    @Log(title = "受邀任务", businessType = BusinessType.OTHER)
    @RequiresPermissions("activiti:task:view")
    @PostMapping("/involved")
    @ResponseBody
    public TableDataInfo selectInvolvedTask(TaskVO task,ModelMap map) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        task.paging()[0]=pageNum;
        task.paging()[1]=pageSize;
        task.setInvolvedUser(ShiroUtils.getLoginName());
        List<TaskVO> taskVOs = actTaskService.selectInvolvedTask(task);
        TableDataInfo dataTable = getDataTable(taskVOs);
        dataTable.setTotal(task.getCount());
        return dataTable;
    }
    @Log(title = "归档任务", businessType = BusinessType.OTHER)
    @RequiresPermissions("activiti:task:view")
    @PostMapping("/archived")
    @ResponseBody
    public TableDataInfo selectArchivedTask(TaskVO task,ModelMap map) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        task.paging()[0]=pageNum;
        task.paging()[1]=pageSize;
        task.setOwner(ShiroUtils.getLoginName());
        List<TaskVO> taskVOs = actTaskService.selectArchivedTask(task);
        TableDataInfo dataTable = getDataTable(taskVOs);
        dataTable.setTotal(task.getCount());
        return dataTable;
    }

    @Log(title = "查询完成的任务", businessType = BusinessType.OTHER)
    @RequiresPermissions("activiti:task:view")
    @ResponseBody
    @PostMapping("/finishedTask")
    public TableDataInfo finishedTask(TaskVO task, ModelMap map) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        task.paging()[0]=pageNum;
        task.paging()[1]=pageSize;
        task.setOwner(ShiroUtils.getLoginName());
//        task.setAssignee(ShiroUtils.getLoginName());
        List<TaskVO> taskVOs = actTaskService.selectFinishedTask(task);
        TableDataInfo dataTable = getDataTable(taskVOs);
        dataTable.setTotal(task.getCount());
        return dataTable;
    }


    @GetMapping("/form/{procDefId}")
    public void startForm(@PathVariable("procDefId") String procDefId, HttpServletResponse response) throws IOException {
        String formKey = actTaskService.getFormKey(procDefId, null);
        response.sendRedirect(formKey);
    }

    @GetMapping("/form/{procDefId}/{taskId}")
    public void form(@PathVariable("procDefId") String procDefId, @PathVariable("taskId") String taskId, HttpServletResponse response) throws IOException {
        // 获取流程XML上的表单KEY
        String formKey = actTaskService.getFormKey(procDefId, taskId);
        System.out.println("完成任务");
        Map<String, Object> vars=new HashMap<String, Object>();
        vars.put("chengyuan_users","admin,15693120282,18919818967");
        actTaskService.completeTask(taskId,vars);
        response.sendRedirect(formKey + "/" + taskId);
    }



    /**
     * 读取带跟踪的图片
     */
    @RequestMapping(value = "/trace/photo/{procDefId}/{execId}")
    public void traceTaskPhoto(@PathVariable("procDefId") String procDefId, @PathVariable("execId") String execId, HttpServletResponse response) throws Exception {
        InputStream imageStream = actTaskService.traceTaskPhoto(procDefId, execId);
        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }


}
