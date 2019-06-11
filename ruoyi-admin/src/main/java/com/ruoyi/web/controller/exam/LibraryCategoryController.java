package com.ruoyi.web.controller.exam;

import java.util.List;
import java.util.UUID;

import com.ruoyi.common.core.domain.ZtreeExt;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.knowledge.domain.CmsCategory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.exam.domain.LibraryCategory;
import com.ruoyi.exam.service.ILibraryCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 题库类型 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
@Controller
@RequestMapping("/exam/libraryCategory")
public class LibraryCategoryController extends BaseController
{
    private String prefix = "exam/libraryCategory";
	
	@Autowired
	private ILibraryCategoryService libraryCategoryService;
	
	@RequiresPermissions("exam:libraryCategory:view")
	@GetMapping()
	public String libraryCategory()
	{
	    return prefix + "/libraryCategory";
	}
	@GetMapping("/treeData")
	@ResponseBody
	public List<ZtreeExt> treeData()
	{
		List<ZtreeExt> ztrees = libraryCategoryService.selectCategoryTree(new LibraryCategory());
		return ztrees;
	}

	/**
	 * 选择菜单树
	 */
	@GetMapping("/selectCategoryTree/{id}")
	public String selectCategoryTree(@PathVariable("id") String id, ModelMap mmap)
	{
		mmap.put("category", libraryCategoryService.selectLibraryCategoryById(id));
		return prefix + "/tree";
	}

	/**
	 * 查询题库类型列表
	 */
	@RequiresPermissions("exam:libraryCategory:list")
	@GetMapping("/list")
	@ResponseBody
	public  List<LibraryCategory> list(LibraryCategory libraryCategory)
	{
//		startPage();
//		libraryCategory.setPid("0");
        List<LibraryCategory> list = libraryCategoryService.selectLibraryCategoryList(libraryCategory);
		return list;
	}
	
	
	/**
	 * 导出题库类型列表
	 */
	@RequiresPermissions("exam:libraryCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LibraryCategory libraryCategory)
    {
    	List<LibraryCategory> list = libraryCategoryService.selectLibraryCategoryList(libraryCategory);
        ExcelUtil<LibraryCategory> util = new ExcelUtil<LibraryCategory>(LibraryCategory.class);
        return util.exportExcel(list, "libraryCategory");
    }
	
	/**
	 * 新增题库类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存题库类型
	 */
	@RequiresPermissions("exam:libraryCategory:add")
	@Log(title = "题库类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(LibraryCategory libraryCategory)
	{
		libraryCategory.setId(UUID.randomUUID().toString().replaceAll("-",""));
		return toAjax(libraryCategoryService.insertLibraryCategory(libraryCategory));
	}
	/**
	 * 新增栏目
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") String parentId, ModelMap mmap){
		LibraryCategory category = null;
		if (!"0".equals(parentId))
		{
			category = libraryCategoryService.selectLibraryCategoryById(parentId);
		}
		else
		{
			category = new LibraryCategory();
			category.setId("0");
			category.setName("顶级分类");
		}
		mmap.put("category", category);
		return prefix + "/add";
	}
	/**
	 * 修改题库类型
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		LibraryCategory libraryCategory = libraryCategoryService.selectLibraryCategoryById(id);
		mmap.put("libraryCategory", libraryCategory);
		LibraryCategory pCategory = libraryCategoryService.selectLibraryCategoryById(libraryCategory.getPid());
		if(pCategory==null){
			pCategory=libraryCategory;
		}
		mmap.put("pCategory", pCategory);
	    return prefix + "/edit";
	}


	/**
	 * 修改保存题库类型
	 */
	@RequiresPermissions("exam:libraryCategory:edit")
	@Log(title = "题库类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(LibraryCategory libraryCategory)
	{		
		return toAjax(libraryCategoryService.updateLibraryCategory(libraryCategory));
	}
	
	/**
	 * 删除题库类型
	 */
//	@RequiresPermissions("exam:libraryCategory:remove")
//	@Log(title = "题库类型", businessType = BusinessType.DELETE)
//	@PostMapping( "/remove")
//	@ResponseBody
//	public AjaxResult remove(String ids)
//	{
//		return toAjax(libraryCategoryService.deleteLibraryCategoryByIds(ids));
//	}
	/**
	 * 删除题库类型
	 */
	@RequiresPermissions("knowledge:cmsCategory:remove")
	@Log(title = "分类", businessType = BusinessType.DELETE)
	@GetMapping("/remove/{id}")
	@ResponseBody
	public AjaxResult remove(@PathVariable("id") String id) {
		if (libraryCategoryService.selectCountCategoryByParentId(id) > 0) {
			return error(1, "存在子分类,不允许删除");
		}
		if (id.equals("1")) {
			return error(1, "顶级分类不可删除");
		}
		ShiroUtils.clearCachedAuthorizationInfo();
		return toAjax(libraryCategoryService.deleteLibraryCategoryByIds(id));
	}
}
