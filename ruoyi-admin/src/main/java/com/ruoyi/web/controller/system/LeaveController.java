package com.ruoyi.web.controller.system;

import com.ruoyi.framework.util.ShiroUtils;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
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
    @Autowired
    ProcessEngine processEngine;

    @GetMapping("/deploy")
    public void deploy() {

        //获取仓库服务 ：管理流程定义

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()//创建一个部署的构建器
                .addClasspathResource("processes/demo2.bpmn")//从类路径中添加资源,一次只能添加一个资源
                .name("请求单流程")//设置部署的名称
                .category("办公类别")//设置部署的类别
                .deploy();

        System.out.println("部署的id"+deploy.getId());
        System.out.println("部署的名称"+deploy.getName());
    }


    @GetMapping("/startProcess")
    public void startProcess(){

        //指定执行我们刚才部署的工作流程
        String processDefiKey="demo2";
        //取运行时服务
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //取得流程实例
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(processDefiKey);//通过流程定义的key 来执行流程
        System.out.println("流程实例id:"+pi.getId());//流程实例id
        System.out.println("流程定义id:"+pi.getProcessDefinitionId());//输出流程定义的id
    }
    @GetMapping("/queryTask")
    //查询任务
    public void queryTask( String assignee){

        //任务的办理人
        //取得任务服务
        TaskService taskService = processEngine.getTaskService();
        //创建一个任务查询对象
        TaskQuery taskQuery = taskService.createTaskQuery();
        //办理人的任务列表
        List<Task> list = taskQuery.taskCandidateOrAssigned(assignee)//指定办理人
                .list();
        //遍历任务列表
        if(list!=null&&list.size()>0){
            for(Task task:list){
                System.out.println("任务的办理人："+task.getAssignee());
                System.out.println("任务的id："+task.getId());
                System.out.println("任务的名称："+task.getName());
            }
        }
    }
    //完成任务
    @GetMapping("/compileTask")
    public void compileTask(String taskId){
        //taskId：任务id
        processEngine.getTaskService().complete(taskId);
        System.out.println("当前任务执行完毕");
    }
    @GetMapping("/viewImage")
    //查看bpmn 资源图片
    public void viewImage() throws Exception{
        String deploymentId="10001";
        String imageName=null;
        //取得某个部署的资源的名称  deploymentId
        List<String> resourceNames = processEngine.getRepositoryService().getDeploymentResourceNames(deploymentId);
        // buybill.bpmn  buybill.png
        if(resourceNames!=null&&resourceNames.size()>0){
            for(String temp :resourceNames){
                if(temp.indexOf(".png")>0){
                    imageName=temp;
                }
            }
        }


    }

    @GetMapping("/queryHistoryTask")
    public void queryHistoryTask(){
        String processInstanceId="10001";
        List<HistoricTaskInstance> list = processEngine.getHistoryService()
                .createHistoricTaskInstanceQuery()
                .processInstanceId(processInstanceId)
                .list();
        if(list!=null&&list.size()>0){
            for(HistoricTaskInstance temp:list){
                System.out.print("历史流程实例任务id:"+temp.getId());
                System.out.print("历史流程定义的id:"+temp.getProcessDefinitionId());
                System.out.print("历史流程实例任务名称:"+temp.getName());
                System.out.println("历史流程实例任务处理人:"+temp.getAssignee());
            }
        }
    }
}
