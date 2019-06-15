package com.ruoyi.web.controller.exam;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import com.ruoyi.exam.domain.MultChoice;
import com.ruoyi.exam.service.IMultChoiceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 多选题 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-14
 */
@Controller
@RequestMapping("/exam/multChoice")
public class MultChoiceController extends BaseController
{
    private String prefix = "exam/multChoice";
	
	@Autowired
	private IMultChoiceService multChoiceService;
	
	@RequiresPermissions("exam:multChoice:view")
	@GetMapping()
	public String multChoice()
	{
	    return prefix + "/multChoice";
	}
	
	/**
	 * 查询多选题列表
	 */
	@RequiresPermissions("exam:multChoice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MultChoice multChoice)
	{
		startPage();
        List<MultChoice> list = multChoiceService.selectMultChoiceList(multChoice);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出多选题列表
	 */
	@RequiresPermissions("exam:multChoice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MultChoice multChoice)
    {
    	List<MultChoice> list = multChoiceService.selectMultChoiceList(multChoice);
        ExcelUtil<MultChoice> util = new ExcelUtil<MultChoice>(MultChoice.class);
        return util.exportExcel(list, "multChoice");
    }
	
	/**
	 * 新增多选题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存多选题
	 */
	@RequiresPermissions("exam:multChoice:add")
	@Log(title = "多选题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MultChoice multChoice)
	{
		multChoice.setId(UUID.randomUUID().toString().replaceAll("-",""));
		multChoice.setCreateBy(ShiroUtils.getUserId()+"");
		multChoice.setCreateDate(new Date());
		return toAjax(multChoiceService.insertMultChoice(multChoice));
	}

	/**
	 * 修改多选题
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		MultChoice multChoice = multChoiceService.selectMultChoiceById(id);
		mmap.put("multChoice", multChoice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存多选题
	 */
	@RequiresPermissions("exam:multChoice:edit")
	@Log(title = "多选题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MultChoice multChoice)
	{		
		return toAjax(multChoiceService.updateMultChoice(multChoice));
	}
	
	/**
	 * 删除多选题
	 */
	@RequiresPermissions("exam:multChoice:remove")
	@Log(title = "多选题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(multChoiceService.deleteMultChoiceByIds(ids));
	}
	
}
