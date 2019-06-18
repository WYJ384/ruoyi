package com.ruoyi.worktask.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 任务表 self_task
 * 
 * @author ruoyi
 * @date 2019-06-13
 */
public class QC extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String id;
	/** 任务级别0一级1二级 */
	private String taskLevel;
	/** 父任务 */
	private String pid;
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
	/** 创建时间 */
	private Date createTime;
	/** 修改人 */
	private String updateBy;
	/** 修改时间 */
	private Date updateTime;
	/** 创建人 */
	private String createBy;
	/** 备注 */
	private String remark;
	/** 任务类型 */
	private String taskType;
	/** 扩展1 */
	private String remark1;
	/** 扩展2 */
	private String remark2;
	/** 扩展3 */
	private String remark3;
	/** 扩展4 */
	private String remark4;
	/** 扩展5 */
	private String remark5;
	/** 扩展6 */
	private String remark6;
	/** 扩展7 */
	private String remark7;
	/** 扩展8 */
	private String remark8;
	/** 扩展9 */
	private String remark9;
	/** 扩展10 */
	private String remark10;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setTaskLevel(String taskLevel) 
	{
		this.taskLevel = taskLevel;
	}

	public String getTaskLevel() 
	{
		return taskLevel;
	}
	public void setPid(String pid) 
	{
		this.pid = pid;
	}

	public String getPid() 
	{
		return pid;
	}
	public void setTaskTitle(String taskTitle) 
	{
		this.taskTitle = taskTitle;
	}

	public String getTaskTitle() 
	{
		return taskTitle;
	}
	public void setTaskStatus(String taskStatus) 
	{
		this.taskStatus = taskStatus;
	}

	public String getTaskStatus() 
	{
		return taskStatus;
	}
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}
	public void setRequireTime(Date requireTime) 
	{
		this.requireTime = requireTime;
	}

	public Date getRequireTime() 
	{
		return requireTime;
	}
	public void setSelvalTaskType(String selvalTaskType) 
	{
		this.selvalTaskType = selvalTaskType;
	}

	public String getSelvalTaskType() 
	{
		return selvalTaskType;
	}
	public void setPriority(String priority) 
	{
		this.priority = priority;
	}

	public String getPriority() 
	{
		return priority;
	}
	public void setTaskContent(String taskContent) 
	{
		this.taskContent = taskContent;
	}

	public String getTaskContent() 
	{
		return taskContent;
	}
	public void setExecutorUser(String executorUser) 
	{
		this.executorUser = executorUser;
	}

	public String getExecutorUser() 
	{
		return executorUser;
	}
	public void setAcceptorUser(String acceptorUser) 
	{
		this.acceptorUser = acceptorUser;
	}

	public String getAcceptorUser() 
	{
		return acceptorUser;
	}
	public void setTaskProgress(String taskProgress) 
	{
		this.taskProgress = taskProgress;
	}

	public String getTaskProgress() 
	{
		return taskProgress;
	}
	public void setShareUser(String shareUser) 
	{
		this.shareUser = shareUser;
	}

	public String getShareUser() 
	{
		return shareUser;
	}
	public void setIsShare(String isShare) 
	{
		this.isShare = isShare;
	}

	public String getIsShare() 
	{
		return isShare;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setTaskType(String taskType) 
	{
		this.taskType = taskType;
	}

	public String getTaskType() 
	{
		return taskType;
	}
	public void setRemark1(String remark1) 
	{
		this.remark1 = remark1;
	}

	public String getRemark1() 
	{
		return remark1;
	}
	public void setRemark2(String remark2) 
	{
		this.remark2 = remark2;
	}

	public String getRemark2() 
	{
		return remark2;
	}
	public void setRemark3(String remark3) 
	{
		this.remark3 = remark3;
	}

	public String getRemark3() 
	{
		return remark3;
	}
	public void setRemark4(String remark4) 
	{
		this.remark4 = remark4;
	}

	public String getRemark4() 
	{
		return remark4;
	}
	public void setRemark5(String remark5) 
	{
		this.remark5 = remark5;
	}

	public String getRemark5() 
	{
		return remark5;
	}
	public void setRemark6(String remark6) 
	{
		this.remark6 = remark6;
	}

	public String getRemark6() 
	{
		return remark6;
	}
	public void setRemark7(String remark7) 
	{
		this.remark7 = remark7;
	}

	public String getRemark7() 
	{
		return remark7;
	}
	public void setRemark8(String remark8) 
	{
		this.remark8 = remark8;
	}

	public String getRemark8() 
	{
		return remark8;
	}
	public void setRemark9(String remark9) 
	{
		this.remark9 = remark9;
	}

	public String getRemark9() 
	{
		return remark9;
	}
	public void setRemark10(String remark10) 
	{
		this.remark10 = remark10;
	}

	public String getRemark10() 
	{
		return remark10;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskLevel", getTaskLevel())
            .append("pid", getPid())
            .append("taskTitle", getTaskTitle())
            .append("taskStatus", getTaskStatus())
            .append("startDate", getStartDate())
            .append("requireTime", getRequireTime())
            .append("selvalTaskType", getSelvalTaskType())
            .append("priority", getPriority())
            .append("taskContent", getTaskContent())
            .append("executorUser", getExecutorUser())
            .append("acceptorUser", getAcceptorUser())
            .append("taskProgress", getTaskProgress())
            .append("shareUser", getShareUser())
            .append("isShare", getIsShare())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("remark", getRemark())
            .append("taskType", getTaskType())
            .append("remark1", getRemark1())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .append("remark6", getRemark6())
            .append("remark7", getRemark7())
            .append("remark8", getRemark8())
            .append("remark9", getRemark9())
            .append("remark10", getRemark10())
            .toString();
    }
}
