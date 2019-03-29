package com.ruoyi.web.controller.system;

import com.ruoyi.framework.util.ShiroUtils;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leaveController")
public class LeaveController {
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



    @GetMapping("/startWorkflow")
    public ProcessInstance startWorkflow(String userid, Map<String, Object> variables) {
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("processes/leave.bpmn").deploy();
        String businesskey=String.valueOf("SJLKFJSLKDJFLKSJDLKFJLKDSF");//使用leaveapply表的主键作为businesskey,连接业务数据和流程数据
        identityservice.setAuthenticatedUserId(userid);
        ProcessInstance instance=runtimeService.startProcessInstanceByKey("leave",businesskey,variables);
        System.out.println(businesskey);
        String instanceid=instance.getId();

        return instance;
    }
}
