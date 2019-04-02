package com.ruoyi.web.controller.taskscore;

import java.util.Date;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.taskscore.domain.PointerType;
import com.ruoyi.taskscore.service.IPointerTypeService;
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
import com.ruoyi.taskscore.domain.ScoringPointer;
import com.ruoyi.taskscore.service.IScoringPointerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 评分 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/taskscore/scoringPointer")
public class ScoringPointerController extends BaseController
{
    private String prefix = "taskscore/scoringPointer";
	
	@Autowired
	private IScoringPointerService scoringPointerService;

	@Autowired
	private IPointerTypeService pointerTypeService;
	@RequiresPermissions("taskscore:scoringPointer:view")
	@GetMapping()
	public String scoringPointer()
	{
	    return prefix + "/scoringPointer";
	}
	
	/**
	 * 查询评分列表
	 */
	@RequiresPermissions("taskscore:scoringPointer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ScoringPointer scoringPointer)
	{
		startPage();
        List<ScoringPointer> list = scoringPointerService.selectScoringPointerList(scoringPointer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出评分列表
	 */
	@RequiresPermissions("taskscore:scoringPointer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScoringPointer scoringPointer)
    {
    	List<ScoringPointer> list = scoringPointerService.selectScoringPointerList(scoringPointer);
        ExcelUtil<ScoringPointer> util = new ExcelUtil<ScoringPointer>(ScoringPointer.class);
        return util.exportExcel(list, "scoringPointer");
    }
	
	/**
	 * 新增评分
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		List<PointerType> pointerTypes = pointerTypeService.selectPointerTypeList(new PointerType());
		mmap.put("pointerTypes", pointerTypes);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存评分
	 */
	@RequiresPermissions("taskscore:scoringPointer:add")
	@Log(title = "评分", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ScoringPointer scoringPointer)
	{
		scoringPointer.setCreateBy(ShiroUtils.getLoginName());
		scoringPointer.setCreateTime(new Date());
		return toAjax(scoringPointerService.insertScoringPointer(scoringPointer));
	}

	/**
	 * 修改评分
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ScoringPointer scoringPointer = scoringPointerService.selectScoringPointerById(id);
		mmap.put("scoringPointer", scoringPointer);

		List<PointerType> pointerTypes = pointerTypeService.selectPointerTypeList(new PointerType());
		mmap.put("pointerTypes", pointerTypes);
		return prefix + "/edit";
	}
	
	/**
	 * 修改保存评分
	 */
	@RequiresPermissions("taskscore:scoringPointer:edit")
	@Log(title = "评分", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ScoringPointer scoringPointer)
	{
		scoringPointer.setUpdateBy(ShiroUtils.getLoginName());
		scoringPointer.setUpdateTime(new Date());
		return toAjax(scoringPointerService.updateScoringPointer(scoringPointer));
	}
	
	/**
	 * 删除评分
	 */
	@RequiresPermissions("taskscore:scoringPointer:remove")
	@Log(title = "评分", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(scoringPointerService.deleteScoringPointerByIds(ids));
	}
	
}
