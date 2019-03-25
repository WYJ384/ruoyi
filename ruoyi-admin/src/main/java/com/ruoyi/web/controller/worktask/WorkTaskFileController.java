package com.ruoyi.web.controller.worktask;

import java.util.List;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.file.FileUtils;
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
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

import javax.servlet.http.HttpServletResponse;

/**
 * 附件 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-25
 */
@Controller
@RequestMapping("/worktask/workTaskFile")
public class WorkTaskFileController extends BaseController
{
    private String prefix = "worktask/workTaskFile";
	
	@Autowired
	private IWorkTaskFileService workTaskFileService;
	
	@RequiresPermissions("worktask:workTaskFile:view")
	@GetMapping()
	public String workTaskFile()
	{
	    return prefix + "/workTaskFile";
	}
	
	/**
	 * 查询附件列表
	 */
	@RequiresPermissions("worktask:workTaskFile:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WorkTaskFile workTaskFile)
	{
		startPage();
        List<WorkTaskFile> list = workTaskFileService.selectWorkTaskFileList(workTaskFile);
		return getDataTable(list);
	}
	@GetMapping("/downloadFile/{id}")
	public void downloadFile(@PathVariable("id") Integer id, HttpServletResponse response) throws Exception
	{
		WorkTaskFile sysFile = workTaskFileService.selectWorkTaskFileById(id);
		String filePath = sysFile.getFilePath();
		String path = Global.getUploadPath() + filePath;
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + sysFile.getFilePath());
		FileUtils.writeBytes(path, response.getOutputStream());
	}
	
	/**
	 * 导出附件列表
	 */
	@RequiresPermissions("worktask:workTaskFile:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkTaskFile workTaskFile)
    {
    	List<WorkTaskFile> list = workTaskFileService.selectWorkTaskFileList(workTaskFile);
        ExcelUtil<WorkTaskFile> util = new ExcelUtil<WorkTaskFile>(WorkTaskFile.class);
        return util.exportExcel(list, "workTaskFile");
    }
	
	/**
	 * 新增附件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存附件
	 */
	@RequiresPermissions("worktask:workTaskFile:add")
	@Log(title = "附件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WorkTaskFile workTaskFile)
	{		
		return toAjax(workTaskFileService.insertWorkTaskFile(workTaskFile));
	}

	/**
	 * 修改附件
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		WorkTaskFile workTaskFile = workTaskFileService.selectWorkTaskFileById(id);
		mmap.put("workTaskFile", workTaskFile);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存附件
	 */
	@RequiresPermissions("worktask:workTaskFile:edit")
	@Log(title = "附件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WorkTaskFile workTaskFile)
	{		
		return toAjax(workTaskFileService.updateWorkTaskFile(workTaskFile));
	}
	
	/**
	 * 删除附件
	 */
	@RequiresPermissions("worktask:workTaskFile:remove")
	@Log(title = "附件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(workTaskFileService.deleteWorkTaskFileByIds(ids));
	}
	
}
