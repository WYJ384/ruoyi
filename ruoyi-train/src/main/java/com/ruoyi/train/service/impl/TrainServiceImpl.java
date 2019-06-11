package com.ruoyi.train.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.train.mapper.TrainMapper;
import com.ruoyi.train.domain.Train;
import com.ruoyi.train.service.ITrainService;
import com.ruoyi.common.core.text.Convert;

/**
 * 培训审批 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
@Service
public class TrainServiceImpl implements ITrainService 
{
	@Autowired
	private TrainMapper trainMapper;

	/**
     * 查询培训审批信息
     * 
     * @param id 培训审批ID
     * @return 培训审批信息
     */
    @Override
	public Train selectTrainById(String id)
	{
	    return trainMapper.selectTrainById(id);
	}
	
	/**
     * 查询培训审批列表
     * 
     * @param train 培训审批信息
     * @return 培训审批集合
     */
	@Override
	public List<Train> selectTrainList(Train train)
	{
	    return trainMapper.selectTrainList(train);
	}
	
    /**
     * 新增培训审批
     * 
     * @param train 培训审批信息
     * @return 结果
     */
	@Override
	public int insertTrain(Train train)
	{
	    return trainMapper.insertTrain(train);
	}
	
	/**
     * 修改培训审批
     * 
     * @param train 培训审批信息
     * @return 结果
     */
	@Override
	public int updateTrain(Train train)
	{
	    return trainMapper.updateTrain(train);
	}

	/**
     * 删除培训审批对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTrainByIds(String ids)
	{
		return trainMapper.deleteTrainByIds(Convert.toStrArray(ids));
	}
	
}
