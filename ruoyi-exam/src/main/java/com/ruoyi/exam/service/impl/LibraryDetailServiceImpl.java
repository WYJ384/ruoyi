package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.LibraryDetailMapper;
import com.ruoyi.exam.domain.LibraryDetail;
import com.ruoyi.exam.service.ILibraryDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 题库内容 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-17
 */
@Service
public class LibraryDetailServiceImpl implements ILibraryDetailService 
{
	@Autowired
	private LibraryDetailMapper libraryDetailMapper;

	/**
     * 查询题库内容信息
     * 
     * @param id 题库内容ID
     * @return 题库内容信息
     */
    @Override
	public LibraryDetail selectLibraryDetailById(String id)
	{
	    return libraryDetailMapper.selectLibraryDetailById(id);
	}
	
	/**
     * 查询题库内容列表
     * 
     * @param libraryDetail 题库内容信息
     * @return 题库内容集合
     */
	@Override
	public List<LibraryDetail> selectLibraryDetailList(LibraryDetail libraryDetail)
	{
	    return libraryDetailMapper.selectLibraryDetailList(libraryDetail);
	}
	
    /**
     * 新增题库内容
     * 
     * @param libraryDetail 题库内容信息
     * @return 结果
     */
	@Override
	public int insertLibraryDetail(LibraryDetail libraryDetail)
	{
	    return libraryDetailMapper.insertLibraryDetail(libraryDetail);
	}
	
	/**
     * 修改题库内容
     * 
     * @param libraryDetail 题库内容信息
     * @return 结果
     */
	@Override
	public int updateLibraryDetail(LibraryDetail libraryDetail)
	{
	    return libraryDetailMapper.updateLibraryDetail(libraryDetail);
	}

	/**
     * 删除题库内容对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLibraryDetailByIds(String ids)
	{
		return libraryDetailMapper.deleteLibraryDetailByIds(Convert.toStrArray(ids));
	}
	
}
