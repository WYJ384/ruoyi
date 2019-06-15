package com.ruoyi.exam.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 多选题表 exam_mult_choice
 * 
 * @author ruoyi
 * @date 2019-06-14
 */
public class MultChoice extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 多选题ID */
	private String id;
	/** 题目 */
	private String title;
	/** 选项A */
	private String choiceA;
	/** 选项B */
	private String choiceB;
	/** 选项C */
	private String choiceC;
	/** 选项D */
	private String choiceD;
	/** 选项E */
	private String choiceE;
	/** 选项F */
	private String choiceF;
	/** 选项G */
	private String choiceG;
	/** 选项H */
	private String choiceH;
	/** 答案 */
	private String answer;
	/** 解析 */
	private String answerTip;
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
	/** 题库 */
	private String libId;

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
	public void setChoiceA(String choiceA) 
	{
		this.choiceA = choiceA;
	}

	public String getChoiceA() 
	{
		return choiceA;
	}
	public void setChoiceB(String choiceB) 
	{
		this.choiceB = choiceB;
	}

	public String getChoiceB() 
	{
		return choiceB;
	}
	public void setChoiceC(String choiceC) 
	{
		this.choiceC = choiceC;
	}

	public String getChoiceC() 
	{
		return choiceC;
	}
	public void setChoiceD(String choiceD) 
	{
		this.choiceD = choiceD;
	}

	public String getChoiceD() 
	{
		return choiceD;
	}
	public void setChoiceE(String choiceE) 
	{
		this.choiceE = choiceE;
	}

	public String getChoiceE() 
	{
		return choiceE;
	}
	public void setChoiceF(String choiceF) 
	{
		this.choiceF = choiceF;
	}

	public String getChoiceF() 
	{
		return choiceF;
	}
	public void setChoiceG(String choiceG) 
	{
		this.choiceG = choiceG;
	}

	public String getChoiceG() 
	{
		return choiceG;
	}
	public void setChoiceH(String choiceH) 
	{
		this.choiceH = choiceH;
	}

	public String getChoiceH() 
	{
		return choiceH;
	}
	public void setAnswer(String answer) 
	{
		this.answer = answer;
	}

	public String getAnswer() 
	{
		return answer;
	}
	public void setAnswerTip(String answerTip) 
	{
		this.answerTip = answerTip;
	}

	public String getAnswerTip() 
	{
		return answerTip;
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
	public void setLibId(String libId) 
	{
		this.libId = libId;
	}

	public String getLibId() 
	{
		return libId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("choiceA", getChoiceA())
            .append("choiceB", getChoiceB())
            .append("choiceC", getChoiceC())
            .append("choiceD", getChoiceD())
            .append("choiceE", getChoiceE())
            .append("choiceF", getChoiceF())
            .append("choiceG", getChoiceG())
            .append("choiceH", getChoiceH())
            .append("answer", getAnswer())
            .append("answerTip", getAnswerTip())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("libId", getLibId())
            .toString();
    }
}
