package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.PaperQuestion;
import java.util.List;	

/**
 * 试卷-试题 数据层
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
public interface PaperQuestionMapper 
{
	/**
     * 查询试卷-试题信息
     * 
     * @param examPaperId 试卷-试题ID
     * @return 试卷-试题信息
     */
	public List<PaperQuestion>  selectPaperQuestionById(String examPaperId);
	
	/**
     * 查询试卷-试题列表
     * 
     * @param paperQuestion 试卷-试题信息
     * @return 试卷-试题集合
     */
	public List<PaperQuestion> selectPaperQuestionList(PaperQuestion paperQuestion);
	
	/**
     * 新增试卷-试题
     * 
     * @param paperQuestion 试卷-试题信息
     * @return 结果
     */
	public int insertPaperQuestion(PaperQuestion paperQuestion);
	
	/**
     * 修改试卷-试题
     * 
     * @param paperQuestion 试卷-试题信息
     * @return 结果
     */
	public int updatePaperQuestion(PaperQuestion paperQuestion);
	
	/**
     * 删除试卷-试题
     * 
     * @param examPaperId 试卷-试题ID
     * @return 结果
     */
	public int deletePaperQuestionById(String examPaperId);
	
	/**
     * 批量删除试卷-试题
     * 
     * @param examPaperIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePaperQuestionByIds(String[] examPaperIds);
	
}