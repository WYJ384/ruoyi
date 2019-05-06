package com.ruoyi.knowledge.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.ZtreeExt;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.CmsCategoryMapper;
import com.ruoyi.knowledge.domain.CmsCategory;
import com.ruoyi.knowledge.service.ICmsCategoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 栏目 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-05
 */
@Service
public class CmsCategoryServiceImpl implements ICmsCategoryService 
{
	@Autowired
	private CmsCategoryMapper cmsCategoryMapper;

	/**
     * 查询栏目信息
     * 
     * @param id 栏目ID
     * @return 栏目信息
     */
    @Override
	public CmsCategory selectCmsCategoryById(String id)
	{
	    return cmsCategoryMapper.selectCmsCategoryById(id);
	}
	
	/**
     * 查询栏目列表
     * 
     * @param cmsCategory 栏目信息
     * @return 栏目集合
     */
	@Override
	public List<CmsCategory> selectCmsCategoryList(CmsCategory cmsCategory)
	{
	    return cmsCategoryMapper.selectCmsCategoryList(cmsCategory);
	}
	
    /**
     * 新增栏目
     * 
     * @param cmsCategory 栏目信息
     * @return 结果
     */
	@Override
	public int insertCmsCategory(CmsCategory cmsCategory)
	{
		CmsCategory info = cmsCategoryMapper.selectCmsCategoryById(cmsCategory.getParentId());
		if(info!=null){
			cmsCategory.setParentIds(info.getParentIds() + "," + cmsCategory.getParentId());
		}else{
			cmsCategory.setParentIds("0," + cmsCategory.getParentId());
		}

	    return cmsCategoryMapper.insertCmsCategory(cmsCategory);
	}
	
	/**
     * 修改栏目
     * 
     * @param cmsCategory 栏目信息
     * @return 结果
     */
	@Override
	public int updateCmsCategory(CmsCategory cmsCategory)
	{
	    return cmsCategoryMapper.updateCmsCategory(cmsCategory);
	}

	/**
     * 删除栏目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCmsCategoryByIds(String ids)
	{
		return cmsCategoryMapper.deleteCmsCategoryByIds(Convert.toStrArray(ids));
	}

	@Override
	public int selectCountCategoryByParentId(String id) {
		return cmsCategoryMapper.selectCountCategoryByParentId(id);
	}

	@Override
	public List<ZtreeExt> selectCategoryTree(CmsCategory cmsCategory) {
		List<CmsCategory> deptList = cmsCategoryMapper.selectCmsCategoryList(cmsCategory);
		List<ZtreeExt> ztrees = initZtree(deptList);
		return ztrees;
	}
	/**
	 * 对象转部门树
	 *
	 * @param cmsCategoryList 部门列表
	 * @return 树结构列表
	 */
	public List<ZtreeExt> initZtree(List<CmsCategory> cmsCategoryList)
	{
		return initZtree(cmsCategoryList, null);
	}
	public List<ZtreeExt> initZtree(List<CmsCategory> cmsCategoryList, List<String> roleDeptList)
	{

		List<ZtreeExt> ztrees = new ArrayList<ZtreeExt>();
		boolean isCheck = StringUtils.isNotNull(roleDeptList);
		for (CmsCategory cmsCategory : cmsCategoryList)
		{
			if (UserConstants.DEPT_NORMAL.equals(cmsCategory.getDelFlag()))
			{
				ZtreeExt ztree = new ZtreeExt();
				ztree.setId(cmsCategory.getId());
				ztree.setpId(cmsCategory.getParentId());
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
