package com.ruoyi.exam.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 试卷-试题表 exam_paper_question
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
public class PaperQuestion extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 试卷 */
	private String examPaperId;
	/** 试题 */
	private String questionId;
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
	/** 备注信息 */
	private String remark2;
	/** 备注信息 */
	private String remark3;
	/** 备注信息 */
	private String remark4;
	/** 备注信息 */
	private String remark5;
	/** 备注信息 */
	private String remark6;
	private String title;
	/** 排序 */
	private Integer orderNum;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private LibraryDetail libraryDetail;

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}



	public LibraryDetail getLibraryDetail() {
		return libraryDetail;
	}

	public void setLibraryDetail(LibraryDetail libraryDetail) {
		this.libraryDetail = libraryDetail;
	}

	public void setExamPaperId(String examPaperId)
	{
		this.examPaperId = examPaperId;
	}

	public String getExamPaperId() 
	{
		return examPaperId;
	}
	public void setQuestionId(String questionId) 
	{
		this.questionId = questionId;
	}

	public String getQuestionId() 
	{
		return questionId;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("examPaperId", getExamPaperId())
            .append("questionId", getQuestionId())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .append("remark6", getRemark6())
            .toString();
    }
}
