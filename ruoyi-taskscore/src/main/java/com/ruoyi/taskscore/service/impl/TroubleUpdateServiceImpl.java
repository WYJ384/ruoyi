package com.ruoyi.taskscore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taskscore.mapper.TroubleUpdateMapper;
import com.ruoyi.taskscore.domain.TroubleUpdate;
import com.ruoyi.taskscore.service.ITroubleUpdateService;
import com.ruoyi.common.core.text.Convert;

/**
 * 隐患整改 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-22
 */
@Service
public class TroubleUpdateServiceImpl implements ITroubleUpdateService 
{
	@Autowired
	private TroubleUpdateMapper troubleUpdateMapper;

	/**
     * 查询隐患整改信息
     * 
     * @param troId 隐患整改ID
     * @return 隐患整改信息
     */
    @Override
	public TroubleUpdate selectTroubleUpdateById(String troId)
	{
	    return troubleUpdateMapper.selectTroubleUpdateById(troId);
	}
	
	/**
     * 查询隐患整改列表
     * 
     * @param troubleUpdate 隐患整改信息
     * @return 隐患整改集合
     */
	@Override
	public List<TroubleUpdate> selectTroubleUpdateList(TroubleUpdate troubleUpdate)
	{
	    return troubleUpdateMapper.selectTroubleUpdateList(troubleUpdate);
	}
	
    /**
     * 新增隐患整改
     * 
     * @param troubleUpdate 隐患整改信息
     * @return 结果
     */
	@Override
	public int insertTroubleUpdate(TroubleUpdate troubleUpdate)
	{
	    return troubleUpdateMapper.insertTroubleUpdate(troubleUpdate);
	}
	
	/**
     * 修改隐患整改
     * 
     * @param troubleUpdate 隐患整改信息
     * @return 结果
     */
	@Override
	public int updateTroubleUpdate(TroubleUpdate troubleUpdate)
	{
	    return troubleUpdateMapper.updateTroubleUpdate(troubleUpdate);
	}

	/**
     * 删除隐患整改对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTroubleUpdateByIds(String ids)
	{
		return troubleUpdateMapper.deleteTroubleUpdateByIds(Convert.toStrArray(ids));
	}
	
}
