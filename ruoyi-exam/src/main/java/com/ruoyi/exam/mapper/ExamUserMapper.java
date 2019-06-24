package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.ExamUser;
import java.util.List;	

/**
 * 考试人员 数据层
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
public interface ExamUserMapper 
{
	/**
     * 查询考试人员信息
     * 
     * @param examId 考试人员ID
     * @return 考试人员信息
     */
	public ExamUser selectExamUserById(String examId);
	
	/**
     * 查询考试人员列表
     * 
     * @param examUser 考试人员信息
     * @return 考试人员集合
     */
	public List<ExamUser> selectExamUserList(ExamUser examUser);
	
	/**
     * 新增考试人员
     * 
     * @param examUser 考试人员信息
     * @return 结果
     */
	public int insertExamUser(ExamUser examUser);
	
	/**
     * 修改考试人员
     * 
     * @param examUser 考试人员信息
     * @return 结果
     */
	public int updateExamUser(ExamUser examUser);
	
	/**
     * 删除考试人员
     * 
     * @param examId 考试人员ID
     * @return 结果
     */
	public int deleteExamUserById(String examId);
	
	/**
     * 批量删除考试人员
     * 
     * @param examIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamUserByIds(String[] examIds);
	
}