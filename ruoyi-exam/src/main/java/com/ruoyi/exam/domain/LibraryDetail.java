package com.ruoyi.exam.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 题库内容表 exam_library_detail
 * 
 * @author ruoyi
 * @date 2019-06-17
 */
public class LibraryDetail extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 单选题ID */
	private String id;
	@Excel(name = "题型", prompt = "题型")
	/** 题型 */
	private String libType;
	@Excel(name = "题目", prompt = "题目")
	/** 题目 */
	private String title;

	/** 选项A */
	@Excel(name = "选项A", prompt = "选项A")
	private String choiceA;
	@Excel(name = "选项B", prompt = "选项B")
	/** 选项B */
	private String choiceB;
	/** 选项C */
	@Excel(name = "选项C", prompt = "choiceC")
	private String choiceC;
	/** 选项D */
	@Excel(name = "选项D", prompt = "choiceD")
	private String choiceD;
	/** 选项E */
	@Excel(name = "选项E", prompt = "choiceE")
	private String choiceE;
	/** 选项F */
	@Excel(name = "选项F", prompt = "choiceE")
	private String choiceF;
	/** 选项G */
	@Excel(name = "选项G", prompt = "choiceG")
	private String choiceG;
	/** 选项H */
	@Excel(name = "选项H", prompt = "choiceH")
	private String choiceH;
	/** 答案 */
	@Excel(name = "答案", prompt = "answer")
	private String answer;
	/** 解析 */
	@Excel(name = "解析", prompt = "answerTip")
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
	/** 扩展1 */
	private String remark1;
	/** 扩展2 */
	private String remark2;
	/** 扩展3 */
	private String remark3;
	/** 扩展4 */
	private String remark4;
	/** 扩展5 */
	private String remark5;
	/** 扩展6 */
	private String remark6;
	/** 扩展7 */
	private String remark7;
	/** 扩展8 */
	private String remark8;
	/** 扩展9 */
	private String remark9;
	/** 扩展10 */
	private String remark10;
	//辅助查询
	private String examPaperId;

	public String getExamPaperId() {
		return examPaperId;
	}

	public void setExamPaperId(String examPaperId) {
		this.examPaperId = examPaperId;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setLibType(String libType) 
	{
		this.libType = libType;
	}

	public String getLibType() 
	{
		return libType;
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
	public void setRemark1(String remark1) 
	{
		this.remark1 = remark1;
	}

	public String getRemark1() 
	{
		return remark1;
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
	public void setRemark8(String remark8) 
	{
		this.remark8 = remark8;
	}

	public String getRemark8() 
	{
		return remark8;
	}
	public void setRemark9(String remark9) 
	{
		this.remark9 = remark9;
	}

	public String getRemark9() 
	{
		return remark9;
	}
	public void setRemark10(String remark10) 
	{
		this.remark10 = remark10;
	}

	public String getRemark10() 
	{
		return remark10;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("libType", getLibType())
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
            .append("remark1", getRemark1())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .append("remark6", getRemark6())
            .append("remark7", getRemark7())
            .append("remark8", getRemark8())
            .append("remark9", getRemark9())
            .append("remark10", getRemark10())
            .toString();
    }
}
