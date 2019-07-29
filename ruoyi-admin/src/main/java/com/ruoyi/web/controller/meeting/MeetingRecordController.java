package com.ruoyi.web.controller.meeting;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.meeting.domain.Meeting;
import com.ruoyi.meeting.service.IMeetingService;
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
import com.ruoyi.meeting.domain.MeetingRecord;
import com.ruoyi.meeting.service.IMeetingRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 会议记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-07-10
 */
@Controller
@RequestMapping("/meeting/meetingRecord")
public class MeetingRecordController extends BaseController
{
    private String prefix = "meeting/meetingRecord";
	@Autowired
	private IMeetingService meetingService;
	@Autowired
	private IMeetingRecordService meetingRecordService;
	@Autowired
	private ISysUserService userService;
	
	@RequiresPermissions("meeting:meetingRecord:view")
	@GetMapping()
	public String meetingRecord()
	{
	    return prefix + "/meetingRecord";
	}
	
	/**
	 * 查询会议记录列表
	 */
	@RequiresPermissions("meeting:meetingRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MeetingRecord meetingRecord)
	{
		startPage();
		meetingRecord.setCreatedBy(ShiroUtils.getUserId()+"");
        List<MeetingRecord> list = meetingRecordService.selectMeetingRecordList(meetingRecord);
		return getDataTable(list);
	}

	@GetMapping("/query/{id}")
	public String query(@PathVariable("id") String id, ModelMap mmap)
	{
		MeetingRecord meetingRecord = meetingRecordService.selectMeetingRecordById(id);
		mmap.put("meetingRecord", meetingRecord);
		return prefix + "/query";
	}
	
	/**
	 * 导出会议记录列表
	 */
	@RequiresPermissions("meeting:meetingRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MeetingRecord meetingRecord)
    {
    	List<MeetingRecord> list = meetingRecordService.selectMeetingRecordList(meetingRecord);

        ExcelUtil<MeetingRecord> util = new ExcelUtil<MeetingRecord>(MeetingRecord.class);
        return util.exportExcel(list, "meetingRecord");
    }
	
	/**
	 * 新增会议记录
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		Meeting meeting = new Meeting();
		meeting.setCreatedBy(ShiroUtils.getLoginName());
		List<Meeting> meetings = meetingService.selectMeetingList(meeting);
		SysUser sysUser = new SysUser();
		mmap.put("users",userService.selectUserList(sysUser));
		mmap.put("meetings",meetings);

	    return prefix + "/add";
	}
	
	/**
	 * 新增保存会议记录
	 */
	@RequiresPermissions("meeting:meetingRecord:add")
	@Log(title = "会议记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MeetingRecord meetingRecord)
	{
		meetingRecord.setId(UUID.randomUUID().toString().replaceAll("-",""));
		meetingRecord.setCreatedBy(ShiroUtils.getUserId()+"");
		meetingRecord.setCreatedTime(new Date());
		String recorder =  meetingRecord.getSubmitPerson();
	 	SysUser user =  userService.selectUserById(Long.parseLong(meetingRecord.getSubmitPerson()));
	 	meetingRecord.setRecorder(user.getUserName());
		return toAjax(meetingRecordService.insertMeetingRecord(meetingRecord));
	}

	/**
	 * 修改会议记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		MeetingRecord meetingRecord = meetingRecordService.selectMeetingRecordById(id);
		SysUser sysUser = new SysUser();
		mmap.put("users",userService.selectUserList(sysUser));
		mmap.put("meetingRecord", meetingRecord);
	    return prefix + "/edit";
	}

	/**
	 * 修改保存会议记录
	 */
	@RequiresPermissions("meeting:meetingRecord:edit")
	@Log(title = "会议记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MeetingRecord meetingRecord)
	{
		String recorder =  meetingRecord.getSubmitPerson();
		SysUser user =  userService.selectUserById(Long.parseLong(meetingRecord.getSubmitPerson()));
		meetingRecord.setRecorder(user.getUserName());
		return toAjax(meetingRecordService.updateMeetingRecord(meetingRecord));
	}
	
	/**
	 * 删除会议记录
	 */
	@RequiresPermissions("meeting:meetingRecord:remove")
	@Log(title = "会议记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(meetingRecordService.deleteMeetingRecordByIds(ids));
	}
	
}
