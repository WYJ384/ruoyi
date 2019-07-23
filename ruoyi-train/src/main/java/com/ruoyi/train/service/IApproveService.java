package com.ruoyi.train.service;

import com.ruoyi.train.domain.Approve;
import java.util.List;

/**
 * 付款审批 服务层
 * 
 * @author ruoyi
 * @date 2019-07-23
 */
public interface IApproveService 
{
	/**
     * 查询付款审批信息
     * 
     * @param id 付款审批ID
     * @return 付款审批信息
     */
	public Approve selectApproveById(String id);
	
	/**
     * 查询付款审批列表
     * 
     * @param approve 付款审批信息
     * @return 付款审批集合
     */
	public List<Approve> selectApproveList(Approve approve);
	
	/**
     * 新增付款审批
     * 
     * @param approve 付款审批信息
     * @return 结果
     */
	public int insertApprove(Approve approve);
	
	/**
     * 修改付款审批
     * 
     * @param approve 付款审批信息
     * @return 结果
     */
	public int updateApprove(Approve approve);
		
	/**
     * 删除付款审批信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteApproveByIds(String ids);
	
}
