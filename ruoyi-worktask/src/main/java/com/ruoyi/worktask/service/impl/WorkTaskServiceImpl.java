package com.ruoyi.worktask.service.impl;

import java.util.Iterator;
import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.BusinessException;
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
			WorkTask task = workTaskMapper.selectWorkTaskById(workTask.getPid());
			workTask.setAncestors(task.getAncestors() + "," + workTask.getPid());
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
		WorkTask task = new WorkTask();
		//查询当前任务的父任务有多少子任务
		task.setPid(workTask.getPid());
		List<WorkTask> workTasks = workTaskMapper.selectWorkTaskList(task);
		int size = workTasks.size();
		Iterator<WorkTask> iterator = workTasks.iterator();
		Double parentRateProgess=0D;
		while (iterator.hasNext()){
			WorkTask task1 = iterator.next();
			if(task1.getId()!=workTask.getId()){
				parentRateProgess+=(1.0/size) *task1.getRateProgress().intValue();
			}
		}
		parentRateProgess += (1.0/size) * workTask.getRateProgress();
		//更新父任务进度
		WorkTask parentTask = workTaskMapper.selectWorkTaskById(workTask.getPid());
		if(parentTask!=null){
			parentTask.setRateProgress(parentRateProgess.intValue());
			workTaskMapper.updateWorkTask(parentTask);
		}
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
