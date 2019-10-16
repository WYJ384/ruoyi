package com.ruoyi.quartz.task;

import com.ruoyi.activiti.domain.HistoryTaskVo;
import com.ruoyi.web.controller.MsgSendService;
import com.ruoyi.worktask.domain.WorkTask;
import com.ruoyi.worktask.domain.WorkTaskActivity;
import com.ruoyi.worktask.service.IWorkTaskActivityService;
import com.ruoyi.worktask.service.IWorkTaskService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("nocTask")
public class NocTask
{
    @Autowired
    private IWorkTaskService workTaskService;
    @Autowired
    private MsgSendService msgSendService;
    @Autowired
    private IWorkTaskActivityService workTaskActivityService;
    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }

    /**
     * 专项工作添加月度目标提醒
     */
    public void selectNoTargetWorkList() {
        WorkTask workTask = new WorkTask();
        workTask.setTargetMonth(DateFormatUtils.format(new Date(),"MM"));
        List<WorkTask> workTasks = workTaskService.selectNoTargetWorkList(workTask);
        Iterator<WorkTask> iterator = workTasks.iterator();
        while (iterator.hasNext()){
            WorkTask task = iterator.next();
            String phone = task.getPid();
            msgSendService.send("请为专项工作："+task.getWorkName()+"添加月度目标",new String[]{phone});
        }

    }

    /**
     * 个人提交专项提醒
     */
    public void  addContent(){
        String msg="请提交专项工作:${workName}";
        sendMsg("待提交",msg);
    }

    public void sendMsg(String type,String msg){
        WorkTaskActivity workTaskActivity=new WorkTaskActivity();
        workTaskActivity.setTargetMonth(DateFormatUtils.format(new Date(),"MM"));
        List<WorkTaskActivity> list = workTaskActivityService.selectWorkTaskActivityListPhone(workTaskActivity);
        Iterator<WorkTaskActivity> workTaskActivityIterator = list.iterator();
        while (workTaskActivityIterator.hasNext()){
            WorkTaskActivity taskActivity = workTaskActivityIterator.next();
            String desc = taskActivity.getDelFlag();
            if(StringUtils.isNoneEmpty(desc)){
                if(desc.equals(type)){
                    List<HistoryTaskVo> historyTaskVos = taskActivity.getHistoryTaskVos();
                    if(historyTaskVos!=null&&historyTaskVos.size()>0){
                        HistoryTaskVo historyTaskVo = historyTaskVos.get(historyTaskVos.size() - 1);
                        String queryVariables = historyTaskVo.getQueryVariables();
                        String[] phons = queryVariables.split(",");
                        String workName = workTaskService.selectWorkTaskById(taskActivity.getWorkTaskId()).getWorkName();
                        String a=msg.replace("${workName}",workName);
                        System.out.println(taskActivity.getId()+a);
                        msgSendService.send(a,phons);
                    }
                }
            }
        }
    }

    /**
     * 领导评分提醒
     */
    public void  addScore(){
        String msg="请为专项工作:${workName}评分";
        sendMsg("待评分",msg);
    }

    /**
     * 分配任务提醒
     */
    public void  fenpeiUser(){
        String msg="请为专项工作:${workName}分配执行人";
        sendMsg("待分配",msg);
    }
}
