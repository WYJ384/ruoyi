package com.ruoyi.web.controller.exam;

import java.util.List;
import java.util.UUID;

import com.ruoyi.exam.domain.LibraryCategory;
import com.ruoyi.exam.domain.LibraryQuestion;
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
import com.ruoyi.exam.domain.Library;
import com.ruoyi.exam.service.ILibraryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 试题库 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
@Controller
@RequestMapping("/exam/library")
public class LibraryController extends BaseController
{
    private String prefix = "exam/library";
	
	@Autowired
	private ILibraryService libraryService;
	
	@RequiresPermissions("exam:library:view")
	@GetMapping()
	public String library()
	{
	    return prefix + "/library";
	}
	
	/**
	 * 查询试题库列表
	 */
	@RequiresPermissions("exam:library:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Library library)
	{
		startPage();
        List<Library> list = libraryService.selectLibraryList(library);
		return getDataTable(list);
	}

	/**
	 * 导出试题库列表
	 */
	@RequiresPermissions("exam:library:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Library library)
    {
    	List<Library> list = libraryService.selectLibraryList(library);
        ExcelUtil<Library> util = new ExcelUtil<Library>(Library.class);
        return util.exportExcel(list, "library");
    }
	
	/**
	 * 新增试题库
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存试题库
	 */
	@RequiresPermissions("exam:library:add")
	@Log(title = "试题库", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Library library)
	{
		library.setId(UUID.randomUUID().toString().replaceAll("-",""));
		return toAjax(libraryService.insertLibrary(library));
	}
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") String id, ModelMap mmap)
	{
		Library library = libraryService.selectLibraryById(id);
		mmap.put("library", library);
		return prefix + "/detail";
	}
	/**
	 * 修改试题库
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Library library = libraryService.selectLibraryById(id);
		mmap.put("library", library);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存试题库
	 */
	@RequiresPermissions("exam:library:edit")
	@Log(title = "试题库", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Library library)
	{		
		return toAjax(libraryService.updateLibrary(library));
	}
	
	/**
	 * 删除试题库
	 */
	@RequiresPermissions("exam:library:remove")
	@Log(title = "试题库", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(libraryService.deleteLibraryByIds(ids));
	}
	
}
