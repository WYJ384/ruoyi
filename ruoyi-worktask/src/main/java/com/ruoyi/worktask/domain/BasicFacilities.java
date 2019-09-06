package com.ruoyi.worktask.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 基础维护管理 self_task
 *
 * @author ruoyi
 * @date 2019-06-13
 */
public class BasicFacilities extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private String id;
	/** 项目 */
	@Excel(name = "项目", prompt = "项目")
	private String taskTitle;
	/** 工作内容 */
	@Excel(name = "工作内容", prompt = "工作内容")
	private String remark5;
	/** 配合人 */
	@Excel(name = "配合人", prompt = "配合人")
	private String remark3;
	/** 开始时间 */
	@Excel(name = "开始时间", prompt = "开始时间")
	private Date startDate;
	/** 要求完成时间 */
	@Excel(name = "要求完成时间", prompt = "要求完成时间")
	private Date requireTime;
	/** 牵头人 */
	@Excel(name = "牵头人", prompt = "牵头人")
	private String executorUser;
	/** 任务验收人 */
	@Excel(name = "任务验收人", prompt = "任务验收人")
	private String acceptorUser;

	/** 任务级别0一级1二级 */
	private String taskLevel;
	/** 父任务 */
	private String pid;
	/** 0进行中1已完成 */
	private String taskStatus;
	/** 任务类型 */
	private String selvalTaskType;
	/** 优先级0高1中2低 */
	private String priority;
	/** 任务进度 */
	private String taskProgress;
	/** 任务共享人 */
	private String shareUser;
	/** 共享给 */
	private String isShare;
	/** 创建时间 */
	private Date createTime;
	/** 修改人 */
	private String updateBy;
	/** 修改时间 */
	private Date updateTime;
	/** 创建人 */
	private String createBy;
	/**牵头人姓名*/
	private String remark;
	/**配合人姓名*/
	private String remark4;
	/** 任务类型 */
	private String taskType;
	/** 扩展7 */
	private String remark7;
	/** 扩展8 */
	private String remark8;
	/** 扩展9 */
	private String remark9;
	/** 扩展10 */
	private String remark10;
    /** 牵头人 */
    private SysUser user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTaskTitle(String taskTitle)
	{
		this.taskTitle = taskTitle;
	}

	public String getTaskTitle()
	{
		return taskTitle;
	}

	public String getRemark5() {
		return remark5;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
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

	public String getTaskLevel() {
		return taskLevel;
	}

	public String getRemark4() {
		return remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public void setTaskLevel(String taskLevel) {
		this.taskLevel = taskLevel;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
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

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String getUpdateBy() {
		return updateBy;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String getCreateBy() {
		return createBy;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getRemark7() {
		return remark7;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	public String getRemark8() {
		return remark8;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	public String getRemark9() {
		return remark9;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	public String getRemark10() {
		return remark10;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}
}
