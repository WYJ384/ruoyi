package com.ruoyi.taskscore.mapper;

import com.ruoyi.taskscore.domain.TroubleUpdate;
import java.util.List;	

/**
 * 隐患整改 数据层
 * 
 * @author ruoyi
 * @date 2019-04-22
 */
public interface TroubleUpdateMapper 
{
	/**
     * 查询隐患整改信息
     * 
     * @param troId 隐患整改ID
     * @return 隐患整改信息
     */
	public TroubleUpdate selectTroubleUpdateById(String troId);
	
	/**
     * 查询隐患整改列表
     * 
     * @param troubleUpdate 隐患整改信息
     * @return 隐患整改集合
     */
	public List<TroubleUpdate> selectTroubleUpdateList(TroubleUpdate troubleUpdate);
	
	/**
     * 新增隐患整改
     * 
     * @param troubleUpdate 隐患整改信息
     * @return 结果
     */
	public int insertTroubleUpdate(TroubleUpdate troubleUpdate);
	
	/**
     * 修改隐患整改
     * 
     * @param troubleUpdate 隐患整改信息
     * @return 结果
     */
	public int updateTroubleUpdate(TroubleUpdate troubleUpdate);
	
	/**
     * 删除隐患整改
     * 
     * @param troId 隐患整改ID
     * @return 结果
     */
	public int deleteTroubleUpdateById(String troId);
	
	/**
     * 批量删除隐患整改
     * 
     * @param troIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTroubleUpdateByIds(String[] troIds);
	
}