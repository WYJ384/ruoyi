package com.ruoyi.taskscore.mapper;

import com.ruoyi.taskscore.domain.ScoreActivity;
import java.util.List;	

/**
 * 评分活动 数据层
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public interface ScoreActivityMapper 
{
	/**
     * 查询评分活动信息
     * 
     * @param id 评分活动ID
     * @return 评分活动信息
     */
	public ScoreActivity selectScoreActivityById(String id);
	
	/**
     * 查询评分活动列表
     * 
     * @param scoreActivity 评分活动信息
     * @return 评分活动集合
     */
	public List<ScoreActivity> selectScoreActivityList(ScoreActivity scoreActivity);
	
	/**
     * 新增评分活动
     * 
     * @param scoreActivity 评分活动信息
     * @return 结果
     */
	public int insertScoreActivity(ScoreActivity scoreActivity);
	
	/**
     * 修改评分活动
     * 
     * @param scoreActivity 评分活动信息
     * @return 结果
     */
	public int updateScoreActivity(ScoreActivity scoreActivity);
	
	/**
     * 删除评分活动
     * 
     * @param id 评分活动ID
     * @return 结果
     */
	public int deleteScoreActivityById(String id);
	
	/**
     * 批量删除评分活动
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteScoreActivityByIds(String[] ids);
	
}