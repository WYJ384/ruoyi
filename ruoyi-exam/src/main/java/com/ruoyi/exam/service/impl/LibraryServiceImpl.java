package com.ruoyi.exam.service.impl;

import java.util.List;

import com.ruoyi.exam.domain.LibraryQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.LibraryMapper;
import com.ruoyi.exam.domain.Library;
import com.ruoyi.exam.service.ILibraryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 试题库 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
@Service
public class LibraryServiceImpl implements ILibraryService 
{
	@Autowired
	private LibraryMapper libraryMapper;

	/**
     * 查询试题库信息
     * 
     * @param id 试题库ID
     * @return 试题库信息
     */
    @Override
	public Library selectLibraryById(String id)
	{
	    return libraryMapper.selectLibraryById(id);
	}
	
	/**
     * 查询试题库列表
     * 
     * @param library 试题库信息
     * @return 试题库集合
     */
	@Override
	public List<Library> selectLibraryList(Library library)
	{
	    return libraryMapper.selectLibraryList(library);
	}
	
    /**
     * 新增试题库
     * 
     * @param library 试题库信息
     * @return 结果
     */
	@Override
	public int insertLibrary(Library library)
	{
	    return libraryMapper.insertLibrary(library);
	}
	
	/**
     * 修改试题库
     * 
     * @param library 试题库信息
     * @return 结果
     */
	@Override
	public int updateLibrary(Library library)
	{
	    return libraryMapper.updateLibrary(library);
	}

	/**
     * 删除试题库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLibraryByIds(String ids)
	{
		return libraryMapper.deleteLibraryByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<LibraryQuestion> selectLibraryQuestionList(LibraryQuestion libraryQuestion) {

		return libraryMapper.selectLibraryQuestionList(libraryQuestion);
	}

}
