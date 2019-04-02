package com.ruoyi.taskscore.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 评分活动详情表 score_activity_detail
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public class ScoreActivityDetail extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 活动id */
	private String activityId;
	private ScoreActivity scoreActivity;
	/** 评分指标 */
	private String scorePointerId;
	private	ScoringPointer scoringPointer;
	/** 得分 */
	private Double score;
	/** 评分描述 */
	private String scoreDescription;

	/** 删除标志 */
	private String delFlag;
	/** 任务状态 1 进行中 2 已完成 */
	private String activityStatus;

	private String evalDeptId;

	public String getEvalDeptId() {
		return evalDeptId;
	}

	public void setEvalDeptId(String evalDeptId) {
		this.evalDeptId = evalDeptId;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	public ScoreActivity getScoreActivity() {
		return scoreActivity;
	}

	public void setScoreActivity(ScoreActivity scoreActivity) {
		this.scoreActivity = scoreActivity;
	}

	public ScoringPointer getScoringPointer() {
		return scoringPointer;
	}

	public void setScoringPointer(ScoringPointer scoringPointer) {
		this.scoringPointer = scoringPointer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getScorePointerId() {
		return scorePointerId;
	}

	public void setScorePointerId(String scorePointerId) {
		this.scorePointerId = scorePointerId;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getScoreDescription() {
		return scoreDescription;
	}

	public void setScoreDescription(String scoreDescription) {
		this.scoreDescription = scoreDescription;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
