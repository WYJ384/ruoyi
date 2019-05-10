package com.ruoyi.worktask.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 任务表 self_task
 * 
 * @author ruoyi
 * @date 2019-05-10
 */
public class SelfTask extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String id;
	/** 任务标题 */
	private String taskTitle;
	/** 0进行中1已完成 */
	private String taskStatus;
	/** 开始时间 */
	private Date startDate;
	/** 要求完成时间 */
	private Date requireTime;
	/** 任务类型 */
	private String selvalTaskType;
	/** 优先级0高1中2低 */
	private String priority;
	/** 任务描述 */
	private String taskContent;
	/** 任务执行人 */
	private String executorUser;
	/** 任务验收人 */
	private String acceptorUser;
	/** 任务进度 */
	private String taskProgress;
	/** 任务共享人 */
	private String shareUser;
	/** 共享给 */
	private String isShare;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getRequireTime() {
		return requireTime;
	}

	public void setRequireTime(Date requireTime) {
		this.requireTime = requireTime;
	}

	public String getSelvalTaskType() {
		return selvalTaskType;
	}

	public void setSelvalTaskType(String selvalTaskType) {
		this.selvalTaskType = selvalTaskType;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public String getExecutorUser() {
		return executorUser;
	}

	public void setExecutorUser(String executorUser) {
		this.executorUser = executorUser;
	}

	public String getAcceptorUser() {
		return acceptorUser;
	}

	public void setAcceptorUser(String acceptorUser) {
		this.acceptorUser = acceptorUser;
	}

	public String getTaskProgress() {
		return taskProgress;
	}

	public void setTaskProgress(String taskProgress) {
		this.taskProgress = taskProgress;
	}

	public String getShareUser() {
		return shareUser;
	}

	public void setShareUser(String shareUser) {
		this.shareUser = shareUser;
	}

	public String getIsShare() {
		return isShare;
	}

	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}
}
