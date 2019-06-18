package com.ruoyi.jobsumm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jobsumm.mapper.JobsummaryMapper;
import com.ruoyi.jobsumm.domain.Jobsummary;
import com.ruoyi.jobsumm.service.IJobsummaryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 工作总结 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-14
 */
@Service
public class JobsummaryServiceImpl implements IJobsummaryService 
{
	@Autowired
	private JobsummaryMapper jobsummaryMapper;

	/**
     * 查询工作总结信息
     * 
     * @param id 工作总结ID
     * @return 工作总结信息
     */
    @Override
	public Jobsummary selectJobsummaryById(String id)
	{
	    return jobsummaryMapper.selectJobsummaryById(id);
	}
	
	/**
     * 查询工作总结列表
     * 
     * @param jobsummary 工作总结信息
     * @return 工作总结集合
     */
	@Override
	public List<Jobsummary> selectJobsummaryList(Jobsummary jobsummary)
	{
	    return jobsummaryMapper.selectJobsummaryList(jobsummary);
	}
	/**
	 * 查询工作总结——按创建时间排序 条件工作类型
	 *
	 * @param jobsummary 工作总结信息
	 * @return 工作总结集合
	 */
	public List<Jobsummary> selectJobsummaryListDesc(Jobsummary jobsummary){
		return jobsummaryMapper.selectJobsummaryList(jobsummary);
	};
	
    /**
     * 新增工作总结
     * 
     * @param jobsummary 工作总结信息
     * @return 结果
     */
	@Override
	public int insertJobsummary(Jobsummary jobsummary)
	{
	    return jobsummaryMapper.insertJobsummary(jobsummary);
	}
	
	/**
     * 修改工作总结
     * 
     * @param jobsummary 工作总结信息
     * @return 结果
     */
	@Override
	public int updateJobsummary(Jobsummary jobsummary)
	{
	    return jobsummaryMapper.updateJobsummary(jobsummary);
	}

	/**
     * 删除工作总结对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteJobsummaryByIds(String ids)
	{
		return jobsummaryMapper.deleteJobsummaryByIds(Convert.toStrArray(ids));
	}
	
}
