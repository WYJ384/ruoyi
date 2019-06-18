package com.ruoyi.worktask.service.impl;

import java.util.List;

import com.ruoyi.worktask.domain.Goodness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.worktask.mapper.SelfTaskMapper;
import com.ruoyi.worktask.domain.SelfTask;
import com.ruoyi.worktask.service.ISelfTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * 任务 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-08
 */
@Service
public class SelfTaskServiceImpl implements ISelfTaskService 
{
	@Autowired
	private SelfTaskMapper selfTaskMapper;

	/**
     * 查询任务信息
     * 
     * @param id 任务ID
     * @return 任务信息
     */
    @Override
	public SelfTask selectSelfTaskById(String id)
	{
	    return selfTaskMapper.selectSelfTaskById(id);
	}

	@Override
	public Goodness selectGoodnessTaskById(String id) {

		return selfTaskMapper.selectGoodnessTaskById(id);
	}

	/**
     * 查询任务列表
     * 
     * @param selfTask 任务信息
     * @return 任务集合
     */
	@Override
	public List<SelfTask> selectSelfTaskList(SelfTask selfTask)
	{
	    return selfTaskMapper.selectSelfTaskList(selfTask);
	}

	@Override
	public List<Goodness> goodnessTaskList(Goodness goodness) {

		return selfTaskMapper.goodnessTaskList(goodness);
	}

	/**
     * 新增任务
     * 
     * @param selfTask 任务信息
     * @return 结果
     */
	@Override
	public int insertSelfTask(SelfTask selfTask)
	{
	    return selfTaskMapper.insertSelfTask(selfTask);
	}
	
	/**
     * 修改任务
     * 
     * @param selfTask 任务信息
     * @return 结果
     */
	@Override
	public int updateSelfTask(SelfTask selfTask)
	{
	    return selfTaskMapper.updateSelfTask(selfTask);
	}

	/**
     * 删除任务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSelfTaskByIds(String ids)
	{
		return selfTaskMapper.deleteSelfTaskByIds(Convert.toStrArray(ids));
	}
	
}
