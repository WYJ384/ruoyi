package com.ruoyi.exam.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 试卷表 exam_paper
 * 
 * @author ruoyi
 * @date 2019-06-19
 */
public class PaperScore extends BaseEntity
{
	String singeChoice;
	String multChoice;
	String judge;
	String blank;
	String qa;

	public String getSingeChoice() {
		return singeChoice;
	}

	public void setSingeChoice(String singeChoice) {
		this.singeChoice = singeChoice;
	}

	public String getMultChoice() {
		return multChoice;
	}

	public void setMultChoice(String multChoice) {
		this.multChoice = multChoice;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}

	public String getQa() {
		return qa;
	}

	public void setQa(String qa) {
		this.qa = qa;
	}
}
