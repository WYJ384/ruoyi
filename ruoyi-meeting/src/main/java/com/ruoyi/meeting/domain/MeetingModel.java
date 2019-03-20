package com.ruoyi.meeting.domain;

import java.util.Date;

/**
 * 会议表 meeting
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
public class MeetingModel
{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String resourceId;
	private String id;
	private Date start;
	private Date end;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
}
