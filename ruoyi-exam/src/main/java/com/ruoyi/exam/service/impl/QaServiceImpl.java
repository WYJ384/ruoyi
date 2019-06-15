package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.QaMapper;
import com.ruoyi.exam.domain.Qa;
import com.ruoyi.exam.service.IQaService;
import com.ruoyi.common.core.text.Convert;

/**
 * 问答题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
@Service
public class QaServiceImpl implements IQaService 
{
	@Autowired
	private QaMapper qaMapper;

	/**
     * 查询问答题信息
     * 
     * @param id 问答题ID
     * @return 问答题信息
     */
    @Override
	public Qa selectQaById(String id)
	{
	    return qaMapper.selectQaById(id);
	}
	
	/**
     * 查询问答题列表
     * 
     * @param qa 问答题信息
     * @return 问答题集合
     */
	@Override
	public List<Qa> selectQaList(Qa qa)
	{
	    return qaMapper.selectQaList(qa);
	}
	
    /**
     * 新增问答题
     * 
     * @param qa 问答题信息
     * @return 结果
     */
	@Override
	public int insertQa(Qa qa)
	{
	    return qaMapper.insertQa(qa);
	}
	
	/**
     * 修改问答题
     * 
     * @param qa 问答题信息
     * @return 结果
     */
	@Override
	public int updateQa(Qa qa)
	{
	    return qaMapper.updateQa(qa);
	}

	/**
     * 删除问答题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteQaByIds(String ids)
	{
		return qaMapper.deleteQaByIds(Convert.toStrArray(ids));
	}
	
}
