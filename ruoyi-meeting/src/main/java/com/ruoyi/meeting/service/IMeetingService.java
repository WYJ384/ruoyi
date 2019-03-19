package com.ruoyi.meeting.service;

import com.ruoyi.meeting.domain.Meeting;
import java.util.List;

/**
 * 会议 服务层
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
public interface IMeetingService 
{
	/**
     * 查询会议信息
     * 
     * @param id 会议ID
     * @return 会议信息
     */
	public Meeting selectMeetingById(Integer id);
	
	/**
     * 查询会议列表
     * 
     * @param meeting 会议信息
     * @return 会议集合
     */
	public List<Meeting> selectMeetingList(Meeting meeting);
	
	/**
     * 新增会议
     * 
     * @param meeting 会议信息
     * @return 结果
     */
	public int insertMeeting(Meeting meeting);
	
	/**
     * 修改会议
     * 
     * @param meeting 会议信息
     * @return 结果
     */
	public int updateMeeting(Meeting meeting);
		
	/**
     * 删除会议信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMeetingByIds(String ids);

	/**
	 * c查询时间段是否存在会议
	 * @param meeting
	 * @return
     */
	public int getMeetingCountByRoomId(Meeting meeting);
	
}
