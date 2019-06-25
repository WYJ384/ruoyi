package com.ruoyi.exam.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 考试表 exam_exam
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
public class Exam extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String id;
	/**  考试名称 */
	private String name;
	/** 考试说明 */
	private String description;
	/** 试卷 */
	private String examPaperId;
	/** 试卷批阅人 */
	private String readUserId;
	/** 有效期开始 */
	private Date beginTime;
	/** 有效期结束 */
	private Date endTime;
	/** 单次限时 */
	private Integer time;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateDate;
	/** 备注信息 */
	private String remark;
	/** 删除标记 */
	private String delFlag;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setExamPaperId(String examPaperId) 
	{
		this.examPaperId = examPaperId;
	}

	public String getExamPaperId() 
	{
		return examPaperId;
	}
	public void setReadUserId(String readUserId) 
	{
		this.readUserId = readUserId;
	}

	public String getReadUserId() 
	{
		return readUserId;
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
	public void setTime(Integer time) 
	{
		this.time = time;
	}

	public Integer getTime() 
	{
		return time;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("name", getName())
            .append("description", getDescription())
            .append("examPaperId", getExamPaperId())
            .append("readUserId", getReadUserId())
            .append("beginTime", getBeginTime())
            .append("endTime", getEndTime())
            .append("time", getTime())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
