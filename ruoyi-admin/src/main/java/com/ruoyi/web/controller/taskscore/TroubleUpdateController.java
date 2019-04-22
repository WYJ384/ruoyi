package com.ruoyi.web.controller.taskscore;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.taskscore.domain.TroubleUpdate;
import com.ruoyi.taskscore.service.ITroubleUpdateService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 隐患整改 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/taskscore/troubleUpdate")
public class TroubleUpdateController extends BaseController
{
    private String prefix = "taskscore/troubleUpdate";
    @Autowired
    private ISysUserService userService;
	@Autowired
	private ITroubleUpdateService troubleUpdateService;
	
	@RequiresPermissions("taskscore:troubleUpdate:view")
	@GetMapping()
	public String troubleUpdate()
	{
	    return prefix + "/troubleUpdate";
	}
	
	/**
	 * 查询隐患整改列表
	 */
	@RequiresPermissions("taskscore:troubleUpdate:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TroubleUpdate troubleUpdate)
	{
		startPage();
        List<TroubleUpdate> list = troubleUpdateService.selectTroubleUpdateList(troubleUpdate);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出隐患整改列表
	 */
	@RequiresPermissions("taskscore:troubleUpdate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TroubleUpdate troubleUpdate)
    {
    	List<TroubleUpdate> list = troubleUpdateService.selectTroubleUpdateList(troubleUpdate);
        ExcelUtil<TroubleUpdate> util = new ExcelUtil<TroubleUpdate>(TroubleUpdate.class);
        return util.exportExcel(list, "troubleUpdate");
    }
	
	/**
	 * 新增隐患整改
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
        SysUser sysUser = new SysUser();
        sysUser.setStatus("0");
        mmap.put("users",userService.selectUserList(sysUser));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存隐患整改
	 */
	@RequiresPermissions("taskscore:troubleUpdate:add")
	@Log(title = "隐患整改", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TroubleUpdate troubleUpdate)
	{
		troubleUpdate.setTroId(UUID.randomUUID().toString().replaceAll("-",""));
		return toAjax(troubleUpdateService.insertTroubleUpdate(troubleUpdate));
	}

	/**
	 * 修改隐患整改
	 */
	@GetMapping("/edit/{troId}")
	public String edit(@PathVariable("troId") String troId, ModelMap mmap)
	{
        SysUser sysUser = new SysUser();
        sysUser.setStatus("0");
        mmap.put("users",userService.selectUserList(sysUser));
		TroubleUpdate troubleUpdate = troubleUpdateService.selectTroubleUpdateById(troId);
		mmap.put("troubleUpdate", troubleUpdate);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存隐患整改
	 */
	@RequiresPermissions("taskscore:troubleUpdate:edit")
	@Log(title = "隐患整改", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TroubleUpdate troubleUpdate)
	{		
		return toAjax(troubleUpdateService.updateTroubleUpdate(troubleUpdate));
	}
	
	/**
	 * 删除隐患整改
	 */
	@RequiresPermissions("taskscore:troubleUpdate:remove")
	@Log(title = "隐患整改", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(troubleUpdateService.deleteTroubleUpdateByIds(ids));
	}
	
}
