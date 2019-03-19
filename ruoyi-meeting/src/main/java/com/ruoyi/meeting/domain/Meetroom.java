package com.ruoyi.meeting.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 会议室表 meetroom
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
public class Meetroom extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 会议室名称 */
	private String meetroomName;
	/** 会议室地址 */
	private String meetroomAddress;
	/** 是否关闭 */
	private String meetroomClosed;
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
	public void setMeetroomName(String meetroomName) 
	{
		this.meetroomName = meetroomName;
	}

	public String getMeetroomName() 
	{
		return meetroomName;
	}
	public void setMeetroomAddress(String meetroomAddress) 
	{
		this.meetroomAddress = meetroomAddress;
	}

	public String getMeetroomAddress() 
	{
		return meetroomAddress;
	}
	public void setMeetroomClosed(String meetroomClosed) 
	{
		this.meetroomClosed = meetroomClosed;
	}

	public String getMeetroomClosed() 
	{
		return meetroomClosed;
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
            .append("meetroomName", getMeetroomName())
            .append("meetroomAddress", getMeetroomAddress())
            .append("meetroomClosed", getMeetroomClosed())
            .append("createdTime", getCreatedTime())
            .append("updateBy", getUpdateBy())
            .append("updatedTime", getUpdatedTime())
            .append("createdBy", getCreatedBy())
            .append("remarks", getRemarks())
            .toString();
    }
}
