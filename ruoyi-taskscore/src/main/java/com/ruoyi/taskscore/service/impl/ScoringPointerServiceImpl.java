package com.ruoyi.taskscore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taskscore.mapper.ScoringPointerMapper;
import com.ruoyi.taskscore.domain.ScoringPointer;
import com.ruoyi.taskscore.service.IScoringPointerService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评分 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Service
public class ScoringPointerServiceImpl implements IScoringPointerService 
{
	@Autowired
	private ScoringPointerMapper scoringPointerMapper;

	/**
     * 查询评分信息
     * 
     * @param id 评分ID
     * @return 评分信息
     */
    @Override
	public ScoringPointer selectScoringPointerById(String id)
	{
	    return scoringPointerMapper.selectScoringPointerById(id);
	}
	
	/**
     * 查询评分列表
     * 
     * @param scoringPointer 评分信息
     * @return 评分集合
     */
	@Override
	public List<ScoringPointer> selectScoringPointerList(ScoringPointer scoringPointer)
	{
	    return scoringPointerMapper.selectScoringPointerList(scoringPointer);
	}
	
    /**
     * 新增评分
     * 
     * @param scoringPointer 评分信息
     * @return 结果
     */
	@Override
	public int insertScoringPointer(ScoringPointer scoringPointer)
	{
	    return scoringPointerMapper.insertScoringPointer(scoringPointer);
	}
	
	/**
     * 修改评分
     * 
     * @param scoringPointer 评分信息
     * @return 结果
     */
	@Override
	public int updateScoringPointer(ScoringPointer scoringPointer)
	{
	    return scoringPointerMapper.updateScoringPointer(scoringPointer);
	}

	/**
     * 删除评分对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteScoringPointerByIds(String ids)
	{
		return scoringPointerMapper.deleteScoringPointerByIds(Convert.toStrArray(ids));
	}
	
}
