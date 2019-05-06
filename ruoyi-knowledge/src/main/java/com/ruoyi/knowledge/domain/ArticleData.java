package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章详表 cms_article_data
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
public class ArticleData extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private String id;
	/** 文章内容 */
	private String content;
	/** 文章来源 */
	private String copyfrom;
	/** 相关文章 */
	private String relation;
	/** 是否允许评论 */
	private String allowComment;
	/** 现象 */
	private String appearance;
	/** 原因分析 */
	private String reason;
	/** 解决方案 */
	private String solution;
	/**  */
	private String remark1;
	/**  */
	private String remark2;
	/**  */
	private String remark3;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setCopyfrom(String copyfrom) 
	{
		this.copyfrom = copyfrom;
	}

	public String getCopyfrom() 
	{
		return copyfrom;
	}
	public void setRelation(String relation) 
	{
		this.relation = relation;
	}

	public String getRelation() 
	{
		return relation;
	}
	public void setAllowComment(String allowComment) 
	{
		this.allowComment = allowComment;
	}

	public String getAllowComment() 
	{
		return allowComment;
	}
	public void setAppearance(String appearance) 
	{
		this.appearance = appearance;
	}

	public String getAppearance() 
	{
		return appearance;
	}
	public void setReason(String reason) 
	{
		this.reason = reason;
	}

	public String getReason() 
	{
		return reason;
	}
	public void setSolution(String solution) 
	{
		this.solution = solution;
	}

	public String getSolution() 
	{
		return solution;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("content", getContent())
            .append("copyfrom", getCopyfrom())
            .append("relation", getRelation())
            .append("allowComment", getAllowComment())
            .append("appearance", getAppearance())
            .append("reason", getReason())
            .append("solution", getSolution())
            .append("remark1", getRemark1())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .toString();
    }
}
