package com.ruoyi.knowledge.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 文章表 cms_article
 * 
 * @author ruoyi
 * @date 2019-05-05
 */
public class Article extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	@Excel(name = "专业")
	private String category;
	@Excel(name = "子专业")
	private String ccategory;
	/** 关键字 */
	@Excel(name = "关键词")
	private String keywords;
	/** 描述、摘要 */
	@Excel(name = "现象")
	private String description;
	/** 原因分析 */
	@Excel(name = "原因分析")
	private String reason;
	/** 解决方案 */
	@Excel(name = "解决方案")
	private String solution;
	/** 编号 */
	private String id;
	/** 栏目编号 */
	private String categoryId;
	/** 标题 */
	private String title;
	/** 文章链接 */
	private String link;
	/** 标题颜色 */
	private String color;
	/** 文章图片 */
	private String image;


	/** 权重，越大越靠前 */
	private Integer weight;
	/** 权重期限 */
	private Date weightDate;
	/** 点击数 */
	private Integer hits;
	/** 推荐位，多选 */
	private String posid;
	/** 自定义内容视图 */
	private String customContentView;
	/** 视图配置 */
	private String viewConfig;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateDate;
	/** 备注信息 */
	private String remarks;
	/** 删除标记 */
	private String delFlag;



	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCcategory() {
		return ccategory;
	}

	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

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
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setLink(String link) 
	{
		this.link = link;
	}

	public String getLink() 
	{
		return link;
	}
	public void setColor(String color) 
	{
		this.color = color;
	}

	public String getColor() 
	{
		return color;
	}
	public void setImage(String image) 
	{
		this.image = image;
	}

	public String getImage() 
	{
		return image;
	}
	public void setKeywords(String keywords) 
	{
		this.keywords = keywords;
	}

	public String getKeywords() 
	{
		return keywords;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setWeight(Integer weight) 
	{
		this.weight = weight;
	}

	public Integer getWeight() 
	{
		return weight;
	}
	public void setWeightDate(Date weightDate) 
	{
		this.weightDate = weightDate;
	}

	public Date getWeightDate() 
	{
		return weightDate;
	}
	public void setHits(Integer hits) 
	{
		this.hits = hits;
	}

	public Integer getHits() 
	{
		return hits;
	}
	public void setPosid(String posid) 
	{
		this.posid = posid;
	}

	public String getPosid() 
	{
		return posid;
	}
	public void setCustomContentView(String customContentView) 
	{
		this.customContentView = customContentView;
	}

	public String getCustomContentView() 
	{
		return customContentView;
	}
	public void setViewConfig(String viewConfig) 
	{
		this.viewConfig = viewConfig;
	}

	public String getViewConfig() 
	{
		return viewConfig;
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
	public void setRemarks(String remarks) 
	{
		this.remarks = remarks;
	}

	public String getRemarks() 
	{
		return remarks;
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
            .append("title", getTitle())
            .append("link", getLink())
            .append("color", getColor())
            .append("image", getImage())
            .append("keywords", getKeywords())
            .append("description", getDescription())
            .append("weight", getWeight())
            .append("weightDate", getWeightDate())
            .append("hits", getHits())
            .append("posid", getPosid())
            .append("customContentView", getCustomContentView())
            .append("viewConfig", getViewConfig())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remarks", getRemarks())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
