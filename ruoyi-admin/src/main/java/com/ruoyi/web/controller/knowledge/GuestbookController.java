package com.ruoyi.web.controller.knowledge;

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
import com.ruoyi.knowledge.domain.Guestbook;
import com.ruoyi.knowledge.service.IGuestbookService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 留言板 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-07-02
 */
@Controller
@RequestMapping("/knowledge/guestbook")
public class GuestbookController extends BaseController
{
    private String prefix = "knowledge/guestbook";
	
	@Autowired
	private IGuestbookService guestbookService;
	
	@RequiresPermissions("knowledge:guestbook:view")
	@GetMapping()
	public String guestbook()
	{
	    return prefix + "/guestbook";
	}
	
	/**
	 * 查询留言板列表
	 */
	@RequiresPermissions("knowledge:guestbook:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Guestbook guestbook)
	{
		startPage();
        List<Guestbook> list = guestbookService.selectGuestbookList(guestbook);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出留言板列表
	 */
	@RequiresPermissions("knowledge:guestbook:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Guestbook guestbook)
    {
    	List<Guestbook> list = guestbookService.selectGuestbookList(guestbook);
        ExcelUtil<Guestbook> util = new ExcelUtil<Guestbook>(Guestbook.class);
        return util.exportExcel(list, "guestbook");
    }
	
	/**
	 * 新增留言板
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存留言板
	 */
	@RequiresPermissions("knowledge:guestbook:add")
	@Log(title = "留言板", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Guestbook guestbook)
	{		
		return toAjax(guestbookService.insertGuestbook(guestbook));
	}

	/**
	 * 修改留言板
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Guestbook guestbook = guestbookService.selectGuestbookById(id);
		mmap.put("guestbook", guestbook);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存留言板
	 */
	@RequiresPermissions("knowledge:guestbook:edit")
	@Log(title = "留言板", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Guestbook guestbook)
	{		
		return toAjax(guestbookService.updateGuestbook(guestbook));
	}
	
	/**
	 * 删除留言板
	 */
	@RequiresPermissions("knowledge:guestbook:remove")
	@Log(title = "留言板", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(guestbookService.deleteGuestbookByIds(ids));
	}
	
}
