package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.Exam;
import java.util.List;	

/**
 * 考试 数据层
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
public interface ExamMapper 
{
	/**
     * 查询考试信息
     * 
     * @param id 考试ID
     * @return 考试信息
     */
	public Exam selectExamById(String id);
	
	/**
     * 查询考试列表
     * 
     * @param exam 考试信息
     * @return 考试集合
     */
	public List<Exam> selectExamList(Exam exam);
	
	/**
     * 新增考试
     * 
     * @param exam 考试信息
     * @return 结果
     */
	public int insertExam(Exam exam);
	
	/**
     * 修改考试
     * 
     * @param exam 考试信息
     * @return 结果
     */
	public int updateExam(Exam exam);
	
	/**
     * 删除考试
     * 
     * @param id 考试ID
     * @return 结果
     */
	public int deleteExamById(String id);
	
	/**
     * 批量删除考试
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamByIds(String[] ids);
	
}