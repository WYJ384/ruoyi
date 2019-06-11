package com.ruoyi.train.service;

import com.ruoyi.train.domain.Train;
import java.util.List;

/**
 * 培训审批 服务层
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
public interface ITrainService 
{
	/**
     * 查询培训审批信息
     * 
     * @param id 培训审批ID
     * @return 培训审批信息
     */
	public Train selectTrainById(String id);
	
	/**
     * 查询培训审批列表
     * 
     * @param train 培训审批信息
     * @return 培训审批集合
     */
	public List<Train> selectTrainList(Train train);
	
	/**
     * 新增培训审批
     * 
     * @param train 培训审批信息
     * @return 结果
     */
	public int insertTrain(Train train);
	
	/**
     * 修改培训审批
     * 
     * @param train 培训审批信息
     * @return 结果
     */
	public int updateTrain(Train train);
		
	/**
     * 删除培训审批信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTrainByIds(String ids);
	
}
