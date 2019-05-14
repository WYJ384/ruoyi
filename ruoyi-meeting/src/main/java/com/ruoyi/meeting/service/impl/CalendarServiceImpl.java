package com.ruoyi.meeting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.meeting.mapper.CalendarMapper;
import com.ruoyi.meeting.domain.Calendar;
import com.ruoyi.meeting.service.ICalendarService;
import com.ruoyi.common.core.text.Convert;

/**
 * 日程 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-14
 */
@Service
public class CalendarServiceImpl implements ICalendarService 
{
	@Autowired
	private CalendarMapper calendarMapper;

	/**
     * 查询日程信息
     * 
     * @param id 日程ID
     * @return 日程信息
     */
    @Override
	public Calendar selectCalendarById(String id)
	{
	    return calendarMapper.selectCalendarById(id);
	}
	
	/**
     * 查询日程列表
     * 
     * @param calendar 日程信息
     * @return 日程集合
     */
	@Override
	public List<Calendar> selectCalendarList(Calendar calendar)
	{
	    return calendarMapper.selectCalendarList(calendar);
	}
	
    /**
     * 新增日程
     * 
     * @param calendar 日程信息
     * @return 结果
     */
	@Override
	public int insertCalendar(Calendar calendar)
	{
	    return calendarMapper.insertCalendar(calendar);
	}
	
	/**
     * 修改日程
     * 
     * @param calendar 日程信息
     * @return 结果
     */
	@Override
	public int updateCalendar(Calendar calendar)
	{
	    return calendarMapper.updateCalendar(calendar);
	}

	/**
     * 删除日程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCalendarByIds(String ids)
	{
		return calendarMapper.deleteCalendarByIds(Convert.toStrArray(ids));
	}
	
}
