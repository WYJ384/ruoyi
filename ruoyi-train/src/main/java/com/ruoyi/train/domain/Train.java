package com.ruoyi.train.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 培训审批表 train
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
public class Train extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String id;
	/** 培训人员姓名 */
	private String userName;
	/** 培训人员id */
	private Long userId;
	/** 出发时间 */
	private Date startDate;
	/** 回程时间 */
	private Date endDate;
	/** 交通工具 */
	private String transportation;
	/** 出差类别 */
	private String trainType;
	/** 主办单位是否安排食宿 */
	private String isFood;
	/** 总经理 */
	private String zjl;
	/** 主管副总经理 */
	private String zfgzjl;
	/** 技术负责人 */
	private String jsfzr;
	/** 教育培训委员会办公室 */
	private String pxwyhbgs;
	/** 办公室 */
	private String bgs;
	/** 部门主任 */
	private String bmzr;
	/** 途程及住勤地点 */
	private String address;
	/** 申请状态 */
	private String trainStatus;
	/** 流程编号 */
	private String processInstanceId;
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

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getUserId()
	{
		return userId;
	}
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}
	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}
	public void setTransportation(String transportation) 
	{
		this.transportation = transportation;
	}

	public String getTransportation() 
	{
		return transportation;
	}
	public void setTrainType(String trainType) 
	{
		this.trainType = trainType;
	}

	public String getTrainType() 
	{
		return trainType;
	}
	public void setIsFood(String isFood) 
	{
		this.isFood = isFood;
	}

	public String getIsFood() 
	{
		return isFood;
	}
	public void setZjl(String zjl) 
	{
		this.zjl = zjl;
	}

	public String getZjl() 
	{
		return zjl;
	}
	public void setZfgzjl(String zfgzjl) 
	{
		this.zfgzjl = zfgzjl;
	}

	public String getZfgzjl() 
	{
		return zfgzjl;
	}
	public void setJsfzr(String jsfzr) 
	{
		this.jsfzr = jsfzr;
	}

	public String getJsfzr() 
	{
		return jsfzr;
	}
	public void setPxwyhbgs(String pxwyhbgs) 
	{
		this.pxwyhbgs = pxwyhbgs;
	}

	public String getPxwyhbgs() 
	{
		return pxwyhbgs;
	}
	public void setBgs(String bgs) 
	{
		this.bgs = bgs;
	}

	public String getBgs() 
	{
		return bgs;
	}
	public void setBmzr(String bmzr) 
	{
		this.bmzr = bmzr;
	}

	public String getBmzr() 
	{
		return bmzr;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setTrainStatus(String trainStatus) 
	{
		this.trainStatus = trainStatus;
	}

	public String getTrainStatus() 
	{
		return trainStatus;
	}
	public void setProcessInstanceId(String processInstanceId) 
	{
		this.processInstanceId = processInstanceId;
	}

	public String getProcessInstanceId() 
	{
		return processInstanceId;
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
            .append("id", getId())
            .append("userName", getUserName())
            .append("userId", getUserId())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("transportation", getTransportation())
            .append("trainType", getTrainType())
            .append("isFood", getIsFood())
            .append("zjl", getZjl())
            .append("zfgzjl", getZfgzjl())
            .append("jsfzr", getJsfzr())
            .append("pxwyhbgs", getPxwyhbgs())
            .append("bgs", getBgs())
            .append("bmzr", getBmzr())
            .append("address", getAddress())
            .append("trainStatus", getTrainStatus())
            .append("processInstanceId", getProcessInstanceId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
