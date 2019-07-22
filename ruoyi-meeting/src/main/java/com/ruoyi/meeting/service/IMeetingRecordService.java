package com.ruoyi.meeting.service;

import com.ruoyi.meeting.domain.MeetingRecord;
import java.util.List;

/**
 * 会议记录 服务层
 *
 * @author ruoyi
 * @date 2019-07-22
 */
public interface IMeetingRecordService
{
	/**
	 * 查询会议记录信息
	 *
	 * @param id 会议记录ID
	 * @return 会议记录信息
	 */
	public MeetingRecord selectMeetingRecordById(String id);

	/**
	 * 查询会议记录列表
	 *
	 * @param meetingRecord 会议记录信息
	 * @return 会议记录集合
	 */
	public List<MeetingRecord> selectMeetingRecordList(MeetingRecord meetingRecord);

	/**
	 * 新增会议记录
	 *
	 * @param meetingRecord 会议记录信息
	 * @return 结果
	 */
	public int insertMeetingRecord(MeetingRecord meetingRecord);

	/**
	 * 修改会议记录
	 *
	 * @param meetingRecord 会议记录信息
	 * @return 结果
	 */
	public int updateMeetingRecord(MeetingRecord meetingRecord);

	/**
	 * 删除会议记录信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteMeetingRecordByIds(String ids);

}
