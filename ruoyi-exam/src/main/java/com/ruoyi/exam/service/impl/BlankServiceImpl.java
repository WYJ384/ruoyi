package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.BlankMapper;
import com.ruoyi.exam.domain.Blank;
import com.ruoyi.exam.service.IBlankService;
import com.ruoyi.common.core.text.Convert;

/**
 * 填空题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-12
 */
@Service
public class BlankServiceImpl implements IBlankService 
{
	@Autowired
	private BlankMapper blankMapper;

	/**
     * 查询填空题信息
     * 
     * @param id 填空题ID
     * @return 填空题信息
     */
    @Override
	public Blank selectBlankById(String id)
	{
	    return blankMapper.selectBlankById(id);
	}
	
	/**
     * 查询填空题列表
     * 
     * @param blank 填空题信息
     * @return 填空题集合
     */
	@Override
	public List<Blank> selectBlankList(Blank blank)
	{
	    return blankMapper.selectBlankList(blank);
	}
	
    /**
     * 新增填空题
     * 
     * @param blank 填空题信息
     * @return 结果
     */
	@Override
	public int insertBlank(Blank blank)
	{
	    return blankMapper.insertBlank(blank);
	}
	
	/**
     * 修改填空题
     * 
     * @param blank 填空题信息
     * @return 结果
     */
	@Override
	public int updateBlank(Blank blank)
	{
	    return blankMapper.updateBlank(blank);
	}

	/**
     * 删除填空题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBlankByIds(String ids)
	{
		return blankMapper.deleteBlankByIds(Convert.toStrArray(ids));
	}
	
}
