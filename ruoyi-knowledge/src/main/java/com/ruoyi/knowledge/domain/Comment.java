package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 评论表 cms_comment
 * 
 * @author ruoyi
 * @date 2019-05-16
 */
public class Comment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private String id;
	/** 栏目编号 */
	private String categoryId;
	/** 栏目内容的编号 */
	private String contentId;
	/** 栏目内容的标题 */
	private String title;
	/** 评论内容 */
	private String content;
	/** 评论IP */
	private String ip;
	/** 评论时间 */
	private Date time;
	/** 评论人姓名 */
	private String replyName;
	/** 被评论人姓名 */
	private String beReplyName;
	/** 头像路径 */
	private String img;
	/** 审核人 */
	private String auditUserId;
	/** 审核时间 */
	private Date auditDate;
	/** 删除标记 */
	private String delFlag;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setCategoryId(String categoryId) 
	{
		this.categoryId = categoryId;
	}

	public String getCategoryId() 
	{
		return categoryId;
	}
	public void setContentId(String contentId) 
	{
		this.contentId = contentId;
	}

	public String getContentId() 
	{
		return contentId;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setIp(String ip) 
	{
		this.ip = ip;
	}

	public String getIp() 
	{
		return ip;
	}
	public void setTime(Date time) 
	{
		this.time = time;
	}

	public Date getTime() 
	{
		return time;
	}
	public void setReplyName(String replyName) 
	{
		this.replyName = replyName;
	}

	public String getReplyName() 
	{
		return replyName;
	}
	public void setBeReplyName(String beReplyName) 
	{
		this.beReplyName = beReplyName;
	}

	public String getBeReplyName() 
	{
		return beReplyName;
	}
	public void setImg(String img) 
	{
		this.img = img;
	}

	public String getImg() 
	{
		return img;
	}
	public void setAuditUserId(String auditUserId) 
	{
		this.auditUserId = auditUserId;
	}

	public String getAuditUserId() 
	{
		return auditUserId;
	}
	public void setAuditDate(Date auditDate) 
	{
		this.auditDate = auditDate;
	}

	public Date getAuditDate() 
	{
		return auditDate;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("contentId", getContentId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("ip", getIp())
            .append("time", getTime())
            .append("replyName", getReplyName())
            .append("beReplyName", getBeReplyName())
            .append("img", getImg())
            .append("auditUserId", getAuditUserId())
            .append("auditDate", getAuditDate())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
