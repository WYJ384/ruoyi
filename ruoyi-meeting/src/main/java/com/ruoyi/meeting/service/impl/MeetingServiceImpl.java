package com.ruoyi.meeting.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.meeting.mapper.MeetingMapper;
import com.ruoyi.meeting.domain.Meeting;
import com.ruoyi.meeting.service.IMeetingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 会议 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
@Service
public class MeetingServiceImpl implements IMeetingService 
{
	@Autowired
	private MeetingMapper meetingMapper;

	/**
     * 查询会议信息
     * 
     * @param id 会议ID
     * @return 会议信息
     */
    @Override
	public Meeting selectMeetingById(Integer id)
	{
	    return meetingMapper.selectMeetingById(id);
	}
	
	/**
     * 查询会议列表
     * 
     * @param meeting 会议信息
     * @return 会议集合
     */
	@DataFilter(userAlias = "meeting.created_by")
	@Override
	public List<Meeting> selectMeetingList(Meeting meeting)
	{
	    return meetingMapper.selectMeetingList(meeting);
	}
	@Override
	public List<Meeting> findAll(Meeting meeting) {
		return meetingMapper.selectMeetingList(meeting);
	}

	/**
     * 新增会议
     * 
     * @param meeting 会议信息
     * @return 结果
     */
	@Override
	public int insertMeeting(Meeting meeting)
	{
	    return meetingMapper.insertMeeting(meeting);
	}
	
	/**
     * 修改会议
     * 
     * @param meeting 会议信息
     * @return 结果
     */
	@Override
	public int updateMeeting(Meeting meeting)
	{
	    return meetingMapper.updateMeeting(meeting);
	}

	/**
     * 删除会议对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMeetingByIds(String ids)
	{
		return meetingMapper.deleteMeetingByIds(Convert.toStrArray(ids));
	}

	@Override
	public int getMeetingCountByRoomId(Meeting meeting) {
		return meetingMapper.getMeetingCountByRoomId(meeting);
	}

}
