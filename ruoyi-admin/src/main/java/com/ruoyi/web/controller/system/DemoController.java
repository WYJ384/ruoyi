package com.ruoyi.web.controller.system;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysRole;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Autowired
    private IdentityService identityservice;
    @Autowired
    HistoryService histiryservice;
    @RequestMapping("/firstDemo")
    public void firstDemo() {
        identityservice.setAuthenticatedUserId(ShiroUtils.getLoginName());
        ProcessInstance pi=runtimeService.startProcessInstanceByKey("demo2","jskdjflkjslkdjflsjfdlkjsldkjf");
        String processId = pi.getId();
        System.out.println("流程创建成功，当前流程实例ID："+processId);
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();
        Task task=taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第一次执行前，任务名称："+task.getName());
        taskService.setAssignee(task.getId(),ShiroUtils.getLoginName());


        //第一次任务结束
        taskService.complete(task.getId());
        List<Task> resultTask2 = taskService.createTaskQuery().taskCandidateOrAssigned(ShiroUtils.getLoginName()).list();
        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第二次执行前，任务名称："+task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("task为null，任务执行完毕："+task);
        List<ProcessInstance> a = query.involvedUser(ShiroUtils.getLoginName()).listPage(1, 2);

        //历史
        HistoricProcessInstanceQuery process = histiryservice.createHistoricProcessInstanceQuery().processDefinitionKey("demo2").startedBy(ShiroUtils.getLoginName()).finished();
        List<HistoricProcessInstance> list = process.list();
        //操作流水
        List<HistoricActivityInstance> his = histiryservice.createHistoricActivityInstanceQuery().processInstanceId(processId).orderByHistoricActivityInstanceStartTime().asc().list();
        System.out.println(his.size());
    }

    @RequestMapping("/stattDemo")
    public void TestStartProcess() {

        identityservice.setAuthenticatedUserId(ShiroUtils.getLoginName());
        ProcessInstance pi=runtimeService.startProcessInstanceByKey("demo2","jskdjflkjslkdjflsjfdlkjsldkjf");
        String processId = pi.getId();
        System.out.println("流程创建成功，当前流程实例ID："+processId);
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();
        Task task=taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第一次执行前，任务名称："+task.getName());
        taskService.setAssignee(task.getId(),ShiroUtils.getLoginName());
        taskService.addCandidateGroup("","");
        //第一次任务结束
        taskService.complete(task.getId());
        List<Task> tasks=taskService.createTaskQuery().taskCandidateGroup("主任").list();

    }
    @RequestMapping("/TestStartProcess")
    public void findTasksByUserId() {
        String userId ="dulingjiang";
        List<Task> resultTask = taskService.createTaskQuery().processDefinitionKey("demo2").taskCandidateOrAssigned(userId).list();
        System.out.println("任务列表："+resultTask);
    }
    @RequestMapping("/zhuren")
    public  List<Task> zhuren() {
        List<Task> tasks=taskService.createTaskQuery().taskCandidateGroup("主任").list();
        return tasks;
    }

    @RequestMapping("/fuzhuren")
    public  List<Task> fuzhuren() {
        List<Task> tasks=taskService.createTaskQuery().taskCandidateGroup("副主任").list();
        return tasks;
    }
    @RequestMapping("/aa")
    public void aa() {

    }
}
