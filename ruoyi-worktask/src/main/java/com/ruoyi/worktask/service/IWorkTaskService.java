package com.ruoyi.worktask.service;

import com.ruoyi.worktask.domain.WorkTask;
import java.util.List;

/**
 * 工作任务 服务层
 * 
 * @author ruoyi
 * @date 2019-03-20
 */
public interface IWorkTaskService 
{
	/**
     * 查询工作任务信息
     * 
     * @param id 工作任务ID
     * @return 工作任务信息
     */
	public WorkTask selectWorkTaskById(Integer id);
	
	/**
     * 查询工作任务列表
     * 
     * @param workTask 工作任务信息
     * @return 工作任务集合
     */
	public List<WorkTask> selectWorkTaskList(WorkTask workTask);
	
	/**
     * 新增工作任务
     * 
     * @param workTask 工作任务信息
     * @return 结果
     */
	public int insertWorkTask(WorkTask workTask);
	
	/**
     * 修改工作任务
     * 
     * @param workTask 工作任务信息
     * @return 结果
     */
	public int updateWorkTask(WorkTask workTask);
		
	/**
     * 删除工作任务信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWorkTaskByIds(String ids);

	/**
	 * 查询我的工作任务列表
	 *
	 * @param workTask 工作任务信息
	 * @return 工作任务集合
	 */
	public List<WorkTask> selectWorkTaskListByUserId(WorkTask workTask);


}
