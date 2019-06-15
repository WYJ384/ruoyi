package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.MultChoiceMapper;
import com.ruoyi.exam.domain.MultChoice;
import com.ruoyi.exam.service.IMultChoiceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 多选题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-14
 */
@Service
public class MultChoiceServiceImpl implements IMultChoiceService 
{
	@Autowired
	private MultChoiceMapper multChoiceMapper;

	/**
     * 查询多选题信息
     * 
     * @param id 多选题ID
     * @return 多选题信息
     */
    @Override
	public MultChoice selectMultChoiceById(String id)
	{
	    return multChoiceMapper.selectMultChoiceById(id);
	}
	
	/**
     * 查询多选题列表
     * 
     * @param multChoice 多选题信息
     * @return 多选题集合
     */
	@Override
	public List<MultChoice> selectMultChoiceList(MultChoice multChoice)
	{
	    return multChoiceMapper.selectMultChoiceList(multChoice);
	}
	
    /**
     * 新增多选题
     * 
     * @param multChoice 多选题信息
     * @return 结果
     */
	@Override
	public int insertMultChoice(MultChoice multChoice)
	{
	    return multChoiceMapper.insertMultChoice(multChoice);
	}
	
	/**
     * 修改多选题
     * 
     * @param multChoice 多选题信息
     * @return 结果
     */
	@Override
	public int updateMultChoice(MultChoice multChoice)
	{
	    return multChoiceMapper.updateMultChoice(multChoice);
	}

	/**
     * 删除多选题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMultChoiceByIds(String ids)
	{
		return multChoiceMapper.deleteMultChoiceByIds(Convert.toStrArray(ids));
	}
	
}
