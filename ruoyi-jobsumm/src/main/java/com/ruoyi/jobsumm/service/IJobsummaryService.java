package com.ruoyi.jobsumm.service;

import com.ruoyi.jobsumm.domain.Jobsummary;
import java.util.List;

/**
 * 工作总结 服务层
 * 
 * @author ruoyi
 * @date 2019-06-14
 */
public interface IJobsummaryService 
{
	/**
     * 查询工作总结信息
     * 
     * @param id 工作总结ID
     * @return 工作总结信息
     */
	public Jobsummary selectJobsummaryById(String id);
	
	/**
     * 查询工作总结列表
     * 
     * @param jobsummary 工作总结信息
     * @return 工作总结集合
     */
	public List<Jobsummary> selectJobsummaryList(Jobsummary jobsummary);

	/**
	 * 查询工作总结——按创建时间排序 条件工作类型
	 *
	 * @param jobsummary 工作总结信息
	 * @return 工作总结集合
	 */
	public List<Jobsummary> selectJobsummaryListDesc(Jobsummary jobsummary);
	
	/**
     * 新增工作总结
     * 
     * @param jobsummary 工作总结信息
     * @return 结果
     */
	public int insertJobsummary(Jobsummary jobsummary);
	
	/**
     * 修改工作总结
     * 
     * @param jobsummary 工作总结信息
     * @return 结果
     */
	public int updateJobsummary(Jobsummary jobsummary);
		
	/**
     * 删除工作总结信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteJobsummaryByIds(String ids);
	
}
