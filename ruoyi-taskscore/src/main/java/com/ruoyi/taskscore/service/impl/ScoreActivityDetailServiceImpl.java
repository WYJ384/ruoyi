package com.ruoyi.taskscore.service.impl;

import java.util.List;

import com.ruoyi.taskscore.domain.ScoreDeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taskscore.mapper.ScoreActivityDetailMapper;
import com.ruoyi.taskscore.domain.ScoreActivityDetail;
import com.ruoyi.taskscore.service.IScoreActivityDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评分活动详情 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Service
public class ScoreActivityDetailServiceImpl implements IScoreActivityDetailService 
{
	@Autowired
	private ScoreActivityDetailMapper scoreActivityDetailMapper;

	/**
     * 查询评分活动详情信息
     * 
     * @param id 评分活动详情ID
     * @return 评分活动详情信息
     */
    @Override
	public ScoreActivityDetail selectScoreActivityDetailById(String id)
	{
	    return scoreActivityDetailMapper.selectScoreActivityDetailById(id);
	}
	
	/**
     * 查询评分活动详情列表
     * 
     * @param scoreActivityDetail 评分活动详情信息
     * @return 评分活动详情集合
     */
	@Override
	public List<ScoreActivityDetail> selectScoreActivityDetailList(ScoreActivityDetail scoreActivityDetail)
	{
	    return scoreActivityDetailMapper.selectScoreActivityDetailList(scoreActivityDetail);
	}
	
    /**
     * 新增评分活动详情
     * 
     * @param scoreActivityDetail 评分活动详情信息
     * @return 结果
     */
	@Override
	public int insertScoreActivityDetail(ScoreActivityDetail scoreActivityDetail)
	{
	    return scoreActivityDetailMapper.insertScoreActivityDetail(scoreActivityDetail);
	}
	
	/**
     * 修改评分活动详情
     * 
     * @param scoreActivityDetail 评分活动详情信息
     * @return 结果
     */
	@Override
	public int updateScoreActivityDetail(ScoreActivityDetail scoreActivityDetail)
	{
	    return scoreActivityDetailMapper.updateScoreActivityDetail(scoreActivityDetail);
	}

	/**
     * 删除评分活动详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteScoreActivityDetailByIds(String ids)
	{
		return scoreActivityDetailMapper.deleteScoreActivityDetailByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<ScoreDeptVO> getDeptMonthScore(ScoreDeptVO scoreDeptVO) {

		return scoreActivityDetailMapper.getDeptMonthScore(scoreDeptVO);
	}

}
