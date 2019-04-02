package com.ruoyi.taskscore.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 评分指标类型表 pointer_type
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public class PointerType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 名称 */
	private String name;

	/** 删除标志 */
	private String delFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
