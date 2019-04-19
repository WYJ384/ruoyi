package com.ruoyi.taskscore.domain;

import com.ruoyi.system.domain.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评分表 scoring_pointer
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public class ScoringPointer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 指标名称 */
	private String name;
	/** 权重 */
	private String weight;
	/** 指标类型id */
	private String pointerTypeId;
	/** 评价说明 */
	private String scoreDescription;
	/** 得分 */
	private Double score;
	/** 受评部门 */
	private String deptId;

	private SysDept dept;
	/** 评价部门 */
	private String evalDeptId;
	private SysDept evalDept;

	private PointerType pointerType;

	/** 删除标志 */
	private String delFlag;

	//评分人
	private String evalUserId;

	//排序
	private Integer porder;


	public String getEvalUserId() {
		return evalUserId;
	}

	public void setEvalUserId(String evalUserId) {
		this.evalUserId = evalUserId;
	}

	public Integer getPorder() {
		return porder;
	}

	public void setPorder(Integer porder) {
		this.porder = porder;
	}

	public SysDept getDept() {
		return dept;
	}

	public void setDept(SysDept dept) {
		this.dept = dept;
	}

	public SysDept getEvalDept() {
		return evalDept;
	}

	public void setEvalDept(SysDept evalDept) {
		this.evalDept = evalDept;
	}

	public PointerType getPointerType() {
		return pointerType;
	}

	public void setPointerType(PointerType pointerType) {
		this.pointerType = pointerType;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setWeight(String weight)
	{
		this.weight = weight;
	}

	public String getWeight()
	{
		return weight;
	}
	public void setPointerTypeId(String pointerTypeId)
	{
		this.pointerTypeId = pointerTypeId;
	}

	public String getPointerTypeId()
	{
		return pointerTypeId;
	}
	public void setScoreDescription(String scoreDescription) 
	{
		this.scoreDescription = scoreDescription;
	}

	public String getScoreDescription() 
	{
		return scoreDescription;
	}
	public void setScore(Double score) 
	{
		this.score = score;
	}

	public Double getScore() 
	{
		return score;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}
	public void setEvalDeptId(String evalDeptId) 
	{
		this.evalDeptId = evalDeptId;
	}

	public String getEvalDeptId() 
	{
		return evalDeptId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("weight", getWeight())
            .append("pointerTypeId", getPointerTypeId())
            .append("scoreDescription", getScoreDescription())
            .append("score", getScore())
            .append("deptId", getDeptId())
            .append("evalDeptId", getEvalDeptId())
            .toString();
    }
}
