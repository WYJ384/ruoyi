package com.ruoyi.web.controller.activiti;

import com.ruoyi.activiti.domain.TaskVO;
import com.ruoyi.activiti.service.ActTaskService;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.framework.util.ShiroUtils;
import org.activiti.engine.*;
import org.activiti.engine.history.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@RequestMapping("/activitiController")
@Controller
public class ActivitiController {
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    HistoryService historyService;
    @Autowired
    TaskService taskService;
    @Autowired
    ActTaskService actTaskService;

    @GetMapping("/startProcess")
    @ResponseBody
    public void startProcess(String processDefiKey){

        //指定执行我们刚才部署的工作流程
        //String processDefiKey="leaveBill";
        //取运行时服务
        //取得流程实例
        //ProcessInstance pi = runtimeService.startProcessInstanceByKey(processDefiKey);//通过流程定义的key 来执行流程


        String businessTable="work_task_activity";
        String businessId= UUID.randomUUID().toString().replaceAll("-","");
        String title="测试流程";
        String userId= ShiroUtils.getLoginName();
        Map<String, Object> vars=new HashMap<String, Object>();
        vars.put("zhuren_users","admin,15693120282");
        actTaskService.startProcess(processDefiKey,businessTable,businessId,title,userId,vars);

    }
    /**
     * 历史活动查询
     */
    @GetMapping("/historyActInstanceList")
    @ResponseBody
    public List<HistoricActivityInstance> historyActInstanceList(String processInstanceId){
        List<HistoricActivityInstance> list=historyService // 历史相关Service
                .createHistoricActivityInstanceQuery() // 创建历史活动实例查询
                .processInstanceId(processInstanceId) // 执行流程实例id
                .finished()
                .list();
        for(HistoricActivityInstance hai:list){
            System.out.println("活动ID:"+hai.getId());
            System.out.println("流程实例ID:"+hai.getProcessInstanceId());
            System.out.println("活动名称："+hai.getActivityName());
            System.out.println("办理人："+hai.getAssignee());
            System.out.println("开始时间："+hai.getStartTime());
            System.out.println("结束时间："+hai.getEndTime());
            System.out.println("=================================");
        }
        return list;
    }

    /**
     * 历史任务查询
     */
    @GetMapping("/historyTaskList")
    @ResponseBody
    public List<HistoricTaskInstance>  historyTaskList(String processInstanceId){
        List<HistoricTaskInstance> list= historyService // 历史相关Service
                .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
                .processInstanceId(processInstanceId) // 用流程实例id查询
                .finished() // 查询已经完成的任务
                .list();
        for(HistoricTaskInstance hti:list){
            System.out.println("任务ID:"+hti.getId());
            System.out.println("流程实例ID:"+hti.getProcessInstanceId());
            System.out.println("任务名称："+hti.getName());
            System.out.println("办理人："+hti.getAssignee());
            System.out.println("开始时间："+hti.getStartTime());
            System.out.println("结束时间："+hti.getEndTime());
            System.out.println("=================================");
        }
        return list;
    }

    @RequestMapping("/getfinishprocess")
    @ResponseBody
    public List<HistoricProcessInstance> getHistory(HttpSession session, @RequestParam("current") int current, @RequestParam("rowCount") int rowCount){
        String userid=ShiroUtils.getLoginName();
        HistoricProcessInstanceQuery process = historyService.createHistoricProcessInstanceQuery().processDefinitionKey("duban").startedBy(userid).finished();
        int total= (int) process.count();
        int firstrow=(current-1)*rowCount;
        List<HistoricProcessInstance> info = process.listPage(firstrow, rowCount);

        return info;
    }
    /**查询历史任务的办理人表*/
    @RequestMapping("/findHistoryPersonTask")
    @ResponseBody
    public List<HistoricIdentityLink> findHistoryPersonTask(String processInstanceId){
        //流程实例ID
        List<HistoricIdentityLink> list = historyService
                .getHistoricIdentityLinksForProcessInstance(processInstanceId);

        return list;
    }

    /**查询历史任务的办理人表*/
    @RequestMapping("/findTaskList")
    @ResponseBody
    public List<TaskVO> findTaskList(TaskVO taskVO) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        taskVO.paging()[0]=1;
        taskVO.paging()[1]=10;
        //taskVO.setCandidateUser(String.valueOf(ShiroUtils.getLoginName()));
        List<TaskVO> taskVOS = actTaskService.selectTaskList(taskVO);
        return taskVOS;
    }
    /**
     * 4.查询历史流程变量(act_hi_varinst表)
     */
    @RequestMapping("/findHistoryProcessVariables")
    @ResponseBody
    public  List<HistoricVariableInstance> findHistoryProcessVariables(String processInstanceId){
        List<HistoricVariableInstance> list = historyService
                .createHistoricVariableInstanceQuery()                                      //创建一个历史的流程变量查询对象
                .processInstanceId(processInstanceId)
                .list();
        if(list !=null && list.size()>0){
            for(HistoricVariableInstance hvi:list){
                System.out.println(hvi.getId()+"   "+hvi.getProcessInstanceId()+"   "+hvi.getVariableName()+"   "+hvi.getVariableTypeName()+"    "+hvi.getValue());
                System.out.println("###############################################");
            }
        }
        return list;
    }

}
