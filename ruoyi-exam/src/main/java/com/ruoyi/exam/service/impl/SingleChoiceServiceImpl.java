package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.SingleChoiceMapper;
import com.ruoyi.exam.domain.SingleChoice;
import com.ruoyi.exam.service.ISingleChoiceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 单选题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
@Service
public class SingleChoiceServiceImpl implements ISingleChoiceService 
{
	@Autowired
	private SingleChoiceMapper singleChoiceMapper;

	/**
     * 查询单选题信息
     * 
     * @param id 单选题ID
     * @return 单选题信息
     */
    @Override
	public SingleChoice selectSingleChoiceById(String id)
	{
	    return singleChoiceMapper.selectSingleChoiceById(id);
	}
	
	/**
     * 查询单选题列表
     * 
     * @param singleChoice 单选题信息
     * @return 单选题集合
     */
	@Override
	public List<SingleChoice> selectSingleChoiceList(SingleChoice singleChoice)
	{
	    return singleChoiceMapper.selectSingleChoiceList(singleChoice);
	}
	
    /**
     * 新增单选题
     * 
     * @param singleChoice 单选题信息
     * @return 结果
     */
	@Override
	public int insertSingleChoice(SingleChoice singleChoice)
	{
	    return singleChoiceMapper.insertSingleChoice(singleChoice);
	}
	
	/**
     * 修改单选题
     * 
     * @param singleChoice 单选题信息
     * @return 结果
     */
	@Override
	public int updateSingleChoice(SingleChoice singleChoice)
	{
	    return singleChoiceMapper.updateSingleChoice(singleChoice);
	}

	/**
     * 删除单选题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSingleChoiceByIds(String ids)
	{
		return singleChoiceMapper.deleteSingleChoiceByIds(Convert.toStrArray(ids));
	}
	
}
