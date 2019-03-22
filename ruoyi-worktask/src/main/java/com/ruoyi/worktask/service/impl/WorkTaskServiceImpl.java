package com.ruoyi.worktask.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.worktask.mapper.WorkTaskMapper;
import com.ruoyi.worktask.domain.WorkTask;
import com.ruoyi.worktask.service.IWorkTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * 工作任务 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-20
 */
@Service
public class WorkTaskServiceImpl implements IWorkTaskService 
{
	@Autowired
	private WorkTaskMapper workTaskMapper;

	/**
     * 查询工作任务信息
     * 
     * @param id 工作任务ID
     * @return 工作任务信息
     */
    @Override
	public WorkTask selectWorkTaskById(Integer id)
	{
	    return workTaskMapper.selectWorkTaskById(id);
	}
	
	/**
     * 查询工作任务列表
     * 
     * @param workTask 工作任务信息
     * @return 工作任务集合
     */
	@Override
	public List<WorkTask> selectWorkTaskList(WorkTask workTask)
	{
	    return workTaskMapper.selectWorkTaskList(workTask);
	}
	
    /**
     * 新增工作任务
     * 
     * @param workTask 工作任务信息
     * @return 结果
     */
	@Override
	public int insertWorkTask(WorkTask workTask)
	{
		if(workTask.getWorkType().equals("1")){
			workTask.setAncestors("0");
			workTask.setPid(0);
		}else{

		}
	    return workTaskMapper.insertWorkTask(workTask);
	}
	
	/**
     * 修改工作任务
     * 
     * @param workTask 工作任务信息
     * @return 结果
     */
	@Override
	public int updateWorkTask(WorkTask workTask)
	{
	    return workTaskMapper.updateWorkTask(workTask);
	}

	/**
     * 删除工作任务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWorkTaskByIds(String ids)
	{
		return workTaskMapper.deleteWorkTaskByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<WorkTask> selectWorkTaskListByUserId(WorkTask workTask) {

		return workTaskMapper.selectWorkTaskListByUserId(workTask);
	}

}
