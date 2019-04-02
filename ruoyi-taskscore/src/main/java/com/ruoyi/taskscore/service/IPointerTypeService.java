package com.ruoyi.taskscore.service;

import com.ruoyi.taskscore.domain.PointerType;
import java.util.List;

/**
 * 评分指标类型 服务层
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public interface IPointerTypeService 
{
	/**
     * 查询评分指标类型信息
     * 
     * @param id 评分指标类型ID
     * @return 评分指标类型信息
     */
	public PointerType selectPointerTypeById(String id);
	
	/**
     * 查询评分指标类型列表
     * 
     * @param pointerType 评分指标类型信息
     * @return 评分指标类型集合
     */
	public List<PointerType> selectPointerTypeList(PointerType pointerType);
	
	/**
     * 新增评分指标类型
     * 
     * @param pointerType 评分指标类型信息
     * @return 结果
     */
	public int insertPointerType(PointerType pointerType);
	
	/**
     * 修改评分指标类型
     * 
     * @param pointerType 评分指标类型信息
     * @return 结果
     */
	public int updatePointerType(PointerType pointerType);
		
	/**
     * 删除评分指标类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePointerTypeByIds(String ids);
	
}
