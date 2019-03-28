package com.ruoyi.web.controller.meeting;

import java.util.*;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.meeting.domain.MeetingModel;
import com.ruoyi.meeting.domain.Meetroom;
import com.ruoyi.meeting.service.IMeetroomService;
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
import com.ruoyi.meeting.domain.Meeting;
import com.ruoyi.meeting.service.IMeetingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 会议 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
@Controller
@RequestMapping("/meeting/meeting")
public class MeetingController extends BaseController
{
    private String prefix = "meeting/meeting";
	@Autowired
	private IMeetroomService meetroomService;
	@Autowired
	private IMeetingService meetingService;
	@Autowired
	private ISysUserService userService;
	@RequiresPermissions("meeting:meeting:view")
	@GetMapping()
	public String meeting()
	{
	    return prefix + "/meeting";
	}
	
	/**
	 * 查询会议列表
	 */
	@RequiresPermissions("meeting:meeting:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Meeting meeting)
	{
		startPage();
        List<Meeting> list = meetingService.selectMeetingList(meeting);
		Iterator<Meeting> iterator = list.iterator();
		while (iterator.hasNext()){
			Meeting m = iterator.next();
			Integer meetroomId = m.getMeetroomId();
			Meetroom meetroom = meetroomService.selectMeetroomById(meetroomId);
			m.setMeetroomName(meetroom.getMeetroomName());
		}

		return getDataTable(list);
	}
	@PostMapping("/get")
	@ResponseBody
	public Map get(Meeting meeting)
	{
		Meeting m = meetingService.selectMeetingById(meeting.getId());
		SysUser sysUser = userService.selectUserByLoginName(m.getCreatedBy());
		sysUser.setPassword("");
		Map map=new HashMap<>();
		map.put("meeting",m);
		map.put("sysUser",sysUser);


		return map;
	}
	
	/**
	 * 导出会议列表
	 */
	@RequiresPermissions("meeting:meeting:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Meeting meeting)
    {
    	List<Meeting> list = meetingService.selectMeetingList(meeting);
        ExcelUtil<Meeting> util = new ExcelUtil<Meeting>(Meeting.class);
        return util.exportExcel(list, "meeting");
    }
	
	/**
	 * 新增会议
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		Meetroom meetroom = new Meetroom();
		meetroom.setMeetroomClosed("否");
		List<Meetroom> meetrooms = meetroomService.selectMeetroomList(meetroom);
		mmap.put("meetrooms", meetrooms);
	    return prefix + "/add";
	}
	/**
	 * 预约
	 * @return
	 */
	@GetMapping("/appointment")
	public String appointment(ModelMap mmap)
	{
		Meetroom meetroom = new Meetroom();
		meetroom.setMeetroomClosed("否");
		List<Meetroom> meetrooms = meetroomService.selectMeetroomList(meetroom);
		mmap.put("meetrooms", meetrooms);
		return prefix + "/appointment";
	}

	/**
	 * 预约-timeline的
	 * @return
	 */
	@GetMapping("/appointmentTimeline")
	public String appointmentTimeline(ModelMap mmap)
	{
		Meetroom meetroom = new Meetroom();
		meetroom.setMeetroomClosed("否");
		List<Meetroom> meetrooms = meetroomService.selectMeetroomList(meetroom);

		mmap.put("meetrooms", meetrooms);
		return prefix + "/appointmentTimeline";
	}
	@GetMapping("/findList")
	@ResponseBody
	public List<MeetingModel> findList(Meeting meeting)
	{
		List<MeetingModel> meetingModels=new ArrayList<MeetingModel>();
		List<Meeting> meetings = meetingService.findAll(meeting);
		Iterator<Meeting> iterator = meetings.iterator();
		while (iterator.hasNext()){
			Meeting m = iterator.next();
			MeetingModel meetingModel=new MeetingModel();
			meetingModel.setStart(m.getMeetingBeginTime());
			meetingModel.setEnd(m.getMeetingEndTime());
			meetingModel.setTitle(m.getMeetingName());
			meetingModel.setResourceId(m.getMeetroomId()+"");
			meetingModel.setId(m.getId()+"");
			meetingModels.add(meetingModel);
		}
		return  meetingModels;
	}
	/**
	 * 新增保存会议
	 */
	@RequiresPermissions("meeting:meeting:add")
	@Log(title = "会议", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Meeting meeting)
	{
		Meetroom meetroom = meetroomService.selectMeetroomById(meeting.getMeetroomId());
		if(meetroom.getMeetroomClosed().equals("是")){
			AjaxResult ajaxResult=new AjaxResult();
			ajaxResult.put("msg", "此会议室暂停预约");
			ajaxResult.put("code", 500);
			return ajaxResult;
		}
		Integer meetingCount = meetingService.getMeetingCountByRoomId(meeting);
		if(meetingCount!=0){
			AjaxResult ajaxResult=new AjaxResult();
			ajaxResult.put("msg", "该时间的已有会议");
			ajaxResult.put("code", 500);
			return ajaxResult;
		}
		meeting.setUpdatedTime(new Date());
		meeting.setUpdateBy(ShiroUtils.getLoginName());
		meeting.setCreatedTime(new Date());
		meeting.setCreatedBy(ShiroUtils.getLoginName());
		return toAjax(meetingService.insertMeeting(meeting));
	}

	/**
	 * 修改会议
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Meetroom meetroom = new Meetroom();
		meetroom.setMeetroomClosed("否");
		List<Meetroom> meetrooms = meetroomService.selectMeetroomList(meetroom);
		mmap.put("meetrooms", meetrooms);
		Meeting meeting = meetingService.selectMeetingById(id);
		mmap.put("meeting", meeting);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存会议
	 */
	@RequiresPermissions("meeting:meeting:edit")
	@Log(title = "会议", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Meeting meeting)
	{
		Meetroom meetroom = meetroomService.selectMeetroomById(meeting.getMeetroomId());
		if(meetroom.getMeetroomClosed().equals("是")){
			AjaxResult ajaxResult=new AjaxResult();
			ajaxResult.put("msg", "此会议室暂停预约");
			ajaxResult.put("code", 500);
			return ajaxResult;
		}
		Integer meetingCount = meetingService.getMeetingCountByRoomId(meeting);
		if(meetingCount!=0){
			AjaxResult ajaxResult=new AjaxResult();
			ajaxResult.put("msg", "该时间的已有会议");
			ajaxResult.put("code", 500);
			return ajaxResult;
		}
		meeting.setUpdatedTime(new Date());
		meeting.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(meetingService.updateMeeting(meeting));
	}
	
	/**
	 * 删除会议
	 */
	@RequiresPermissions("meeting:meeting:remove")
	@Log(title = "会议", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(meetingService.deleteMeetingByIds(ids));
	}
	
}
