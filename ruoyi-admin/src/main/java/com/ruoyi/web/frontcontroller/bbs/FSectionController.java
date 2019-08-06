package com.ruoyi.web.frontcontroller.bbs;

import java.util.List;

import com.ruoyi.web.frontcontroller.FBaseController;
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
import com.ruoyi.bbs.domain.Section;
import com.ruoyi.bbs.service.ISectionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 板块 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-05
 */
@Controller
@RequestMapping("/f/bbs/section")
public class FSectionController extends FBaseController
{
    private String prefix = "bbs/section";
	
	@Autowired
	private ISectionService sectionService;
	
	@RequiresPermissions("bbs:section:view")
	@GetMapping()
	public String section()
	{
	    return prefix + "/section";
	}
	
	/**
	 * 查询板块列表
	 */
	@RequiresPermissions("bbs:section:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Section section)
	{
		startPage();
        List<Section> list = sectionService.selectSectionList(section);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出板块列表
	 */
	@RequiresPermissions("bbs:section:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Section section)
    {
    	List<Section> list = sectionService.selectSectionList(section);
        ExcelUtil<Section> util = new ExcelUtil<Section>(Section.class);
        return util.exportExcel(list, "section");
    }
	
	/**
	 * 新增板块
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存板块
	 */
	@RequiresPermissions("bbs:section:add")
	@Log(title = "板块", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Section section)
	{		
		return toAjax(sectionService.insertSection(section));
	}

	/**
	 * 修改板块
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Section section = sectionService.selectSectionById(id);
		mmap.put("section", section);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存板块
	 */
	@RequiresPermissions("bbs:section:edit")
	@Log(title = "板块", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Section section)
	{		
		return toAjax(sectionService.updateSection(section));
	}
	
	/**
	 * 删除板块
	 */
	@RequiresPermissions("bbs:section:remove")
	@Log(title = "板块", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(sectionService.deleteSectionByIds(ids));
	}
	
}
