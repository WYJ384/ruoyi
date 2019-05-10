package com.ruoyi.worktask.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 任务进度表 self_task_process
 * 
 * @author ruoyi
 * @date 2019-05-09
 */
public class SelfTaskProcess extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 进度描述 */
	private String processText;
	/** 当前进度 */
	private String percentAge;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProcessText() {
		return processText;
	}

	public void setProcessText(String processText) {
		this.processText = processText;
	}

	public String getPercentAge() {
		return percentAge;
	}

	public void setPercentAge(String percentAge) {
		this.percentAge = percentAge;
	}
}
