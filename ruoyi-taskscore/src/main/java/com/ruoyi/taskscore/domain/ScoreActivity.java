package com.ruoyi.taskscore.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 评分活动表 score_activity
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public class ScoreActivity extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 活动名称 */
	private String name;
	/** 活动状态 */
	private Integer status;
	/** 开始时间 */
	private String beginTime;
	/** 结束时间 */
	private Date endTime;
	/** 评分指标ID */
	private String scoringPointerId;

	/** 删除标志 */
	private String delFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getScoringPointerId() {
		return scoringPointerId;
	}

	public void setScoringPointerId(String scoringPointerId) {
		this.scoringPointerId = scoringPointerId;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
