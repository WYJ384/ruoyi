package com.ruoyi.web.controller.taskscore;

import java.util.Date;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
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
import com.ruoyi.taskscore.domain.PointerType;
import com.ruoyi.taskscore.service.IPointerTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 评分指标类型 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/taskscore/pointerType")
public class PointerTypeController extends BaseController
{
    private String prefix = "taskscore/pointerType";
	
	@Autowired
	private IPointerTypeService pointerTypeService;
	
	@RequiresPermissions("taskscore:pointerType:view")
	@GetMapping()
	public String pointerType()
	{
	    return prefix + "/pointerType";
	}
	
	/**
	 * 查询评分指标类型列表
	 */
	@RequiresPermissions("taskscore:pointerType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PointerType pointerType)
	{
		startPage();
        List<PointerType> list = pointerTypeService.selectPointerTypeList(pointerType);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出评分指标类型列表
	 */
	@RequiresPermissions("taskscore:pointerType:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PointerType pointerType)
    {
    	List<PointerType> list = pointerTypeService.selectPointerTypeList(pointerType);
        ExcelUtil<PointerType> util = new ExcelUtil<PointerType>(PointerType.class);
        return util.exportExcel(list, "pointerType");
    }
	
	/**
	 * 新增评分指标类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存评分指标类型
	 */
	@RequiresPermissions("taskscore:pointerType:add")
	@Log(title = "评分指标类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PointerType pointerType)
	{

		pointerType.setCreateBy(ShiroUtils.getLoginName());
		pointerType.setCreateTime(new Date());
		return toAjax(pointerTypeService.insertPointerType(pointerType));
	}

	/**
	 * 修改评分指标类型
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		PointerType pointerType = pointerTypeService.selectPointerTypeById(id);
		mmap.put("pointerType", pointerType);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存评分指标类型
	 */
	@RequiresPermissions("taskscore:pointerType:edit")
	@Log(title = "评分指标类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PointerType pointerType)
	{
		pointerType.setUpdateBy(ShiroUtils.getLoginName());
		pointerType.setUpdateTime(new Date());
		return toAjax(pointerTypeService.updatePointerType(pointerType));
	}
	
	/**
	 * 删除评分指标类型
	 */
	@RequiresPermissions("taskscore:pointerType:remove")
	@Log(title = "评分指标类型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pointerTypeService.deletePointerTypeByIds(ids));
	}
	
}
