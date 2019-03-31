package com.ruoyi.worktask.service.impl;

import java.util.List;
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


}
