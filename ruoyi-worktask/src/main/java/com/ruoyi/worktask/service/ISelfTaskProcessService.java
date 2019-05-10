package com.ruoyi.worktask.service;

import com.ruoyi.worktask.domain.SelfTaskProcess;
import java.util.List;

/**
 * 任务进度 服务层
 * 
 * @author ruoyi
 * @date 2019-05-09
 */
public interface ISelfTaskProcessService 
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
     * 删除任务进度信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSelfTaskProcessByIds(String ids);
	
}
