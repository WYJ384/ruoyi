package com.ruoyi.worktask.service;

import com.ruoyi.worktask.domain.SelfTask;
import java.util.List;

/**
 * 任务 服务层
 * 
 * @author ruoyi
 * @date 2019-05-08
 */
public interface ISelfTaskService 
{
	/**
     * 查询任务信息
     * 
     * @param id 任务ID
     * @return 任务信息
     */
	public SelfTask selectSelfTaskById(String id);
	
	/**
     * 查询任务列表
     * 
     * @param selfTask 任务信息
     * @return 任务集合
     */
	public List<SelfTask> selectSelfTaskList(SelfTask selfTask);
	
	/**
     * 新增任务
     * 
     * @param selfTask 任务信息
     * @return 结果
     */
	public int insertSelfTask(SelfTask selfTask);
	
	/**
     * 修改任务
     * 
     * @param selfTask 任务信息
     * @return 结果
     */
	public int updateSelfTask(SelfTask selfTask);
		
	/**
     * 删除任务信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSelfTaskByIds(String ids);
	
}
