package com.ruoyi.web.controller.worktask;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
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
import com.ruoyi.worktask.domain.WorkTaskActivity;
import com.ruoyi.worktask.service.IWorkTaskActivityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 专项工作汇报内容 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-26
 */
@Controller
@RequestMapping("/worktask/workTaskActivity")
public class WorkTaskActivityController extends BaseController
{
    private String prefix = "worktask/workTaskActivity";
	
	@Autowired
	private IWorkTaskActivityService workTaskActivityService;
	@Autowired
	private IWorkTaskFileService workTaskFileService;
	@RequiresPermissions("worktask:workTaskActivity:view")
	@GetMapping()
	public String workTaskActivity()
	{
	    return prefix + "/workTaskActivity";
	}
	
	/**
	 * 查询专项工作汇报内容列表
	 */
	@RequiresPermissions("worktask:workTaskActivity:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WorkTaskActivity workTaskActivity)
	{
		startPage();
        List<WorkTaskActivity> list = workTaskActivityService.selectWorkTaskActivityList(workTaskActivity);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出专项工作汇报内容列表
	 */
	@RequiresPermissions("worktask:workTaskActivity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkTaskActivity workTaskActivity)
    {
    	List<WorkTaskActivity> list = workTaskActivityService.selectWorkTaskActivityList(workTaskActivity);
        ExcelUtil<WorkTaskActivity> util = new ExcelUtil<WorkTaskActivity>(WorkTaskActivity.class);
        return util.exportExcel(list, "workTaskActivity");
    }
	
	/**
	 * 新增专项工作汇报内容
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存专项工作汇报内容
	 */
	@RequiresPermissions("worktask:workTaskActivity:add")
	@Log(title = "专项工作汇报内容", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WorkTaskActivity workTaskActivity)
	{
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//		if(!file.isEmpty()){
//			workTaskFileService.insertWorkTaskFile(file,ShiroUtils.getLoginName(),uuid);
//		}
		workTaskActivity.setId(uuid);
		workTaskActivity.setCreateBy(ShiroUtils.getLoginName());
		workTaskActivity.setCreateTime(new Date());
		return toAjax(workTaskActivityService.insertWorkTaskActivity(workTaskActivity));
	}

	/**
	 * 修改专项工作汇报内容
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		WorkTaskActivity workTaskActivity = workTaskActivityService.selectWorkTaskActivityById(id);
		mmap.put("workTaskActivity", workTaskActivity);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存专项工作汇报内容
	 */
	@RequiresPermissions("worktask:workTaskActivity:edit")
	@Log(title = "专项工作汇报内容", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WorkTaskActivity workTaskActivity)
	{		
		return toAjax(workTaskActivityService.updateWorkTaskActivity(workTaskActivity));
	}
	
	/**
	 * 删除专项工作汇报内容
	 */
	@RequiresPermissions("worktask:workTaskActivity:remove")
	@Log(title = "专项工作汇报内容", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(workTaskActivityService.deleteWorkTaskActivityByIds(ids));
	}
	
}
