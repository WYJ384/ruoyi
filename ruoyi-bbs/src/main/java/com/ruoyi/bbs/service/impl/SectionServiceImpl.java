package com.ruoyi.bbs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bbs.mapper.SectionMapper;
import com.ruoyi.bbs.domain.Section;
import com.ruoyi.bbs.service.ISectionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 板块 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-05
 */
@Service
public class SectionServiceImpl implements ISectionService 
{
	@Autowired
	private SectionMapper sectionMapper;

	/**
     * 查询板块信息
     * 
     * @param id 板块ID
     * @return 板块信息
     */
    @Override
	public Section selectSectionById(String id)
	{
	    return sectionMapper.selectSectionById(id);
	}
	
	/**
     * 查询板块列表
     * 
     * @param section 板块信息
     * @return 板块集合
     */
	@Override
	public List<Section> selectSectionList(Section section)
	{
	    return sectionMapper.selectSectionList(section);
	}
	
    /**
     * 新增板块
     * 
     * @param section 板块信息
     * @return 结果
     */
	@Override
	public int insertSection(Section section)
	{
	    return sectionMapper.insertSection(section);
	}
	
	/**
     * 修改板块
     * 
     * @param section 板块信息
     * @return 结果
     */
	@Override
	public int updateSection(Section section)
	{
	    return sectionMapper.updateSection(section);
	}

	/**
     * 删除板块对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSectionByIds(String ids)
	{
		return sectionMapper.deleteSectionByIds(Convert.toStrArray(ids));
	}
	
}
