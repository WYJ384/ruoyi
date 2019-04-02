package com.ruoyi.taskscore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taskscore.mapper.ScoreActivityMapper;
import com.ruoyi.taskscore.domain.ScoreActivity;
import com.ruoyi.taskscore.service.IScoreActivityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评分活动 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Service
public class ScoreActivityServiceImpl implements IScoreActivityService 
{
	@Autowired
	private ScoreActivityMapper scoreActivityMapper;

	/**
     * 查询评分活动信息
     * 
     * @param id 评分活动ID
     * @return 评分活动信息
     */
    @Override
	public ScoreActivity selectScoreActivityById(String id)
	{
	    return scoreActivityMapper.selectScoreActivityById(id);
	}
	
	/**
     * 查询评分活动列表
     * 
     * @param scoreActivity 评分活动信息
     * @return 评分活动集合
     */
	@Override
	public List<ScoreActivity> selectScoreActivityList(ScoreActivity scoreActivity)
	{
	    return scoreActivityMapper.selectScoreActivityList(scoreActivity);
	}
	
    /**
     * 新增评分活动
     * 
     * @param scoreActivity 评分活动信息
     * @return 结果
     */
	@Override
	public int insertScoreActivity(ScoreActivity scoreActivity)
	{
	    return scoreActivityMapper.insertScoreActivity(scoreActivity);
	}
	
	/**
     * 修改评分活动
     * 
     * @param scoreActivity 评分活动信息
     * @return 结果
     */
	@Override
	public int updateScoreActivity(ScoreActivity scoreActivity)
	{
	    return scoreActivityMapper.updateScoreActivity(scoreActivity);
	}

	/**
     * 删除评分活动对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteScoreActivityByIds(String ids)
	{
		return scoreActivityMapper.deleteScoreActivityByIds(Convert.toStrArray(ids));
	}
	
}
