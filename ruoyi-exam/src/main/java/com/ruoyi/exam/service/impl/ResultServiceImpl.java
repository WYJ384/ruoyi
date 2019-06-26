package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ResultMapper;
import com.ruoyi.exam.domain.Result;
import com.ruoyi.exam.service.IResultService;
import com.ruoyi.common.core.text.Convert;

/**
 * 考试成绩 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-26
 */
@Service
public class ResultServiceImpl implements IResultService 
{
	@Autowired
	private ResultMapper resultMapper;

	/**
     * 查询考试成绩信息
     * 
     * @param examId 考试成绩ID
     * @return 考试成绩信息
     */
    @Override
	public Result selectResultById(String examId)
	{
	    return resultMapper.selectResultById(examId);
	}
	
	/**
     * 查询考试成绩列表
     * 
     * @param result 考试成绩信息
     * @return 考试成绩集合
     */
	@Override
	public List<Result> selectResultList(Result result)
	{
	    return resultMapper.selectResultList(result);
	}
	
    /**
     * 新增考试成绩
     * 
     * @param result 考试成绩信息
     * @return 结果
     */
	@Override
	public int insertResult(Result result)
	{
	    return resultMapper.insertResult(result);
	}
	
	/**
     * 修改考试成绩
     * 
     * @param result 考试成绩信息
     * @return 结果
     */
	@Override
	public int updateResult(Result result)
	{
	    return resultMapper.updateResult(result);
	}

	/**
     * 删除考试成绩对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteResultByIds(String ids)
	{
		return resultMapper.deleteResultByIds(Convert.toStrArray(ids));
	}
	
}
