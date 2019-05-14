package com.ruoyi.web.controller.meeting;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.meeting.domain.Calendar;
import com.ruoyi.meeting.service.ICalendarService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 日程 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-14
 */
@Controller
@RequestMapping("/meeting/calendar")
public class CalendarController extends BaseController
{
    private String prefix = "meeting/calendar";
	
	@Autowired
	private ICalendarService calendarService;
	
	@RequiresPermissions("meeting:calendar:view")
	@GetMapping()
	public String calendar()
	{
	    return prefix + "/calendar";
	}
	
	/**
	 * 查询日程列表
	 */
	@RequiresPermissions("meeting:calendar:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Calendar calendar)
	{
		startPage();
        List<Calendar> list = calendarService.selectCalendarList(calendar);
		return getDataTable(list);
	}
	@GetMapping("/findList")
	@ResponseBody
	public List<Calendar> findList(Calendar calendar)
	{
		startPage();
		if(StringUtils.isNotEmpty(calendar.getStart())&&calendar.getStart().indexOf("T")!=-1){
			String[] startArr = calendar.getStart().split("T");
			calendar.setStart(startArr[0]);
		}
		if(StringUtils.isNotEmpty(calendar.getEnd())&&calendar.getEnd().indexOf("T")!=-1){
			String[] startArr = calendar.getEnd().split("T");
			calendar.setEnd(startArr[0]);
		}
		List<Calendar> list = calendarService.selectCalendarList(calendar);
		return list;
	}
	
	/**
	 * 导出日程列表
	 */
	@RequiresPermissions("meeting:calendar:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Calendar calendar)
    {
    	List<Calendar> list = calendarService.selectCalendarList(calendar);
        ExcelUtil<Calendar> util = new ExcelUtil<Calendar>(Calendar.class);
        return util.exportExcel(list, "calendar");
    }
	
	/**
	 * 新增日程
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存日程
	 */
	@RequiresPermissions("meeting:calendar:add")
	@Log(title = "日程", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Calendar calendar)
	{
		calendar.setId(UUID.randomUUID().toString().replaceAll("-",""));
		calendar.setCreateBy(ShiroUtils.getUserId()+"");
		calendar.setCreateTime(new Date());
		return toAjax(calendarService.insertCalendar(calendar));
	}

	/**
	 * 修改日程
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Calendar calendar = calendarService.selectCalendarById(id);
		mmap.put("calendar", calendar);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存日程
	 */
	@RequiresPermissions("meeting:calendar:edit")
	@Log(title = "日程", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Calendar calendar)
	{		
		return toAjax(calendarService.updateCalendar(calendar));
	}
	
	/**
	 * 删除日程
	 */
	@RequiresPermissions("meeting:calendar:remove")
	@Log(title = "日程", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(calendarService.deleteCalendarByIds(ids));
	}
	
}
