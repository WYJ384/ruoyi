package com.ruoyi.worktask.service.impl;

import java.util.Iterator;
import java.util.List;

import com.ruoyi.activiti.domain.HistoryTaskVo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.worktask.mapper.WorkTaskActivityMapper;
import com.ruoyi.worktask.domain.WorkTaskActivity;
import com.ruoyi.worktask.service.IWorkTaskActivityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专项工作汇报内容 服务层实现
 *
 * @author ruoyi
 * @date 2019-03-26
 */
@Service
public class WorkTaskActivityServiceImpl implements IWorkTaskActivityService
{
	@Autowired
	private WorkTaskActivityMapper workTaskActivityMapper;
	@Autowired
	private ISysUserService userService;
	@Autowired
	HistoryService historyService;
	/**
     * 查询专项工作汇报内容信息
     *
     * @param id 专项工作汇报内容ID
     * @return 专项工作汇报内容信息
     */
    @Override
	public WorkTaskActivity selectWorkTaskActivityById(String id)
	{
	    return workTaskActivityMapper.selectWorkTaskActivityById(id);
	}

	@Override
	public WorkTaskActivity selectWorkTaskActivityByProId(String proId) {
		return workTaskActivityMapper.selectWorkTaskActivityByProId(proId);
	}

	/**
     * 查询专项工作汇报内容列表
     *
     * @param workTaskActivity 专项工作汇报内容信息
     * @return 专项工作汇报内容集合
     */
	@Override
	public List<WorkTaskActivity> selectWorkTaskActivityList(WorkTaskActivity workTaskActivity)
	{
	    return workTaskActivityMapper.selectWorkTaskActivityList(workTaskActivity);
	}

    /**
     * 新增专项工作汇报内容
     *
     * @param workTaskActivity 专项工作汇报内容信息
     * @return 结果
     */
	@Override
	public int insertWorkTaskActivity(WorkTaskActivity workTaskActivity)
	{
	    return workTaskActivityMapper.insertWorkTaskActivity(workTaskActivity);
	}

	/**
     * 修改专项工作汇报内容
     *
     * @param workTaskActivity 专项工作汇报内容信息
     * @return 结果
     */
	@Override
	public int updateWorkTaskActivity(WorkTaskActivity workTaskActivity)
	{
	    return workTaskActivityMapper.updateWorkTaskActivity(workTaskActivity);
	}

	/**
     * 删除专项工作汇报内容对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWorkTaskActivityByIds(String ids)
	{
		return workTaskActivityMapper.deleteWorkTaskActivityByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<WorkTaskActivity> selectWorkTaskActivityListExt(WorkTaskActivity workTaskActivity) {
		List<WorkTaskActivity> list = workTaskActivityMapper.selectWorkTaskActivityList(workTaskActivity);
		Iterator<WorkTaskActivity> taskActivityIterator = list.iterator();
		while (taskActivityIterator.hasNext()){
			workTaskActivity = taskActivityIterator.next();
			String process_instance_id = workTaskActivity.getProcess_instance_id();
			if(StringUtils.isNotEmpty(process_instance_id)){
				List<HistoricActivityInstance> historicActivityInstances=historyService // 历史相关Service
						.createHistoricActivityInstanceQuery() // 创建历史活动实例查询
						.processInstanceId(process_instance_id) // 执行流程实例id
						.finished()
						.orderByHistoricActivityInstanceStartTime().asc()
						.list();
				for(HistoricActivityInstance hai:historicActivityInstances){
					HistoryTaskVo historyTaskVo=new HistoryTaskVo();
					BeanUtils.copyProperties(hai,historyTaskVo);
					getDesc( workTaskActivity , hai, process_instance_id, historyTaskVo);
					queryVariables(workTaskActivity,hai,process_instance_id, historyTaskVo);
					workTaskActivity.getHistoryTaskVos().add(historyTaskVo);
					workTaskActivity.setWorkStatus(historyTaskVo.getQueryVariables());
				}
			}
		}
		return list;
	}

	private void queryVariables(WorkTaskActivity workTaskActivity, HistoricActivityInstance hai, String process_instance_id, HistoryTaskVo historyTaskVo) {
		String queryVariables = historyTaskVo.getQueryVariables();
		historyTaskVo.setQueryVariables("");
		if(StringUtils.isNotEmpty(queryVariables)){
			String[] arrUsers = queryVariables.split(",");
			for (String loginName:arrUsers) {
				SysUser user = userService.selectUserByLoginName(loginName);
				if(user!=null){
					historyTaskVo.setQueryVariables(user.getUserName()+",");
				}
			}
			if(hai.getActivityId().equalsIgnoreCase("zhurenduban")){
				historyTaskVo.setDescription("主任分配任务执行人:"+historyTaskVo.getQueryVariables());
			}
		}
	}

	@Override
	public List<WorkTaskActivity> selectWorkTaskActivityListPhone(WorkTaskActivity workTaskActivity) {
		List<WorkTaskActivity> list = workTaskActivityMapper.selectWorkTaskActivityList(workTaskActivity);
		Iterator<WorkTaskActivity> taskActivityIterator = list.iterator();
		while (taskActivityIterator.hasNext()){
			workTaskActivity = taskActivityIterator.next();
			String process_instance_id = workTaskActivity.getProcess_instance_id();
			if(StringUtils.isNotEmpty(process_instance_id)){
				List<HistoricActivityInstance> historicActivityInstances=historyService // 历史相关Service
						.createHistoricActivityInstanceQuery() // 创建历史活动实例查询
						.processInstanceId(process_instance_id) // 执行流程实例id
						.finished()
						.orderByHistoricActivityInstanceStartTime().asc()
						.list();
				for(HistoricActivityInstance hai:historicActivityInstances){
					HistoryTaskVo historyTaskVo=new HistoryTaskVo();
					BeanUtils.copyProperties(hai,historyTaskVo);
					getDesc( workTaskActivity , hai, process_instance_id, historyTaskVo);
					queryVariablesPhone(workTaskActivity,hai,process_instance_id, historyTaskVo);
					workTaskActivity.getHistoryTaskVos().add(historyTaskVo);
					workTaskActivity.setWorkStatus(historyTaskVo.getQueryVariables());
				}
			}
		}
		return list;
	}

	private void queryVariablesPhone(WorkTaskActivity workTaskActivity, HistoricActivityInstance hai, String process_instance_id, HistoryTaskVo historyTaskVo) {
		String queryVariables = historyTaskVo.getQueryVariables();
		historyTaskVo.setQueryVariables("");
		if(StringUtils.isNotEmpty(queryVariables)){
			String[] arrUsers = queryVariables.split(",");
			for (String loginName:arrUsers) {
				SysUser user = userService.selectUserByLoginName(loginName);
				if(user!=null){
					historyTaskVo.setQueryVariables(user.getPhonenumber()+",");
				}
			}
			if(hai.getActivityId().equalsIgnoreCase("zhurenduban")){
				historyTaskVo.setDescription("主任分配任务执行人:"+historyTaskVo.getQueryVariables());
			}
		}
	}

	public void getDesc(WorkTaskActivity workTaskActivity ,HistoricActivityInstance hai,String process_instance_id,HistoryTaskVo historyTaskVo){
		SysUser assignee = userService.selectUserByLoginName(historyTaskVo.getAssignee());
		if(assignee!=null){
			historyTaskVo.setAssignee(assignee.getDept().getDeptName()+assignee.getUserName());
		}
		String desc="";
		if(hai.getActivityId().equalsIgnoreCase("start")){
			HistoricVariableInstance zhuren_users = historyService.createHistoricVariableInstanceQuery()
					.processInstanceId(process_instance_id)
					.variableName("zhuren_users").singleResult();
			historyTaskVo.setQueryVariables(zhuren_users.getValue().toString());
			desc="待分配";
		}else if(hai.getActivityId().equalsIgnoreCase("zhurenduban")){
			HistoricVariableInstance yuangong_users = historyService.createHistoricVariableInstanceQuery()
					.processInstanceId(process_instance_id)
					.variableName("yuangong_users").singleResult();
			historyTaskVo.setQueryVariables(yuangong_users.getValue().toString());
			desc="待提交";
		}else if(hai.getActivityId().equalsIgnoreCase("gerentijiao")){
			HistoricVariableInstance fenguan_users = historyService.createHistoricVariableInstanceQuery()
					.processInstanceId(process_instance_id)
					.variableName("fenguan_users").singleResult();
			historyTaskVo.setQueryVariables(fenguan_users.getValue().toString());
			historyTaskVo.setDescription(historyTaskVo.getAssignee()+"提交工作内容："+workTaskActivity.getContent());
			desc="待评分";
		}else if(hai.getActivityId().equalsIgnoreCase("lingdaopingfen")){
			historyTaskVo.setDescription("分管领导评分:"+workTaskActivity.getTargetScore());
			historyTaskVo.setRepContent(workTaskActivity.getRepContent());
			desc="任务结束";
		}else if(hai.getActivityId().equalsIgnoreCase("end")){
			historyTaskVo.setDescription("任务结束");
			desc="任务结束";
		}
		workTaskActivity.setDelFlag(desc);
	}

}
