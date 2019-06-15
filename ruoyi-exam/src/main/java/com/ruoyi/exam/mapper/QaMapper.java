package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.Qa;
import java.util.List;	

/**
 * 问答题 数据层
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
public interface QaMapper 
{
	/**
     * 查询问答题信息
     * 
     * @param id 问答题ID
     * @return 问答题信息
     */
	public Qa selectQaById(String id);
	
	/**
     * 查询问答题列表
     * 
     * @param qa 问答题信息
     * @return 问答题集合
     */
	public List<Qa> selectQaList(Qa qa);
	
	/**
     * 新增问答题
     * 
     * @param qa 问答题信息
     * @return 结果
     */
	public int insertQa(Qa qa);
	
	/**
     * 修改问答题
     * 
     * @param qa 问答题信息
     * @return 结果
     */
	public int updateQa(Qa qa);
	
	/**
     * 删除问答题
     * 
     * @param id 问答题ID
     * @return 结果
     */
	public int deleteQaById(String id);
	
	/**
     * 批量删除问答题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteQaByIds(String[] ids);
	
}