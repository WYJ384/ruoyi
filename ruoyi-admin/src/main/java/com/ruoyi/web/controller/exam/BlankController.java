package com.ruoyi.web.controller.exam;

import java.util.List;
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
import com.ruoyi.exam.domain.Blank;
import com.ruoyi.exam.service.IBlankService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 填空题 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-12
 */
@Controller
@RequestMapping("/exam/blank")
public class BlankController extends BaseController
{
    private String prefix = "exam/blank";
	
	@Autowired
	private IBlankService blankService;
	
	@RequiresPermissions("exam:blank:view")
	@GetMapping()
	public String blank()
	{
	    return prefix + "/blank";
	}
	
	/**
	 * 查询填空题列表
	 */
	@RequiresPermissions("exam:blank:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Blank blank)
	{
		startPage();
        List<Blank> list = blankService.selectBlankList(blank);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出填空题列表
	 */
	@RequiresPermissions("exam:blank:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Blank blank)
    {
    	List<Blank> list = blankService.selectBlankList(blank);
        ExcelUtil<Blank> util = new ExcelUtil<Blank>(Blank.class);
        return util.exportExcel(list, "blank");
    }
	
	/**
	 * 新增填空题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存填空题
	 */
	@RequiresPermissions("exam:blank:add")
	@Log(title = "填空题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Blank blank)
	{		
		return toAjax(blankService.insertBlank(blank));
	}

	/**
	 * 修改填空题
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Blank blank = blankService.selectBlankById(id);
		mmap.put("blank", blank);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存填空题
	 */
	@RequiresPermissions("exam:blank:edit")
	@Log(title = "填空题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Blank blank)
	{		
		return toAjax(blankService.updateBlank(blank));
	}
	
	/**
	 * 删除填空题
	 */
	@RequiresPermissions("exam:blank:remove")
	@Log(title = "填空题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(blankService.deleteBlankByIds(ids));
	}
	
}
