package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.MultChoice;
import java.util.List;	

/**
 * 多选题 数据层
 * 
 * @author ruoyi
 * @date 2019-06-14
 */
public interface MultChoiceMapper 
{
	/**
     * 查询多选题信息
     * 
     * @param id 多选题ID
     * @return 多选题信息
     */
	public MultChoice selectMultChoiceById(String id);
	
	/**
     * 查询多选题列表
     * 
     * @param multChoice 多选题信息
     * @return 多选题集合
     */
	public List<MultChoice> selectMultChoiceList(MultChoice multChoice);
	
	/**
     * 新增多选题
     * 
     * @param multChoice 多选题信息
     * @return 结果
     */
	public int insertMultChoice(MultChoice multChoice);
	
	/**
     * 修改多选题
     * 
     * @param multChoice 多选题信息
     * @return 结果
     */
	public int updateMultChoice(MultChoice multChoice);
	
	/**
     * 删除多选题
     * 
     * @param id 多选题ID
     * @return 结果
     */
	public int deleteMultChoiceById(String id);
	
	/**
     * 批量删除多选题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMultChoiceByIds(String[] ids);
	
}