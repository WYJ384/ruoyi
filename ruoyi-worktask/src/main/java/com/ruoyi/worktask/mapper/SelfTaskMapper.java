package com.ruoyi.worktask.mapper;

import com.ruoyi.worktask.domain.BasicMaintenance;
import com.ruoyi.worktask.domain.Goodness;
import com.ruoyi.worktask.domain.SelfTask;
import java.util.List;	

/**
 * 任务 数据层
 * 
 * @author ruoyi
 * @date 2019-05-08
 */
public interface SelfTaskMapper 
{
	/**
     * 查询任务信息
     * 
     * @param id 任务ID
     * @return 任务信息
     */
	public SelfTask selectSelfTaskById(String id);
	/**
	 * 查询任务信息
	 *
	 * @param id 任务ID
	 * @return 任务信息
	 */
	public Goodness selectGoodnessTaskById(String id);

	/**
     * 查询任务列表
     * 
     * @param selfTask 任务信息
     * @return 任务集合
     */
	public List<SelfTask> selectSelfTaskList(SelfTask selfTask);

	/**
	 * 查询固优势补短板
	 *
	 * @param goodness 任务信息
	 * @return 任务集合
	 */
	public List<Goodness> goodnessTaskList(Goodness goodness);
	
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
     * 删除任务
     * 
     * @param id 任务ID
     * @return 结果
     */
	public int deleteSelfTaskById(String id);
	
	/**
     * 批量删除任务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSelfTaskByIds(String[] ids);

	List<BasicMaintenance> basicmaintenanceTaskList(BasicMaintenance selfTask);

	BasicMaintenance selectBasicMaintenanceTaskById(String id);

}