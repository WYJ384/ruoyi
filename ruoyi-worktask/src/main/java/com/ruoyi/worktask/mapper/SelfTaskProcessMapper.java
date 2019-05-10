package com.ruoyi.worktask.mapper;

import com.ruoyi.worktask.domain.SelfTaskProcess;
import java.util.List;	

/**
 * 任务进度 数据层
 * 
 * @author ruoyi
 * @date 2019-05-09
 */
public interface SelfTaskProcessMapper 
{
	/**
     * 查询任务进度信息
     * 
     * @param id 任务进度ID
     * @return 任务进度信息
     */
	public SelfTaskProcess selectSelfTaskProcessById(String id);
	
	/**
     * 查询任务进度列表
     * 
     * @param selfTaskProcess 任务进度信息
     * @return 任务进度集合
     */
	public List<SelfTaskProcess> selectSelfTaskProcessList(SelfTaskProcess selfTaskProcess);
	
	/**
     * 新增任务进度
     * 
     * @param selfTaskProcess 任务进度信息
     * @return 结果
     */
	public int insertSelfTaskProcess(SelfTaskProcess selfTaskProcess);
	
	/**
     * 修改任务进度
     * 
     * @param selfTaskProcess 任务进度信息
     * @return 结果
     */
	public int updateSelfTaskProcess(SelfTaskProcess selfTaskProcess);
	
	/**
     * 删除任务进度
     * 
     * @param id 任务进度ID
     * @return 结果
     */
	public int deleteSelfTaskProcessById(String id);
	
	/**
     * 批量删除任务进度
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSelfTaskProcessByIds(String[] ids);
	
}