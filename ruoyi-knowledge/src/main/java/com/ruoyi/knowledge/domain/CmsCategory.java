package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 栏目表 cms_category
 * 
 * @author ruoyi
 * @date 2019-05-05
 */
public class CmsCategory extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private String id;
	/** 父级编号 */
	private String parentId;
	/** 所有父级编号 */
	private String parentIds;
	/** 站点编号 */
	private String siteId;
	/** 归属机构 */
	private String officeId;
	/** 栏目模块 */
	private String module;
	/** 栏目名称 */
	private String name;
	/** 栏目图片 */
	private String image;
	/** 链接 */
	private String href;
	/** 目标 */
	private String target;
	/** 描述 */
	private String description;
	/** 关键字 */
	private String keywords;
	/** 排序（升序） */
	private Integer sort;
	/** 是否在导航中显示 */
	private String inMenu;
	/** 是否在分类页中显示列表 */
	private String inList;
	/** 展现方式 */
	private String showModes;
	/** 是否允许评论 */
	private String allowComment;
	/** 是否需要审核 */
	private String isAudit;
	/** 自定义列表视图 */
	private String customListView;
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

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setParentIds(String parentIds) 
	{
		this.parentIds = parentIds;
	}

	public String getParentIds() 
	{
		return parentIds;
	}
	public void setSiteId(String siteId) 
	{
		this.siteId = siteId;
	}

	public String getSiteId() 
	{
		return siteId;
	}
	public void setOfficeId(String officeId) 
	{
		this.officeId = officeId;
	}

	public String getOfficeId() 
	{
		return officeId;
	}
	public void setModule(String module) 
	{
		this.module = module;
	}

	public String getModule() 
	{
		return module;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setImage(String image) 
	{
		this.image = image;
	}

	public String getImage() 
	{
		return image;
	}
	public void setHref(String href) 
	{
		this.href = href;
	}

	public String getHref() 
	{
		return href;
	}
	public void setTarget(String target) 
	{
		this.target = target;
	}

	public String getTarget() 
	{
		return target;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setKeywords(String keywords) 
	{
		this.keywords = keywords;
	}

	public String getKeywords() 
	{
		return keywords;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setInMenu(String inMenu) 
	{
		this.inMenu = inMenu;
	}

	public String getInMenu() 
	{
		return inMenu;
	}
	public void setInList(String inList) 
	{
		this.inList = inList;
	}

	public String getInList() 
	{
		return inList;
	}
	public void setShowModes(String showModes) 
	{
		this.showModes = showModes;
	}

	public String getShowModes() 
	{
		return showModes;
	}
	public void setAllowComment(String allowComment) 
	{
		this.allowComment = allowComment;
	}

	public String getAllowComment() 
	{
		return allowComment;
	}
	public void setIsAudit(String isAudit) 
	{
		this.isAudit = isAudit;
	}

	public String getIsAudit() 
	{
		return isAudit;
	}
	public void setCustomListView(String customListView) 
	{
		this.customListView = customListView;
	}

	public String getCustomListView() 
	{
		return customListView;
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
            .append("parentId", getParentId())
            .append("parentIds", getParentIds())
            .append("siteId", getSiteId())
            .append("officeId", getOfficeId())
            .append("module", getModule())
            .append("name", getName())
            .append("image", getImage())
            .append("href", getHref())
            .append("target", getTarget())
            .append("description", getDescription())
            .append("keywords", getKeywords())
            .append("sort", getSort())
            .append("inMenu", getInMenu())
            .append("inList", getInList())
            .append("showModes", getShowModes())
            .append("allowComment", getAllowComment())
            .append("isAudit", getIsAudit())
            .append("customListView", getCustomListView())
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
