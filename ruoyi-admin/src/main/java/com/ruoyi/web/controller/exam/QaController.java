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
import com.ruoyi.exam.domain.Qa;
import com.ruoyi.exam.service.IQaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 问答题 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
@Controller
@RequestMapping("/exam/qa")
public class QaController extends BaseController
{
    private String prefix = "exam/qa";
	
	@Autowired
	private IQaService qaService;
	
	@RequiresPermissions("exam:qa:view")
	@GetMapping()
	public String qa()
	{
	    return prefix + "/qa";
	}
	
	/**
	 * 查询问答题列表
	 */
	@RequiresPermissions("exam:qa:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Qa qa)
	{
		startPage();
        List<Qa> list = qaService.selectQaList(qa);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出问答题列表
	 */
	@RequiresPermissions("exam:qa:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Qa qa)
    {
    	List<Qa> list = qaService.selectQaList(qa);
        ExcelUtil<Qa> util = new ExcelUtil<Qa>(Qa.class);
        return util.exportExcel(list, "qa");
    }
	
	/**
	 * 新增问答题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存问答题
	 */
	@RequiresPermissions("exam:qa:add")
	@Log(title = "问答题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Qa qa)
	{
		qa.setId(UUID.randomUUID().toString().replaceAll("-",""));
		qa.setCreateBy(ShiroUtils.getUserId()+"");
		qa.setCreateDate(new Date());
		return toAjax(qaService.insertQa(qa));
	}

	/**
	 * 修改问答题
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Qa qa = qaService.selectQaById(id);
		mmap.put("qa", qa);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存问答题
	 */
	@RequiresPermissions("exam:qa:edit")
	@Log(title = "问答题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Qa qa)
	{
		qa.setUpdateBy(ShiroUtils.getUserId()+"");
		qa.setUpdateDate(new Date());
		return toAjax(qaService.updateQa(qa));
	}
	
	/**
	 * 删除问答题
	 */
	@RequiresPermissions("exam:qa:remove")
	@Log(title = "问答题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(qaService.deleteQaByIds(ids));
	}
	
}
