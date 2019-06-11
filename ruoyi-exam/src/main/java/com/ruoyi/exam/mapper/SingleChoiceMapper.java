package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.SingleChoice;
import java.util.List;	

/**
 * 单选题 数据层
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
public interface SingleChoiceMapper 
{
	/**
     * 查询单选题信息
     * 
     * @param id 单选题ID
     * @return 单选题信息
     */
	public SingleChoice selectSingleChoiceById(String id);
	
	/**
     * 查询单选题列表
     * 
     * @param singleChoice 单选题信息
     * @return 单选题集合
     */
	public List<SingleChoice> selectSingleChoiceList(SingleChoice singleChoice);
	
	/**
     * 新增单选题
     * 
     * @param singleChoice 单选题信息
     * @return 结果
     */
	public int insertSingleChoice(SingleChoice singleChoice);
	
	/**
     * 修改单选题
     * 
     * @param singleChoice 单选题信息
     * @return 结果
     */
	public int updateSingleChoice(SingleChoice singleChoice);
	
	/**
     * 删除单选题
     * 
     * @param id 单选题ID
     * @return 结果
     */
	public int deleteSingleChoiceById(String id);
	
	/**
     * 批量删除单选题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSingleChoiceByIds(String[] ids);
	
}