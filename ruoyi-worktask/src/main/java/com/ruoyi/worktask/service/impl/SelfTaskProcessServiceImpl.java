package com.ruoyi.worktask.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.worktask.mapper.SelfTaskProcessMapper;
import com.ruoyi.worktask.domain.SelfTaskProcess;
import com.ruoyi.worktask.service.ISelfTaskProcessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 任务进度 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-09
 */
@Service
public class SelfTaskProcessServiceImpl implements ISelfTaskProcessService 
{
	@Autowired
	private SelfTaskProcessMapper selfTaskProcessMapper;

	/**
     * 查询任务进度信息
     * 
     * @param id 任务进度ID
     * @return 任务进度信息
     */
    @Override
	public SelfTaskProcess selectSelfTaskProcessById(String id)
	{
	    return selfTaskProcessMapper.selectSelfTaskProcessById(id);
	}
	
	/**
     * 查询任务进度列表
     * 
     * @param selfTaskProcess 任务进度信息
     * @return 任务进度集合
     */
	@Override
	public List<SelfTaskProcess> selectSelfTaskProcessList(SelfTaskProcess selfTaskProcess)
	{
	    return selfTaskProcessMapper.selectSelfTaskProcessList(selfTaskProcess);
	}
	
    /**
     * 新增任务进度
     * 
     * @param selfTaskProcess 任务进度信息
     * @return 结果
     */
	@Override
	public int insertSelfTaskProcess(SelfTaskProcess selfTaskProcess)
	{
	    return selfTaskProcessMapper.insertSelfTaskProcess(selfTaskProcess);
	}
	
	/**
     * 修改任务进度
     * 
     * @param selfTaskProcess 任务进度信息
     * @return 结果
     */
	@Override
	public int updateSelfTaskProcess(SelfTaskProcess selfTaskProcess)
	{
	    return selfTaskProcessMapper.updateSelfTaskProcess(selfTaskProcess);
	}

	/**
     * 删除任务进度对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSelfTaskProcessByIds(String ids)
	{
		return selfTaskProcessMapper.deleteSelfTaskProcessByIds(Convert.toStrArray(ids));
	}
	
}
