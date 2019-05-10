package com.ruoyi.web.controller.worktask;

import java.util.Date;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.worktask.domain.SelfTask;
import com.ruoyi.worktask.service.ISelfTaskService;
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
import com.ruoyi.worktask.domain.SelfTaskProcess;
import com.ruoyi.worktask.service.ISelfTaskProcessService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 任务进度 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-09
 */
@Controller
@RequestMapping("/worktask/selfTaskProcess")
public class SelfTaskProcessController extends BaseController
{
    private String prefix = "worktask/selfTaskProcess";
	@Autowired
	private ISelfTaskService selfTaskService;
	@Autowired
	private ISelfTaskProcessService selfTaskProcessService;
	
	@RequiresPermissions("worktask:selfTaskProcess:view")
	@GetMapping()
	public String selfTaskProcess()
	{
	    return prefix + "/selfTaskProcess";
	}
	
	/**
	 * 查询任务进度列表
	 */
	@RequiresPermissions("worktask:selfTaskProcess:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SelfTaskProcess selfTaskProcess)
	{
		startPage();
        List<SelfTaskProcess> list = selfTaskProcessService.selectSelfTaskProcessList(selfTaskProcess);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出任务进度列表
	 */
	@RequiresPermissions("worktask:selfTaskProcess:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SelfTaskProcess selfTaskProcess)
    {
    	List<SelfTaskProcess> list = selfTaskProcessService.selectSelfTaskProcessList(selfTaskProcess);
        ExcelUtil<SelfTaskProcess> util = new ExcelUtil<SelfTaskProcess>(SelfTaskProcess.class);
        return util.exportExcel(list, "selfTaskProcess");
    }
	
	/**
	 * 新增任务进度
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存任务进度
	 */
	@Log(title = "任务进度", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SelfTaskProcess selfTaskProcess)
	{
		SelfTask selfTask = selfTaskService.selectSelfTaskById(selfTaskProcess.getId());
		selfTask.setTaskProgress(selfTaskProcess.getPercentAge());
		if(selfTaskProcess.getPercentAge().equals("100")){
			selfTask.setTaskStatus("1");
		}
		selfTaskService.updateSelfTask(selfTask);
		selfTaskProcess.setCreateBy(ShiroUtils.getSysUser().getUserName());
		selfTaskProcess.setCreateTime(new Date());
		selfTaskProcess.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(selfTaskProcessService.insertSelfTaskProcess(selfTaskProcess));
	}

	/**
	 * 修改任务进度
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		SelfTaskProcess selfTaskProcess = selfTaskProcessService.selectSelfTaskProcessById(id);
		mmap.put("selfTaskProcess", selfTaskProcess);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存任务进度
	 */
	@RequiresPermissions("worktask:selfTaskProcess:edit")
	@Log(title = "任务进度", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SelfTaskProcess selfTaskProcess)
	{		
		return toAjax(selfTaskProcessService.updateSelfTaskProcess(selfTaskProcess));
	}
	
	/**
	 * 删除任务进度
	 */
	@RequiresPermissions("worktask:selfTaskProcess:remove")
	@Log(title = "任务进度", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(selfTaskProcessService.deleteSelfTaskProcessByIds(ids));
	}
	
}
