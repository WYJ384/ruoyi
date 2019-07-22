package com.ruoyi.meeting.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 会议记录表 meeting_record
 *
 * @author ruoyi
 * @date 2019-07-22
 */
public class MeetingRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private String id;
	/** 主办单位 */
	private String dept;
	/** 会议主题 */
	private String meetingSubject;
	/** 开始时间 */
	private Date meetingBeginTime;
	/** 结束时间 */
	private Date meetingEndTime;
	/** 会议内容 */
	private String meetingContent;
	/** 提交人 */
	private String submitPerson;
	/** 记录人 */
	private String recorder;
	/** 创建人 */
	private String createdBy;
	/** 创建时间 */
	private Date createdTime;
	/** 修改人 */
	private String updateBy;
	/** 修改时间 */
	private Date updatedTime;
	/** 备注 */
	private String remarks;

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}
	public void setDept(String dept)
	{
		this.dept = dept;
	}

	public String getDept()
	{
		return dept;
	}
	public void setMeetingSubject(String meetingSubject)
	{
		this.meetingSubject = meetingSubject;
	}

	public String getMeetingSubject()
	{
		return meetingSubject;
	}
	public void setMeetingBeginTime(Date meetingBeginTime)
	{
		this.meetingBeginTime = meetingBeginTime;
	}

	public Date getMeetingBeginTime()
	{
		return meetingBeginTime;
	}
	public void setMeetingEndTime(Date meetingEndTime)
	{
		this.meetingEndTime = meetingEndTime;
	}

	public Date getMeetingEndTime()
	{
		return meetingEndTime;
	}
	public void setMeetingContent(String meetingContent)
	{
		this.meetingContent = meetingContent;
	}

	public String getMeetingContent()
	{
		return meetingContent;
	}
	public void setSubmitPerson(String submitPerson)
	{
		this.submitPerson = submitPerson;
	}

	public String getSubmitPerson()
	{
		return submitPerson;
	}
	public void setRecorder(String recorder)
	{
		this.recorder = recorder;
	}

	public String getRecorder()
	{
		return recorder;
	}
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedTime(Date createdTime)
	{
		this.createdTime = createdTime;
	}

	public Date getCreatedTime()
	{
		return createdTime;
	}
	public void setUpdateBy(String updateBy)
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy()
	{
		return updateBy;
	}
	public void setUpdatedTime(Date updatedTime)
	{
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime()
	{
		return updatedTime;
	}
	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId())
				.append("dept", getDept())
				.append("meetingSubject", getMeetingSubject())
				.append("meetingBeginTime", getMeetingBeginTime())
				.append("meetingEndTime", getMeetingEndTime())
				.append("meetingContent", getMeetingContent())
				.append("submitPerson", getSubmitPerson())
				.append("recorder", getRecorder())
				.append("createdBy", getCreatedBy())
				.append("createdTime", getCreatedTime())
				.append("updateBy", getUpdateBy())
				.append("updatedTime", getUpdatedTime())
				.append("remarks", getRemarks())
				.toString();
	}
}
