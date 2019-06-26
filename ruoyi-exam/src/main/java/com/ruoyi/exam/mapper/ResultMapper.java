package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.Result;
import java.util.List;	

/**
 * 考试成绩 数据层
 * 
 * @author ruoyi
 * @date 2019-06-26
 */
public interface ResultMapper 
{
	/**
     * 查询考试成绩信息
     * 
     * @param examId 考试成绩ID
     * @return 考试成绩信息
     */
	public Result selectResultById(String examId);
	
	/**
     * 查询考试成绩列表
     * 
     * @param result 考试成绩信息
     * @return 考试成绩集合
     */
	public List<Result> selectResultList(Result result);
	
	/**
     * 新增考试成绩
     * 
     * @param result 考试成绩信息
     * @return 结果
     */
	public int insertResult(Result result);
	
	/**
     * 修改考试成绩
     * 
     * @param result 考试成绩信息
     * @return 结果
     */
	public int updateResult(Result result);
	
	/**
     * 删除考试成绩
     * 
     * @param examId 考试成绩ID
     * @return 结果
     */
	public int deleteResultById(String examId);
	
	/**
     * 批量删除考试成绩
     * 
     * @param examIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteResultByIds(String[] examIds);
	
}