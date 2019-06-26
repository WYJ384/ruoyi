package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.Result;
import java.util.List;

/**
 * 考试成绩 服务层
 * 
 * @author ruoyi
 * @date 2019-06-26
 */
public interface IResultService 
{
	/**
     * 查询考试成绩信息
     * 
     * @param examId 考试成绩ID
     * @return 考试成绩信息
     */
	public Result selectResultById(String examId);
	
	/**
     * 查询考试成绩列表
     * 
     * @param result 考试成绩信息
     * @return 考试成绩集合
     */
	public List<Result> selectResultList(Result result);
	
	/**
     * 新增考试成绩
     * 
     * @param result 考试成绩信息
     * @return 结果
     */
	public int insertResult(Result result);
	
	/**
     * 修改考试成绩
     * 
     * @param result 考试成绩信息
     * @return 结果
     */
	public int updateResult(Result result);
		
	/**
     * 删除考试成绩信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteResultByIds(String ids);
	
}
