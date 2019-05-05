package com.ruoyi.web.controller.knowledge;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.ZtreeExt;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysMenu;
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
import com.ruoyi.knowledge.domain.CmsCategory;
import com.ruoyi.knowledge.service.ICmsCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 栏目 信息操作处理
 *
 * @author ruoyi
 * @date 2019-05-05
 */
@Controller
@RequestMapping("/knowledge/cmsCategory")
public class CmsCategoryController extends BaseController {
    private String prefix = "knowledge/cmsCategory";

    @Autowired
    private ICmsCategoryService cmsCategoryService;

    @RequiresPermissions("knowledge:cmsCategory:view")
    @GetMapping()
    public String cmsCategory() {
        return prefix + "/cmsCategory";
    }

    @GetMapping("/treeData")
    @ResponseBody
    public List<ZtreeExt> treeData()
    {
        List<ZtreeExt> ztrees = cmsCategoryService.selectCategoryTree(new CmsCategory());
        return ztrees;
    }


    /**
     * 选择菜单树
     */
    @GetMapping("/selectCategoryTree/{id}")
    public String selectCategoryTree(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("cmsCategory", cmsCategoryService.selectCmsCategoryById(id));
        return prefix + "/tree";
    }


    /**
     * 查询栏目列表
     */
    @RequiresPermissions("knowledge:cmsCategory:list")
    @GetMapping("/list")
    @ResponseBody
    public List<CmsCategory> list(CmsCategory cmsCategory) {
        cmsCategory.setDelFlag("0");
//		startPage();
        List<CmsCategory> list = cmsCategoryService.selectCmsCategoryList(cmsCategory);
        return list;
    }


    /**
     * 导出栏目列表
     */
    @RequiresPermissions("knowledge:cmsCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsCategory cmsCategory) {
        cmsCategory.setDelFlag("0");
        List<CmsCategory> list = cmsCategoryService.selectCmsCategoryList(cmsCategory);
        ExcelUtil<CmsCategory> util = new ExcelUtil<CmsCategory>(CmsCategory.class);
        return util.exportExcel(list, "cmsCategory");
    }

    /**
     * 新增栏目
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") String parentId, ModelMap mmap){
        CmsCategory cmsCategory = null;
        if (!"0".equals(parentId))
        {
            cmsCategory = cmsCategoryService.selectCmsCategoryById(parentId);
        }
        else
        {
            cmsCategory = new CmsCategory();
            cmsCategory.setId("0");
            cmsCategory.setName("顶级分类");
        }
        mmap.put("cmsCategory", cmsCategory);
        return prefix + "/add";
    }

    /**
     * 新增保存栏目
     */
    @RequiresPermissions("knowledge:cmsCategory:add")
    @Log(title = "栏目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsCategory cmsCategory) {

        cmsCategory.setId(UUID.randomUUID().toString().replaceAll("-",""));
        cmsCategory.setDelFlag("0");
        cmsCategory.setCreateBy(ShiroUtils.getLoginName());
        cmsCategory.setCreateDate(new Date());
        return toAjax(cmsCategoryService.insertCmsCategory(cmsCategory));
    }

    /**
     * 修改栏目
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        CmsCategory cmsCategory = cmsCategoryService.selectCmsCategoryById(id);
        mmap.put("cmsCategory", cmsCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存栏目
     */
    @RequiresPermissions("knowledge:cmsCategory:edit")
    @Log(title = "栏目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsCategory cmsCategory) {
        cmsCategory.setUpdateBy(ShiroUtils.getLoginName());
        cmsCategory.setUpdateDate(new Date());
        return toAjax(cmsCategoryService.updateCmsCategory(cmsCategory));
    }

    /**
     * 删除栏目
     */
    @RequiresPermissions("knowledge:cmsCategory:remove")
    @Log(title = "分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") String id) {
        if (cmsCategoryService.selectCountCategoryByParentId(id) > 0) {
            return error(1, "存在子分类,不允许删除");
        }

        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(cmsCategoryService.deleteCmsCategoryByIds(id));
    }
    /**
     * 删除栏目
     */
//	@Log(title = "删除栏目", businessType = BusinessType.DELETE)
//	@RequiresPermissions("knowledge:cmsCategory:remove")
//	@GetMapping("/remove/{id}")
//	@ResponseBody
//	public AjaxResult remove(@PathVariable("id") String id)
//	{
////		if (cmsCategoryService.selectCountMenuByParentId(menuId) > 0)
////		{
////			return error(1, "存在子菜单,不允许删除");
////		}
////		if (menuService.selectCountRoleMenuByMenuId(menuId) > 0)
////		{
////			return error(1, "菜单已分配,不允许删除");
////		}
//		ShiroUtils.clearCachedAuthorizationInfo();
//		return toAjax(cmsCategoryService.deleteCmsCategoryByIds(id));
//	}
}
