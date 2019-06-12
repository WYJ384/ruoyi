package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.Blank;
import java.util.List;	

/**
 * 填空题 数据层
 * 
 * @author ruoyi
 * @date 2019-06-12
 */
public interface BlankMapper 
{
	/**
     * 查询填空题信息
     * 
     * @param id 填空题ID
     * @return 填空题信息
     */
	public Blank selectBlankById(String id);
	
	/**
     * 查询填空题列表
     * 
     * @param blank 填空题信息
     * @return 填空题集合
     */
	public List<Blank> selectBlankList(Blank blank);
	
	/**
     * 新增填空题
     * 
     * @param blank 填空题信息
     * @return 结果
     */
	public int insertBlank(Blank blank);
	
	/**
     * 修改填空题
     * 
     * @param blank 填空题信息
     * @return 结果
     */
	public int updateBlank(Blank blank);
	
	/**
     * 删除填空题
     * 
     * @param id 填空题ID
     * @return 结果
     */
	public int deleteBlankById(String id);
	
	/**
     * 批量删除填空题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBlankByIds(String[] ids);
	
}