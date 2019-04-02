package com.ruoyi.taskscore.service;

import com.ruoyi.taskscore.domain.ScoreActivityDetail;
import java.util.List;

/**
 * 评分活动详情 服务层
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public interface IScoreActivityDetailService 
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
     * 删除评分活动详情信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteScoreActivityDetailByIds(String ids);
	
}
