package com.ruoyi.taskscore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taskscore.mapper.PointerTypeMapper;
import com.ruoyi.taskscore.domain.PointerType;
import com.ruoyi.taskscore.service.IPointerTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评分指标类型 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Service
public class PointerTypeServiceImpl implements IPointerTypeService 
{
	@Autowired
	private PointerTypeMapper pointerTypeMapper;

	/**
     * 查询评分指标类型信息
     * 
     * @param id 评分指标类型ID
     * @return 评分指标类型信息
     */
    @Override
	public PointerType selectPointerTypeById(String id)
	{
	    return pointerTypeMapper.selectPointerTypeById(id);
	}
	
	/**
     * 查询评分指标类型列表
     * 
     * @param pointerType 评分指标类型信息
     * @return 评分指标类型集合
     */
	@Override
	public List<PointerType> selectPointerTypeList(PointerType pointerType)
	{
	    return pointerTypeMapper.selectPointerTypeList(pointerType);
	}
	
    /**
     * 新增评分指标类型
     * 
     * @param pointerType 评分指标类型信息
     * @return 结果
     */
	@Override
	public int insertPointerType(PointerType pointerType)
	{
	    return pointerTypeMapper.insertPointerType(pointerType);
	}
	
	/**
     * 修改评分指标类型
     * 
     * @param pointerType 评分指标类型信息
     * @return 结果
     */
	@Override
	public int updatePointerType(PointerType pointerType)
	{
	    return pointerTypeMapper.updatePointerType(pointerType);
	}

	/**
     * 删除评分指标类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePointerTypeByIds(String ids)
	{
		return pointerTypeMapper.deletePointerTypeByIds(Convert.toStrArray(ids));
	}
	
}
