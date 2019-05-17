package com.ruoyi.taskscore.mapper;

import com.ruoyi.taskscore.domain.ScoreActivityDetail;
import com.ruoyi.taskscore.domain.ScoreDeptVO;

import java.util.List;

/**
 * 评分活动详情 数据层
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public interface ScoreActivityDetailMapper 
{
	/**
     * 查询评分活动详情信息
     * 
     * @param id 评分活动详情ID
     * @return 评分活动详情信息
     */
	public ScoreActivityDetail selectScoreActivityDetailById(String id);
	
	/**
     * 查询评分活动详情列表
     * 
     * @param scoreActivityDetail 评分活动详情信息
     * @return 评分活动详情集合
     */
	public List<ScoreActivityDetail> selectScoreActivityDetailList(ScoreActivityDetail scoreActivityDetail);
	
	/**
     * 新增评分活动详情
     * 
     * @param scoreActivityDetail 评分活动详情信息
     * @return 结果
     */
	public int insertScoreActivityDetail(ScoreActivityDetail scoreActivityDetail);
	
	/**
     * 修改评分活动详情
     * 
     * @param scoreActivityDetail 评分活动详情信息
     * @return 结果
     */
	public int updateScoreActivityDetail(ScoreActivityDetail scoreActivityDetail);
	
	/**
     * 删除评分活动详情
     * 
     * @param id 评分活动详情ID
     * @return 结果
     */
	public int deleteScoreActivityDetailById(String id);
	
	/**
     * 批量删除评分活动详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteScoreActivityDetailByIds(String[] ids);

	List<ScoreDeptVO> getDeptMonthScore(ScoreDeptVO scoreDeptVO);
	
}