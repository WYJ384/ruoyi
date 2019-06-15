package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.LibraryQuestionMapper;
import com.ruoyi.exam.domain.LibraryQuestion;
import com.ruoyi.exam.service.ILibraryQuestionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 题库-试题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
@Service
public class LibraryQuestionServiceImpl implements ILibraryQuestionService 
{
	@Autowired
	private LibraryQuestionMapper libraryQuestionMapper;

	/**
     * 查询题库-试题信息
     * 
     * @param examLibId 题库-试题ID
     * @return 题库-试题信息
     */
    @Override
	public LibraryQuestion selectLibraryQuestionById(String examLibId)
	{
	    return libraryQuestionMapper.selectLibraryQuestionById(examLibId);
	}
	
	/**
     * 查询题库-试题列表
     * 
     * @param libraryQuestion 题库-试题信息
     * @return 题库-试题集合
     */
	@Override
	public List<LibraryQuestion> selectLibraryQuestionList(LibraryQuestion libraryQuestion)
	{
	    return libraryQuestionMapper.selectLibraryQuestionList(libraryQuestion);
	}
	
    /**
     * 新增题库-试题
     * 
     * @param libraryQuestion 题库-试题信息
     * @return 结果
     */
	@Override
	public int insertLibraryQuestion(LibraryQuestion libraryQuestion)
	{
	    return libraryQuestionMapper.insertLibraryQuestion(libraryQuestion);
	}
	
	/**
     * 修改题库-试题
     * 
     * @param libraryQuestion 题库-试题信息
     * @return 结果
     */
	@Override
	public int updateLibraryQuestion(LibraryQuestion libraryQuestion)
	{
	    return libraryQuestionMapper.updateLibraryQuestion(libraryQuestion);
	}

	/**
     * 删除题库-试题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLibraryQuestionByIds(String ids)
	{
		return libraryQuestionMapper.deleteLibraryQuestionByIds(Convert.toStrArray(ids));
	}
	
}
