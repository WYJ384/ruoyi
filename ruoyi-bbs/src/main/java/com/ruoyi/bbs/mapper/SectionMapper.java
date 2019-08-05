package com.ruoyi.bbs.mapper;

import com.ruoyi.bbs.domain.Section;
import java.util.List;	

/**
 * 板块 数据层
 * 
 * @author ruoyi
 * @date 2019-08-05
 */
public interface SectionMapper 
{
	/**
     * 查询板块信息
     * 
     * @param id 板块ID
     * @return 板块信息
     */
	public Section selectSectionById(String id);
	
	/**
     * 查询板块列表
     * 
     * @param section 板块信息
     * @return 板块集合
     */
	public List<Section> selectSectionList(Section section);
	
	/**
     * 新增板块
     * 
     * @param section 板块信息
     * @return 结果
     */
	public int insertSection(Section section);
	
	/**
     * 修改板块
     * 
     * @param section 板块信息
     * @return 结果
     */
	public int updateSection(Section section);
	
	/**
     * 删除板块
     * 
     * @param id 板块ID
     * @return 结果
     */
	public int deleteSectionById(String id);
	
	/**
     * 批量删除板块
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSectionByIds(String[] ids);
	
}