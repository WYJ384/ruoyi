package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.LibraryQuestion;
import java.util.List;

/**
 * 题库-试题 服务层
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
public interface ILibraryQuestionService 
{
	/**
     * 查询题库-试题信息
     * 
     * @param examLibId 题库-试题ID
     * @return 题库-试题信息
     */
	public LibraryQuestion selectLibraryQuestionById(String examLibId);
	
	/**
     * 查询题库-试题列表
     * 
     * @param libraryQuestion 题库-试题信息
     * @return 题库-试题集合
     */
	public List<LibraryQuestion> selectLibraryQuestionList(LibraryQuestion libraryQuestion);
	
	/**
     * 新增题库-试题
     * 
     * @param libraryQuestion 题库-试题信息
     * @return 结果
     */
	public int insertLibraryQuestion(LibraryQuestion libraryQuestion);
	
	/**
     * 修改题库-试题
     * 
     * @param libraryQuestion 题库-试题信息
     * @return 结果
     */
	public int updateLibraryQuestion(LibraryQuestion libraryQuestion);
		
	/**
     * 删除题库-试题信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLibraryQuestionByIds(String ids);
	
}
