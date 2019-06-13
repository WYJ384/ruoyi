package com.ruoyi.exam.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 单选题表 exam_single_choice
 * 
 * @author ruoyi
 * @date 2019-06-13
 */
public class LibraryQuestion extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 单选题ID */
	private String id;
	/** 题目 */
	private String title;
	private String type;
	/** 题库 */
	private String libId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibId() {
		return libId;
	}

	public void setLibId(String libId) {
		this.libId = libId;
	}
}
