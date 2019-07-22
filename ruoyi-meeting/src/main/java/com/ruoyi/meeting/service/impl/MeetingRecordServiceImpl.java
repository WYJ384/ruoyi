package com.ruoyi.meeting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.meeting.mapper.MeetingRecordMapper;
import com.ruoyi.meeting.domain.MeetingRecord;
import com.ruoyi.meeting.service.IMeetingRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 会议记录 服务层实现
 *
 * @author ruoyi
 * @date 2019-07-22
 */
@Service
public class MeetingRecordServiceImpl implements IMeetingRecordService
{
	@Autowired
	private MeetingRecordMapper meetingRecordMapper;

	/**
	 * 查询会议记录信息
	 *
	 * @param id 会议记录ID
	 * @return 会议记录信息
	 */
	@Override
	public MeetingRecord selectMeetingRecordById(String id)
	{
		return meetingRecordMapper.selectMeetingRecordById(id);
	}

	/**
	 * 查询会议记录列表
	 *
	 * @param meetingRecord 会议记录信息
	 * @return 会议记录集合
	 */
	@Override
	public List<MeetingRecord> selectMeetingRecordList(MeetingRecord meetingRecord)
	{
		return meetingRecordMapper.selectMeetingRecordList(meetingRecord);
	}

	/**
	 * 新增会议记录
	 *
	 * @param meetingRecord 会议记录信息
	 * @return 结果
	 */
	@Override
	public int insertMeetingRecord(MeetingRecord meetingRecord)
	{
		return meetingRecordMapper.insertMeetingRecord(meetingRecord);
	}

	/**
	 * 修改会议记录
	 *
	 * @param meetingRecord 会议记录信息
	 * @return 结果
	 */
	@Override
	public int updateMeetingRecord(MeetingRecord meetingRecord)
	{
		return meetingRecordMapper.updateMeetingRecord(meetingRecord);
	}

	/**
	 * 删除会议记录对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteMeetingRecordByIds(String ids)
	{
		return meetingRecordMapper.deleteMeetingRecordByIds(Convert.toStrArray(ids));
	}

}
