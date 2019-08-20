package com.ruoyi.web.controller.exam;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.exam.domain.Library;
import com.ruoyi.exam.service.ILibraryService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
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
import com.ruoyi.exam.domain.LibraryDetail;
import com.ruoyi.exam.service.ILibraryDetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 题库内容 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-17
 */
@Controller
@RequestMapping("/exam/libraryDetail")
public class LibraryDetailController extends BaseController
{
    private String prefix = "exam/libraryDetail";
	@Autowired
	private ILibraryService libraryService;
	@Autowired
	private ILibraryDetailService libraryDetailService;
	
	@RequiresPermissions("exam:libraryDetail:view")
	@GetMapping("/libraryDetail/{libId}")
	public String libraryDetail(@PathVariable("libId") String libId, ModelMap mmap)
	{
		Library library = libraryService.selectLibraryById(libId);
		mmap.addAttribute("library",library);
	    return prefix + "/libraryDetail";
	}
	
	/**
	 * 查询题库内容列表
	 */
	@RequiresPermissions("exam:libraryDetail:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(LibraryDetail libraryDetail)
	{
		startPage();
		libraryDetail.setCreateBy(ShiroUtils.getUserId()+"");
        List<LibraryDetail> list = libraryDetailService.selectLibraryDetailList(libraryDetail);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出题库内容列表
	 */
	@RequiresPermissions("exam:libraryDetail:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LibraryDetail libraryDetail)
    {
    	List<LibraryDetail> list = libraryDetailService.selectLibraryDetailList(libraryDetail);
        ExcelUtil<LibraryDetail> util = new ExcelUtil<LibraryDetail>(LibraryDetail.class);
        return util.exportExcel(list, "libraryDetail");
    }
	
	/**
	 * 新增题库内容
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	/**
	 * 新增试题库
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") String id, ModelMap mmap) {
		Library library = libraryService.selectLibraryById(id);
		mmap.addAttribute("library", library);
		return prefix + "/add";
	}


	/**
	 * 新增保存题库内容
	 */
	@RequiresPermissions("exam:libraryDetail:add")
	@Log(title = "题库内容", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(LibraryDetail libraryDetail)
	{
		libraryDetail.setId(UUID.randomUUID().toString().replaceAll("-",""));
		libraryDetail.setCreateBy(ShiroUtils.getUserId()+"");
		libraryDetail.setCreateDate(new Date());
		return toAjax(libraryDetailService.insertLibraryDetail(libraryDetail));
	}

	/**
	 * 修改题库内容
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		LibraryDetail libraryDetail = libraryDetailService.selectLibraryDetailById(id);
		mmap.put("libraryDetail", libraryDetail);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存题库内容
	 */
	@RequiresPermissions("exam:libraryDetail:edit")
	@Log(title = "题库内容", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(LibraryDetail libraryDetail)
	{
		libraryDetail.setUpdateBy(ShiroUtils.getUserId()+"");
		libraryDetail.setUpdateDate(new Date());
		return toAjax(libraryDetailService.updateLibraryDetail(libraryDetail));
	}

    @Log(title = "题库导入", businessType = BusinessType.IMPORT)
    @RequiresPermissions("exam:libraryDetail:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file,String libId) throws Exception
    {
        ExcelUtil<LibraryDetail> util = new ExcelUtil<LibraryDetail>(LibraryDetail.class);
        List<LibraryDetail> libraryDetails = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getUserId()+"";
        String message = libraryDetailService.importLibraryDetail(libraryDetails, libId, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("exam:libraryDetail:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<LibraryDetail> util = new ExcelUtil<LibraryDetail>(LibraryDetail.class);
        return util.importTemplateExcel("题库数据");
    }
	
	/**
	 * 删除题库内容
	 */
	@RequiresPermissions("exam:libraryDetail:remove")
	@Log(title = "题库内容", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(libraryDetailService.deleteLibraryDetailByIds(ids));
	}
	
}
