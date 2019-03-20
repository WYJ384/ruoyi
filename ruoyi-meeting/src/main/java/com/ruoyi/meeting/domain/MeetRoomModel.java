package com.ruoyi.meeting.domain;

import java.util.Date;

/**
 * 会议表 meeting
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
public class MeetRoomModel
{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String id;
	private String eventColor;

	public String getEventColor() {
		return eventColor;
	}

	public void setEventColor(String eventColor) {
		this.eventColor = eventColor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
