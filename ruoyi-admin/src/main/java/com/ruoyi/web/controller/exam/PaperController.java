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
import com.ruoyi.exam.domain.Paper;
import com.ruoyi.exam.service.IPaperService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 试卷 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-19
 */
@Controller
@RequestMapping("/exam/paper")
public class PaperController extends BaseController
{
    private String prefix = "exam/paper";
	
	@Autowired
	private IPaperService paperService;
	
	@RequiresPermissions("exam:paper:view")
	@GetMapping()
	public String paper()
	{
	    return prefix + "/paper";
	}
	
	/**
	 * 查询试卷列表
	 */
	@RequiresPermissions("exam:paper:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Paper paper)
	{
		startPage();
        List<Paper> list = paperService.selectPaperList(paper);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出试卷列表
	 */
	@RequiresPermissions("exam:paper:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Paper paper)
    {
    	List<Paper> list = paperService.selectPaperList(paper);
        ExcelUtil<Paper> util = new ExcelUtil<Paper>(Paper.class);
        return util.exportExcel(list, "paper");
    }
	
	/**
	 * 新增试卷
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存试卷
	 */
	@RequiresPermissions("exam:paper:add")
	@Log(title = "试卷", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Paper paper)
	{
		paper.setId(UUID.randomUUID().toString().replaceAll("-",""));
		paper.setCreateBy(ShiroUtils.getUserId()+"");
		paper.setCreateDate(new Date());
		return toAjax(paperService.insertPaper(paper));
	}

	/**
	 * 修改试卷
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Paper paper = paperService.selectPaperById(id);
		mmap.put("paper", paper);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存试卷
	 */
	@RequiresPermissions("exam:paper:edit")
	@Log(title = "试卷", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Paper paper)
	{		
		return toAjax(paperService.updatePaper(paper));
	}
	
	/**
	 * 删除试卷
	 */
	@RequiresPermissions("exam:paper:remove")
	@Log(title = "试卷", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(paperService.deletePaperByIds(ids));
	}
	/**
	 * 修改试卷
	 */
	@GetMapping("/chooseLibrary")
	public String chooseLibrary( ModelMap mmap)
	{
		return prefix + "/chooseLibrary";
	}
}
