package com.ruoyi.meeting.mapper;

import com.ruoyi.meeting.domain.Calendar;
import java.util.List;	

/**
 * 日程 数据层
 * 
 * @author ruoyi
 * @date 2019-05-14
 */
public interface CalendarMapper 
{
	/**
     * 查询日程信息
     * 
     * @param id 日程ID
     * @return 日程信息
     */
	public Calendar selectCalendarById(String id);
	
	/**
     * 查询日程列表
     * 
     * @param calendar 日程信息
     * @return 日程集合
     */
	public List<Calendar> selectCalendarList(Calendar calendar);
	
	/**
     * 新增日程
     * 
     * @param calendar 日程信息
     * @return 结果
     */
	public int insertCalendar(Calendar calendar);
	
	/**
     * 修改日程
     * 
     * @param calendar 日程信息
     * @return 结果
     */
	public int updateCalendar(Calendar calendar);
	
	/**
     * 删除日程
     * 
     * @param id 日程ID
     * @return 结果
     */
	public int deleteCalendarById(String id);
	
	/**
     * 批量删除日程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCalendarByIds(String[] ids);
	
}