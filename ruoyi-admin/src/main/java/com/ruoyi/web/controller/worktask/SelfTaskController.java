package com.ruoyi.web.controller.worktask;

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
import com.ruoyi.worktask.domain.SelfTask;
import com.ruoyi.worktask.service.ISelfTaskService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 任务 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-08
 */
@Controller
@RequestMapping("/worktask/selfTask")
public class SelfTaskController extends BaseController
{
    private String prefix = "worktask/selfTask";
	
	@Autowired
	private ISelfTaskService selfTaskService;
	
	@RequiresPermissions("worktask:selfTask:view")
	@GetMapping()
	public String selfTask()
	{
	    return prefix + "/selfTask";
	}
	
	/**
	 * 查询任务列表
	 */
	@RequiresPermissions("worktask:selfTask:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SelfTask selfTask)
	{
		startPage();
        List<SelfTask> list = selfTaskService.selectSelfTaskList(selfTask);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出任务列表
	 */
	@RequiresPermissions("worktask:selfTask:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SelfTask selfTask)
    {
    	List<SelfTask> list = selfTaskService.selectSelfTaskList(selfTask);
        ExcelUtil<SelfTask> util = new ExcelUtil<SelfTask>(SelfTask.class);
        return util.exportExcel(list, "selfTask");
    }
	
	/**
	 * 新增任务
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存任务
	 */
	@RequiresPermissions("worktask:selfTask:add")
	@Log(title = "任务", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SelfTask selfTask)
	{		
		return toAjax(selfTaskService.insertSelfTask(selfTask));
	}

	/**
	 * 修改任务
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		SelfTask selfTask = selfTaskService.selectSelfTaskById(id);
		mmap.put("selfTask", selfTask);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存任务
	 */
	@RequiresPermissions("worktask:selfTask:edit")
	@Log(title = "任务", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SelfTask selfTask)
	{		
		return toAjax(selfTaskService.updateSelfTask(selfTask));
	}
	
	/**
	 * 删除任务
	 */
	@RequiresPermissions("worktask:selfTask:remove")
	@Log(title = "任务", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(selfTaskService.deleteSelfTaskByIds(ids));
	}
	
}
