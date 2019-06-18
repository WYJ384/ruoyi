package com.ruoyi.jobsumm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 工作总结表 jobsummary
 * 
 * @author ruoyi
 * @date 2019-06-14
 */
public class Jobsummary extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 工作总结ID */
	private String id;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 开始时间 */
	private Date stratTime;
	/** 结束时间 */
	private Date endTime;
	/** 总结类型 1：周报、2：月报、3：年报 */
	private String jobType;
	/** 工作内容 */
	private String jobContent;
	/** 工作总结 */
	private String jobSumm;
	/** 工作计划 */
	private String jobPlan;
	/** 提交人 */
	private String submitBy;
	/** 备注信息 */
	private String remark;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateDate;
	/** 删除标记 */
	private String delFlag;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
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
	public void setStratTime(Date stratTime) 
	{
		this.stratTime = stratTime;
	}

	public Date getStratTime() 
	{
		return stratTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setJobType(String jobType) 
	{
		this.jobType = jobType;
	}

	public String getJobType() 
	{
		return jobType;
	}
	public void setJobContent(String jobContent) 
	{
		this.jobContent = jobContent;
	}

	public String getJobContent() 
	{
		return jobContent;
	}
	public void setJobSumm(String jobSumm) 
	{
		this.jobSumm = jobSumm;
	}

	public String getJobSumm() 
	{
		return jobSumm;
	}
	public void setJobPlan(String jobPlan) 
	{
		this.jobPlan = jobPlan;
	}

	public String getJobPlan() 
	{
		return jobPlan;
	}
	public void setSubmitBy(String submitBy) 
	{
		this.submitBy = submitBy;
	}

	public String getSubmitBy() 
	{
		return submitBy;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("stratTime", getStratTime())
            .append("endTime", getEndTime())
            .append("jobType", getJobType())
            .append("jobContent", getJobContent())
            .append("jobSumm", getJobSumm())
            .append("jobPlan", getJobPlan())
            .append("submitBy", getSubmitBy())
            .append("remark", getRemark())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
