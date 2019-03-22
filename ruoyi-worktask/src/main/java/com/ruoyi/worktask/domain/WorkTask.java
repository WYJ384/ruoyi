package com.ruoyi.worktask.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 工作任务表 work_task
 * 
 * @author ruoyi
 * @date 2019-03-20
 */
public class WorkTask extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 上级任务的id */
	private Integer pid;
	/** 工作任务名称 */
	private String workName;
	/** 进度 */
	private Integer rateProgress;
	/** 任务描述 */
	private String description;
	/** 任务开始时间 */
	private Date beginTime;
	/** 任务结束时间 */
	private Date endTime;
	/** 执行人 */
	private String userIds;
	/** 存在的问题 */
	private String openQuestion;
	/** 1重点工作 2班组 3个人任务 */
	private String workType;
	/** 1红灯2绿灯 3黄灯 */
	private String result;
	/** 任务完成工时 */
	private Integer workTime;
	/** 1进行中 2已完成 3 已归档 */
	private String workStatus;

	/** 删除标志（0代表存在 2代表删除）,默认0 */
	private String delFlag;

	private Integer userId;
	private boolean hasChild;

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/** 祖级列表 */
	private String ancestors;

	public String getAncestors() {
		return ancestors;
	}

	public void setAncestors(String ancestors) {
		this.ancestors = ancestors;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setPid(Integer pid) 
	{
		this.pid = pid;
	}

	public Integer getPid() 
	{
		return pid;
	}
	public void setWorkName(String workName) 
	{
		this.workName = workName;
	}

	public String getWorkName() 
	{
		return workName;
	}
	public void setRateProgress(Integer rateProgress) 
	{
		this.rateProgress = rateProgress;
	}

	public Integer getRateProgress() 
	{
		return rateProgress;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setBeginTime(Date beginTime) 
	{
		this.beginTime = beginTime;
	}

	public Date getBeginTime() 
	{
		return beginTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setUserIds(String userIds) 
	{
		this.userIds = userIds;
	}

	public String getUserIds() 
	{
		return userIds;
	}
	public void setOpenQuestion(String openQuestion) 
	{
		this.openQuestion = openQuestion;
	}

	public String getOpenQuestion() 
	{
		return openQuestion;
	}
	public void setWorkType(String workType) 
	{
		this.workType = workType;
	}

	public String getWorkType() 
	{
		return workType;
	}
	public void setResult(String result) 
	{
		this.result = result;
	}

	public String getResult() 
	{
		return result;
	}
	public void setWorkTime(Integer workTime) 
	{
		this.workTime = workTime;
	}

	public Integer getWorkTime() 
	{
		return workTime;
	}
	public void setWorkStatus(String workStatus) 
	{
		this.workStatus = workStatus;
	}

	public String getWorkStatus() 
	{
		return workStatus;
	}
	public void setDelFlag(String delFlag)
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pid", getPid())
            .append("workName", getWorkName())
            .append("rateProgress", getRateProgress())
            .append("description", getDescription())
            .append("beginTime", getBeginTime())
            .append("endTime", getEndTime())
            .append("userIds", getUserIds())
            .append("openQuestion", getOpenQuestion())
            .append("workType", getWorkType())
            .append("result", getResult())
            .append("workTime", getWorkTime())
            .append("workStatus", getWorkStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
