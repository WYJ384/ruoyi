package com.ruoyi.meeting.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 会议表 meeting
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
public class Meeting extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 会议名称 */
	private String meetingName;
	/** 会议主题 */
	private String meetingSubject;
	/** 会议开始时间 */
	private Date meetingBeginTime;
	/** 会议结束时间 */
	private Date meetingEndTime;
	/** 会议室id */
	private Integer meetroomId;
	/** 创建时间 */
	private Date createdTime;
	/** 修改人 */
	private String updateBy;
	/** 修改时间 */
	private Date updatedTime;
	/** 创建人 */
	private String createdBy;
	/** 备注 */
	private String remarks;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setMeetingName(String meetingName) 
	{
		this.meetingName = meetingName;
	}

	public String getMeetingName() 
	{
		return meetingName;
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
	public void setMeetroomId(Integer meetroomId) 
	{
		this.meetroomId = meetroomId;
	}

	public Integer getMeetroomId() 
	{
		return meetroomId;
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
	public void setCreatedBy(String createdBy) 
	{
		this.createdBy = createdBy;
	}

	public String getCreatedBy() 
	{
		return createdBy;
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
            .append("meetingName", getMeetingName())
            .append("meetingSubject", getMeetingSubject())
            .append("meetingBeginTime", getMeetingBeginTime())
            .append("meetingEndTime", getMeetingEndTime())
            .append("meetroomId", getMeetroomId())
            .append("createdTime", getCreatedTime())
            .append("updateBy", getUpdateBy())
            .append("updatedTime", getUpdatedTime())
            .append("createdBy", getCreatedBy())
            .append("remarks", getRemarks())
            .toString();
    }
}
