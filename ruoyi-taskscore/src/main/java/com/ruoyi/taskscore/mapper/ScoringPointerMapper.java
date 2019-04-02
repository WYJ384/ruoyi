package com.ruoyi.taskscore.mapper;

import com.ruoyi.taskscore.domain.ScoringPointer;
import java.util.List;	

/**
 * 评分 数据层
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public interface ScoringPointerMapper 
{
	/**
     * 查询评分信息
     * 
     * @param id 评分ID
     * @return 评分信息
     */
	public ScoringPointer selectScoringPointerById(String id);
	
	/**
     * 查询评分列表
     * 
     * @param scoringPointer 评分信息
     * @return 评分集合
     */
	public List<ScoringPointer> selectScoringPointerList(ScoringPointer scoringPointer);
	
	/**
     * 新增评分
     * 
     * @param scoringPointer 评分信息
     * @return 结果
     */
	public int insertScoringPointer(ScoringPointer scoringPointer);
	
	/**
     * 修改评分
     * 
     * @param scoringPointer 评分信息
     * @return 结果
     */
	public int updateScoringPointer(ScoringPointer scoringPointer);
	
	/**
     * 删除评分
     * 
     * @param id 评分ID
     * @return 结果
     */
	public int deleteScoringPointerById(String id);
	
	/**
     * 批量删除评分
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteScoringPointerByIds(String[] ids);
	
}