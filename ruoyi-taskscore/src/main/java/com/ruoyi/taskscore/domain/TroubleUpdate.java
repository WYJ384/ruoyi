package com.ruoyi.taskscore.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 隐患整改表 trouble_update
 * 
 * @author ruoyi
 * @date 2019-04-22
 */
public class TroubleUpdate extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String troId;
	/** 问题类别 */
	private String troTypeId;
	/** 分项 */
	private String troSubitem;
	/** 具体问题 */
	private String troQuestion;
	/**  */
	private String troTarget;
	/** 措施及建议 */
	private String troSuggest;
	/** 责任部门 */
	private String leadDeptId;
	/** 配合部门 */
	private String cooperateDeptId;
	/**  */
	private Date troFinishTime;
	/** 责任人 */
	private String dutyUserIds;
	/**  */
	private String troStatus;
	/**  */
	private String troProgress;
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

	public void setTroId(String troId) 
	{
		this.troId = troId;
	}

	public String getTroId() 
	{
		return troId;
	}
	public void setTroTypeId(String troTypeId) 
	{
		this.troTypeId = troTypeId;
	}

	public String getTroTypeId() 
	{
		return troTypeId;
	}
	public void setTroSubitem(String troSubitem) 
	{
		this.troSubitem = troSubitem;
	}

	public String getTroSubitem() 
	{
		return troSubitem;
	}
	public void setTroQuestion(String troQuestion) 
	{
		this.troQuestion = troQuestion;
	}

	public String getTroQuestion() 
	{
		return troQuestion;
	}
	public void setTroTarget(String troTarget) 
	{
		this.troTarget = troTarget;
	}

	public String getTroTarget() 
	{
		return troTarget;
	}
	public void setTroSuggest(String troSuggest) 
	{
		this.troSuggest = troSuggest;
	}

	public String getTroSuggest() 
	{
		return troSuggest;
	}
	public void setLeadDeptId(String leadDeptId) 
	{
		this.leadDeptId = leadDeptId;
	}

	public String getLeadDeptId() 
	{
		return leadDeptId;
	}
	public void setCooperateDeptId(String cooperateDeptId) 
	{
		this.cooperateDeptId = cooperateDeptId;
	}

	public String getCooperateDeptId() 
	{
		return cooperateDeptId;
	}
	public void setTroFinishTime(Date troFinishTime) 
	{
		this.troFinishTime = troFinishTime;
	}

	public Date getTroFinishTime() 
	{
		return troFinishTime;
	}
	public void setDutyUserIds(String dutyUserIds) 
	{
		this.dutyUserIds = dutyUserIds;
	}

	public String getDutyUserIds() 
	{
		return dutyUserIds;
	}
	public void setTroStatus(String troStatus) 
	{
		this.troStatus = troStatus;
	}

	public String getTroStatus() 
	{
		return troStatus;
	}
	public void setTroProgress(String troProgress) 
	{
		this.troProgress = troProgress;
	}

	public String getTroProgress() 
	{
		return troProgress;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("troId", getTroId())
            .append("troTypeId", getTroTypeId())
            .append("troSubitem", getTroSubitem())
            .append("troQuestion", getTroQuestion())
            .append("troTarget", getTroTarget())
            .append("troSuggest", getTroSuggest())
            .append("leadDeptId", getLeadDeptId())
            .append("cooperateDeptId", getCooperateDeptId())
            .append("troFinishTime", getTroFinishTime())
            .append("dutyUserIds", getDutyUserIds())
            .append("troStatus", getTroStatus())
            .append("troProgress", getTroProgress())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
