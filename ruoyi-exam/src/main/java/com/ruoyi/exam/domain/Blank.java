package com.ruoyi.exam.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 填空题表 exam_blank
 * 
 * @author ruoyi
 * @date 2019-06-12
 */
public class Blank extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 填空题ID */
	private String id;
	/** 题目 */
	private String title;
	/** 选项A */
	private String blankA;
	/** 选项B */
	private String blankB;
	/** 选项C */
	private String blankC;
	/** 选项D */
	private String blankD;
	/** 选项E */
	private String blankE;
	/** 选项F */
	private String blankF;
	/** 选项G */
	private String blankG;
	/** 选项H */
	private String blankH;
	/** 答案数量 */
	private String answerNum;
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
	public void setBlankA(String blankA) 
	{
		this.blankA = blankA;
	}

	public String getBlankA() 
	{
		return blankA;
	}
	public void setBlankB(String blankB) 
	{
		this.blankB = blankB;
	}

	public String getBlankB() 
	{
		return blankB;
	}
	public void setBlankC(String blankC) 
	{
		this.blankC = blankC;
	}

	public String getBlankC() 
	{
		return blankC;
	}
	public void setBlankD(String blankD) 
	{
		this.blankD = blankD;
	}

	public String getBlankD() 
	{
		return blankD;
	}
	public void setBlankE(String blankE) 
	{
		this.blankE = blankE;
	}

	public String getBlankE() 
	{
		return blankE;
	}
	public void setBlankF(String blankF) 
	{
		this.blankF = blankF;
	}

	public String getBlankF() 
	{
		return blankF;
	}
	public void setBlankG(String blankG) 
	{
		this.blankG = blankG;
	}

	public String getBlankG() 
	{
		return blankG;
	}
	public void setBlankH(String blankH) 
	{
		this.blankH = blankH;
	}

	public String getBlankH() 
	{
		return blankH;
	}
	public void setAnswerNum(String answerNum) 
	{
		this.answerNum = answerNum;
	}

	public String getAnswerNum() 
	{
		return answerNum;
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
            .append("blankA", getBlankA())
            .append("blankB", getBlankB())
            .append("blankC", getBlankC())
            .append("blankD", getBlankD())
            .append("blankE", getBlankE())
            .append("blankF", getBlankF())
            .append("blankG", getBlankG())
            .append("blankH", getBlankH())
            .append("answerNum", getAnswerNum())
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
