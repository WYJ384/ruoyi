package com.ruoyi.exam.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 试卷表 exam_paper
 * 
 * @author ruoyi
 * @date 2019-06-19
 */
public class Paper extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String id;
	/** 试卷名称 */
	private String name;
	/** 权限设置0私密1公开 */
	private String permission;
	/** 0固定出题、1随机出题 */
	private String questionMethod;
	/** 总题数 */
	private Integer totalQuestion;
	/** 总分 */
	private Integer totalSore;
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
	/** 状态 */
	private String status;

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
	public void setPermission(String permission) 
	{
		this.permission = permission;
	}

	public String getPermission() 
	{
		return permission;
	}
	public void setQuestionMethod(String questionMethod) 
	{
		this.questionMethod = questionMethod;
	}

	public String getQuestionMethod() 
	{
		return questionMethod;
	}
	public void setTotalQuestion(Integer totalQuestion) 
	{
		this.totalQuestion = totalQuestion;
	}

	public Integer getTotalQuestion() 
	{
		return totalQuestion;
	}
	public void setTotalSore(Integer totalSore) 
	{
		this.totalSore = totalSore;
	}

	public Integer getTotalSore() 
	{
		return totalSore;
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
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("permission", getPermission())
            .append("questionMethod", getQuestionMethod())
            .append("totalQuestion", getTotalQuestion())
            .append("totalSore", getTotalSore())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .toString();
    }
}
