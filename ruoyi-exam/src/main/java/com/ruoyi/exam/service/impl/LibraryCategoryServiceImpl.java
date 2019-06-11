package com.ruoyi.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.ZtreeExt;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.LibraryCategoryMapper;
import com.ruoyi.exam.domain.LibraryCategory;
import com.ruoyi.exam.service.ILibraryCategoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 题库类型 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
@Service
public class LibraryCategoryServiceImpl implements ILibraryCategoryService 
{
	@Autowired
	private LibraryCategoryMapper libraryCategoryMapper;

	/**
     * 查询题库类型信息
     * 
     * @param id 题库类型ID
     * @return 题库类型信息
     */
    @Override
	public LibraryCategory selectLibraryCategoryById(String id)
	{
	    return libraryCategoryMapper.selectLibraryCategoryById(id);
	}
	
	/**
     * 查询题库类型列表
     * 
     * @param libraryCategory 题库类型信息
     * @return 题库类型集合
     */
	@Override
	public List<LibraryCategory> selectLibraryCategoryList(LibraryCategory libraryCategory)
	{
	    return libraryCategoryMapper.selectLibraryCategoryList(libraryCategory);
	}
	
    /**
     * 新增题库类型
     * 
     * @param libraryCategory 题库类型信息
     * @return 结果
     */
	@Override
	public int insertLibraryCategory(LibraryCategory libraryCategory)
	{
		LibraryCategory info = libraryCategoryMapper.selectLibraryCategoryById(libraryCategory.getPid());
		if(info!=null){
			libraryCategory.setParentIds(info.getParentIds() + "," + libraryCategory.getPid());
		}else{
			libraryCategory.setParentIds("0," + libraryCategory.getPid());
		}


		return libraryCategoryMapper.insertLibraryCategory(libraryCategory);
	}
	
	/**
     * 修改题库类型
     * 
     * @param libraryCategory 题库类型信息
     * @return 结果
     */
	@Override
	public int updateLibraryCategory(LibraryCategory libraryCategory)
	{
	    return libraryCategoryMapper.updateLibraryCategory(libraryCategory);
	}

	/**
     * 删除题库类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLibraryCategoryByIds(String ids)
	{
		return libraryCategoryMapper.deleteLibraryCategoryByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<ZtreeExt> selectCategoryTree(LibraryCategory libraryCategory) {
		List<LibraryCategory> categories = libraryCategoryMapper.selectLibraryCategoryList(libraryCategory);
		List<ZtreeExt> ztrees = initZtree(categories);
		return ztrees;
	}

	@Override
	public Integer selectCountCategoryByParentId(String id) {

		return libraryCategoryMapper.selectCountCategoryByParentId(id);
	}

	/**
	 * 对象转部门树
	 *
	 * @param categoryList 部门列表
	 * @return 树结构列表
	 */
	public List<ZtreeExt> initZtree(List<LibraryCategory> categoryList)
	{
		return initZtree(categoryList, null);
	}
	public List<ZtreeExt> initZtree(List<LibraryCategory> cmsCategoryList, List<String> roleDeptList)
	{

		List<ZtreeExt> ztrees = new ArrayList<ZtreeExt>();
		boolean isCheck = StringUtils.isNotNull(roleDeptList);
		for (LibraryCategory cmsCategory : cmsCategoryList)
		{
			if (UserConstants.DEPT_NORMAL.equals(cmsCategory.getDelFlag()))
			{
				ZtreeExt ztree = new ZtreeExt();
				ztree.setId(cmsCategory.getId());
				ztree.setpId(cmsCategory.getPid());
				ztree.setName(cmsCategory.getName());
				ztree.setTitle(cmsCategory.getName());
				if (isCheck)
				{
					ztree.setChecked(roleDeptList.contains(cmsCategory.getId() + cmsCategory.getName()));
				}
				ztrees.add(ztree);
			}
		}
		return ztrees;
	}
}
