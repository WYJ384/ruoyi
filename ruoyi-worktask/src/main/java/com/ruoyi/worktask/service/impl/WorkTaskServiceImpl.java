package com.ruoyi.worktask.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ruoyi.activiti.domain.HistoryTaskVo;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Comment;
import org.springframework.beans.BeanUtils;
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
	private IWorkTaskFileService workTaskFileService;
	@Autowired
	private ISysUserService userService;
	@Autowired
	private WorkTaskMapper workTaskMapper;
	@Autowired
	private ISysDeptService deptService;
	@Autowired
	TaskService taskService;
	@Autowired
	HistoryService historyService;
	/**
     * 查询工作任务信息
     * 
     * @param id 工作任务ID
     * @return 工作任务信息
     */
    @Override
	public WorkTask selectWorkTaskById(String id)
	{
	    return workTaskMapper.selectWorkTaskById(id);
	}

	@Override
	public WorkTask selectWorkTaskByExt(String id) {
		WorkTask workTask = selectWorkTaskById(id);
		//附件
		WorkTaskFile workTaskFile=new WorkTaskFile();
		workTaskFile.setWorkTaskId(id);
		SysDept leadDept = deptService.selectDeptById(Long.valueOf(workTask.getLeadDeptId()));
		if(leadDept!=null){
			workTask.setLeadDeptName(leadDept.getDeptName());
		}
		String leaderId = workTask.getLeaderId();
		if(StringUtils.isNotEmpty(leaderId)){
			SysUser leadUser = userService.selectUserById(Long.valueOf(leaderId));
			if(leadUser!=null){
				workTask.setLeaderId(leadUser.getUserName());
			}
		}
		String userIds = workTask.getUserIds();
		if(StringUtils.isNotEmpty(userIds)){
			SysUser userIdsUser = userService.selectUserById(Long.valueOf(userIds));
			if(userIdsUser!=null){
				workTask.setUserIds(userIdsUser.getUserName());
			}
		}
		String cooperateDeptId = workTask.getCooperateDeptId();
		String cooperateDeptName="";
		if(StringUtils.isNotEmpty(cooperateDeptId)){
			String[] cooperateDeptIds = cooperateDeptId.split(",");
			for(String deptId:cooperateDeptIds){
				if(StringUtils.isNotEmpty(deptId)){
					SysDept sysDept = deptService.selectDeptById(Long.valueOf(deptId));
					if(sysDept!=null){
						cooperateDeptName+=sysDept.getDeptName()+",";
					}
				}
			}

		}
		workTask.setCooperateDeptName(cooperateDeptName);
		return workTask;
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
			workTask.setPid("0");
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

	@Override
	public List<HistoryTaskVo> historyTaskList(String processInstanceId) {
		List<HistoryTaskVo> historyTaskVos=new ArrayList<HistoryTaskVo>();
		List<HistoricTaskInstance> list= historyService // 历史相关Service
				.createHistoricTaskInstanceQuery() // 创建历史任务实例查询
				.processInstanceId(processInstanceId) // 用流程实例id查询
				.finished() // 查询已经完成的任务
				.list();
		for(HistoricTaskInstance hti:list){
			HistoryTaskVo historyTaskVo=new HistoryTaskVo();
			BeanUtils.copyProperties(hti,historyTaskVo);
			String assignee = hti.getAssignee();
			if(StringUtils.isNotEmpty(assignee)){
				SysUser sysUser = userService.selectUserByLoginName(assignee);
				if(sysUser!=null){
					historyTaskVo.setAssignee(sysUser.getUserName());
				}
			}
			List<Comment> taskComments = taskService.getTaskComments(hti.getId());
			if(taskComments!=null&&taskComments.size()>0){
				String fullMessage = taskService.getTaskComments(hti.getId()).get(0).getFullMessage();
				historyTaskVo.setRepContent(fullMessage);
			}
			historyTaskVos.add(historyTaskVo);
		}

		return historyTaskVos;
	}

	@Override
	public List<WorkTask> selectNoTargetWorkList(WorkTask workTask) {
		List<WorkTask> workTasks = workTaskMapper.selectNoTargetWorkList(workTask);
		Iterator<WorkTask> iterator = workTasks.iterator();
		while (iterator.hasNext()){
			WorkTask task = iterator.next();
			String userIds = task.getUserIds();
			if(StringUtils.isNotEmpty(userIds)){
				SysUser sysUser = userService.selectUserById(Long.parseLong(userIds));
				if(sysUser!=null){
					task.setPid(sysUser.getPhonenumber());
				}
			}
		}
		return workTasks;
	}

}
