package com.ruoyi.exam.service;

import com.ruoyi.common.core.domain.ZtreeExt;
import com.ruoyi.exam.domain.LibraryCategory;
import java.util.List;

/**
 * 题库类型 服务层
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
public interface ILibraryCategoryService 
{
	/**
     * 查询题库类型信息
     * 
     * @param id 题库类型ID
     * @return 题库类型信息
     */
	public LibraryCategory selectLibraryCategoryById(String id);
	
	/**
     * 查询题库类型列表
     * 
     * @param libraryCategory 题库类型信息
     * @return 题库类型集合
     */
	public List<LibraryCategory> selectLibraryCategoryList(LibraryCategory libraryCategory);
	
	/**
     * 新增题库类型
     * 
     * @param libraryCategory 题库类型信息
     * @return 结果
     */
	public int insertLibraryCategory(LibraryCategory libraryCategory);
	
	/**
     * 修改题库类型
     * 
     * @param libraryCategory 题库类型信息
     * @return 结果
     */
	public int updateLibraryCategory(LibraryCategory libraryCategory);
		
	/**
     * 删除题库类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLibraryCategoryByIds(String ids);

    List<ZtreeExt> selectCategoryTree(LibraryCategory libraryCategory);

    Integer selectCountCategoryByParentId(String id);
}
