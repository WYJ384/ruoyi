package com.ruoyi.worktask.domain;

import com.ruoyi.activiti.domain.TaskVO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.util.List;
import org.activiti.engine.task.Task;
/**
 * 专项工作汇报内容表 work_task_activity
 *
 * @author ruoyi
 * @date 2019-03-26
 */
public class WorkTaskActivity extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private String id;
	/** 任务的id */
	private String workTaskId;
	private WorkTask workTask;
	/** 汇报内容 */
	private String content;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 删除标志（0代表存在 2代表删除）,默认0 */
	private String delFlag;
	/** 备注 */
	private String remark;
	/** 存在问题内容 */
	private String repContent;


	/** 目标 */
	private String target;
	/** 目标得分 */
	private Double targetScore;
	/** 目标月份 */
	private String targetMonth;
	/** 任务状态 1进行中 2已完成 */
	private String workStatus;
	/** 显示顺序 */
	private Integer orderNum;
	/** 是否是进行中任务 */
	private boolean isCurrent=false;

	private String process_instance_id;

	private TaskVO taskVO;


	public WorkTask getWorkTask() {
		return workTask;
	}

	public void setWorkTask(WorkTask workTask) {
		this.workTask = workTask;
	}

	public TaskVO getTaskVO() {
		return taskVO;
	}

	public void setTaskVO(TaskVO taskVO) {
		this.taskVO = taskVO;
	}

	public String getProcess_instance_id() {
        return process_instance_id;
    }

    public void setProcess_instance_id(String process_instance_id) {
        this.process_instance_id = process_instance_id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    Task task;
	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean current) {
		isCurrent = current;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	List<WorkTaskFile> workTaskFiles;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Double getTargetScore() {
		return targetScore;
	}

	public void setTargetScore(Double targetScore) {
		this.targetScore = targetScore;
	}

	public String getTargetMonth() {
		return targetMonth;
	}

	public void setTargetMonth(String targetMonth) {
		this.targetMonth = targetMonth;
	}

	public List<WorkTaskFile> getWorkTaskFiles() {
		return workTaskFiles;
	}

	public void setWorkTaskFiles(List<WorkTaskFile> workTaskFiles) {
		this.workTaskFiles = workTaskFiles;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}
	public void setWorkTaskId(String workTaskId)
	{
		this.workTaskId = workTaskId;
	}

	public String getWorkTaskId()
	{
		return workTaskId;
	}
	public void setContent(String content)
	{
		this.content = content;
	}

	public String getContent()
	{
		return content;
	}
	public void setCreateBy(String createBy)
	{
		this.createBy = createBy;
	}

	public String getCreateBy()
	{
		return createBy;
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
	public void setDelFlag(String delFlag)
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag()
	{
		return delFlag;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getRemark()
	{
		return remark;
	}
	public void setRepContent(String repContent)
	{
		this.repContent = repContent;
	}

	public String getRepContent()
	{
		return repContent;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("workTaskId", getWorkTaskId())
            .append("content", getContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("repContent", getRepContent())
            .toString();
    }
}
