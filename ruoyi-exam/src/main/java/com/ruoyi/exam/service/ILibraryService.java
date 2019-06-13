package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.Library;
import com.ruoyi.exam.domain.LibraryQuestion;

import java.util.List;

/**
 * 试题库 服务层
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
public interface ILibraryService 
{
	/**
     * 查询试题库信息
     * 
     * @param id 试题库ID
     * @return 试题库信息
     */
	public Library selectLibraryById(String id);
	
	/**
     * 查询试题库列表
     * 
     * @param library 试题库信息
     * @return 试题库集合
     */
	public List<Library> selectLibraryList(Library library);
	
	/**
     * 新增试题库
     * 
     * @param library 试题库信息
     * @return 结果
     */
	public int insertLibrary(Library library);
	
	/**
     * 修改试题库
     * 
     * @param library 试题库信息
     * @return 结果
     */
	public int updateLibrary(Library library);
		
	/**
     * 删除试题库信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLibraryByIds(String ids);

	List<LibraryQuestion> selectLibraryQuestionList(LibraryQuestion libraryQuestion);
}
