package com.ruoyi.exam.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 考试成绩表 exam_result
 * 
 * @author ruoyi
 * @date 2019-06-25
 */
public class Result extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String examId;
	/** 试题 */
	private String questionId;
	/**  */
	private String userId;
	/** 成绩 */
	private String score;
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
	/** 考生答案 */
	private String questionAnwser;

	public void setExamId(String examId) 
	{
		this.examId = examId;
	}

	public String getExamId() 
	{
		return examId;
	}
	public void setQuestionId(String questionId) 
	{
		this.questionId = questionId;
	}

	public String getQuestionId() 
	{
		return questionId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setScore(String score) 
	{
		this.score = score;
	}

	public String getScore() 
	{
		return score;
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
	public void setQuestionAnwser(String questionAnwser) 
	{
		this.questionAnwser = questionAnwser;
	}

	public String getQuestionAnwser() 
	{
		return questionAnwser;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("examId", getExamId())
            .append("questionId", getQuestionId())
            .append("userId", getUserId())
            .append("score", getScore())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("questionAnwser", getQuestionAnwser())
            .toString();
    }
}
