package com.ruoyi.knowledge.service;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.ZtreeExt;
import com.ruoyi.knowledge.domain.CmsCategory;
import java.util.List;

/**
 * 栏目 服务层
 * 
 * @author ruoyi
 * @date 2019-05-05
 */
public interface ICmsCategoryService 
{
	/**
     * 查询栏目信息
     * 
     * @param id 栏目ID
     * @return 栏目信息
     */
	public CmsCategory selectCmsCategoryById(String id);
	
	/**
     * 查询栏目列表
     * 
     * @param cmsCategory 栏目信息
     * @return 栏目集合
     */
	public List<CmsCategory> selectCmsCategoryList(CmsCategory cmsCategory);
	
	/**
     * 新增栏目
     * 
     * @param cmsCategory 栏目信息
     * @return 结果
     */
	public int insertCmsCategory(CmsCategory cmsCategory);
	
	/**
     * 修改栏目
     * 
     * @param cmsCategory 栏目信息
     * @return 结果
     */
	public int updateCmsCategory(CmsCategory cmsCategory);
		
	/**
     * 删除栏目信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCmsCategoryByIds(String ids);

	int selectCountCategoryByParentId(String id);

    List<ZtreeExt> selectCategoryTree(CmsCategory cmsCategory);

	CmsCategory selectCategoryByName(CmsCategory cmsCategory);
}
