package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.Exam;
import java.util.List;

/**
 * 考试 服务层
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
public interface IExamService 
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
	public List<Exam> myExamList(Exam exam);
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
     * 删除考试信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamByIds(String ids);
	
}
