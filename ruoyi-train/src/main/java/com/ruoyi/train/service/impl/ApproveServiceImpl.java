package com.ruoyi.train.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.train.mapper.ApproveMapper;
import com.ruoyi.train.domain.Approve;
import com.ruoyi.train.service.IApproveService;
import com.ruoyi.common.core.text.Convert;

/**
 * 付款审批 服务层实现
 * 
 * @author ruoyi
 * @date 2019-07-23
 */
@Service
public class ApproveServiceImpl implements IApproveService 
{
	@Autowired
	private ApproveMapper approveMapper;

	/**
     * 查询付款审批信息
     * 
     * @param id 付款审批ID
     * @return 付款审批信息
     */
    @Override
	public Approve selectApproveById(String id)
	{
	    return approveMapper.selectApproveById(id);
	}
	
	/**
     * 查询付款审批列表
     * 
     * @param approve 付款审批信息
     * @return 付款审批集合
     */
	@Override
	public List<Approve> selectApproveList(Approve approve)
	{
	    return approveMapper.selectApproveList(approve);
	}
	
    /**
     * 新增付款审批
     * 
     * @param approve 付款审批信息
     * @return 结果
     */
	@Override
	public int insertApprove(Approve approve)
	{
	    return approveMapper.insertApprove(approve);
	}
	
	/**
     * 修改付款审批
     * 
     * @param approve 付款审批信息
     * @return 结果
     */
	@Override
	public int updateApprove(Approve approve)
	{
	    return approveMapper.updateApprove(approve);
	}

	/**
     * 删除付款审批对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteApproveByIds(String ids)
	{
		return approveMapper.deleteApproveByIds(Convert.toStrArray(ids));
	}

	@Override
	public Integer getMaxSQBH() {
		return approveMapper.getMaxSQBH();
	}

}
