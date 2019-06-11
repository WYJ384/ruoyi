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
import com.ruoyi.exam.domain.SingleChoice;
import com.ruoyi.exam.service.ISingleChoiceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 单选题 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
@Controller
@RequestMapping("/exam/singleChoice")
public class SingleChoiceController extends BaseController
{
    private String prefix = "exam/singleChoice";
	
	@Autowired
	private ISingleChoiceService singleChoiceService;
	
	@RequiresPermissions("exam:singleChoice:view")
	@GetMapping()
	public String singleChoice()
	{
	    return prefix + "/singleChoice";
	}
	
	/**
	 * 查询单选题列表
	 */
	@RequiresPermissions("exam:singleChoice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SingleChoice singleChoice)
	{
		startPage();
        List<SingleChoice> list = singleChoiceService.selectSingleChoiceList(singleChoice);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出单选题列表
	 */
	@RequiresPermissions("exam:singleChoice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SingleChoice singleChoice)
    {
    	List<SingleChoice> list = singleChoiceService.selectSingleChoiceList(singleChoice);
        ExcelUtil<SingleChoice> util = new ExcelUtil<SingleChoice>(SingleChoice.class);
        return util.exportExcel(list, "singleChoice");
    }
	
	/**
	 * 新增单选题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存单选题
	 */
	@RequiresPermissions("exam:singleChoice:add")
	@Log(title = "单选题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SingleChoice singleChoice)
	{
		singleChoice.setId(UUID.randomUUID().toString().replaceAll("-",""));
		singleChoice.setCreateBy(ShiroUtils.getUserId()+"");
		singleChoice.setCreateDate(new Date());
		return toAjax(singleChoiceService.insertSingleChoice(singleChoice));
	}

	/**
	 * 修改单选题
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		SingleChoice singleChoice = singleChoiceService.selectSingleChoiceById(id);
		mmap.put("singleChoice", singleChoice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存单选题
	 */
	@RequiresPermissions("exam:singleChoice:edit")
	@Log(title = "单选题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SingleChoice singleChoice)
	{
		singleChoice.setUpdateBy(ShiroUtils.getUserId()+"");
		singleChoice.setUpdateDate(new Date());
		return toAjax(singleChoiceService.updateSingleChoice(singleChoice));
	}
	
	/**
	 * 删除单选题
	 */
	@RequiresPermissions("exam:singleChoice:remove")
	@Log(title = "单选题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(singleChoiceService.deleteSingleChoiceByIds(ids));
	}
	
}
