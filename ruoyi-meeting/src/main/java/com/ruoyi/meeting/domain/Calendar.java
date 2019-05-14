package com.ruoyi.meeting.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 日程表 date_calendar
 * 
 * @author ruoyi
 * @date 2019-05-14
 */
public class Calendar extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 标题 */
	private String title;
	/** 开始时间 */
	private String start;
	/** 结束时间 */
	private String end;
	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;
	/** 备注 */
	private String remark2;
	/** 备注 */
	private String remark3;
	/** 备注 */
	private String remark4;
	/** 备注 */
	private String remark5;
	/** 备注 */
	private String remark6;
	/** 备注 */
	private String remark7;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setStart(String start) 
	{
		this.start = start;
	}

	public String getStart() 
	{
		return start;
	}
	public void setEnd(String end) 
	{
		this.end = end;
	}

	public String getEnd() 
	{
		return end;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
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
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("start", getStart())
            .append("end", getEnd())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .append("remark6", getRemark6())
            .append("remark7", getRemark7())
            .toString();
    }
}
