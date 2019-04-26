package com.ruoyi.activiti.domain;

import java.util.Date;

/**
 * 历史活动数据
 */
public class HistoryTaskVo {


    //开始时间
    private Date startTime;

    //结束时间
    private Date endTime;

    //办理时长
    private Long durationInMillis;

    //节点名称
    private String activityName;
    //执行人
    private String assignee;

    //下一步任务执行人
    private String queryVariables;
    //节点id 如zhurenduban
    private String  taskDefinitionKey;
    //任务描述
    private String  description;
    private long datePoorHour;

    public long getDatePoorHour() {
        return datePoorHour;
    }

    public void setDatePoorHour(long datePoorHour) {
        this.datePoorHour = datePoorHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getDurationInMillis() {
        return durationInMillis;
    }

    public void setDurationInMillis(Long durationInMillis) {
        this.durationInMillis = durationInMillis;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getQueryVariables() {
        return queryVariables;
    }

    public void setQueryVariables(String queryVariables) {
        this.queryVariables = queryVariables;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }
}
