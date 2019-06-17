package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.LibraryDetail;
import java.util.List;

/**
 * 题库内容 服务层
 * 
 * @author ruoyi
 * @date 2019-06-17
 */
public interface ILibraryDetailService 
{
	/**
     * 查询题库内容信息
     * 
     * @param id 题库内容ID
     * @return 题库内容信息
     */
	public LibraryDetail selectLibraryDetailById(String id);
	
	/**
     * 查询题库内容列表
     * 
     * @param libraryDetail 题库内容信息
     * @return 题库内容集合
     */
	public List<LibraryDetail> selectLibraryDetailList(LibraryDetail libraryDetail);
	
	/**
     * 新增题库内容
     * 
     * @param libraryDetail 题库内容信息
     * @return 结果
     */
	public int insertLibraryDetail(LibraryDetail libraryDetail);
	
	/**
     * 修改题库内容
     * 
     * @param libraryDetail 题库内容信息
     * @return 结果
     */
	public int updateLibraryDetail(LibraryDetail libraryDetail);
		
	/**
     * 删除题库内容信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLibraryDetailByIds(String ids);
	
}
