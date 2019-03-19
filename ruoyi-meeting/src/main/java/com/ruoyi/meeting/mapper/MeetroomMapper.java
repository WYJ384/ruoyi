package com.ruoyi.meeting.mapper;

import com.ruoyi.meeting.domain.Meetroom;
import java.util.List;	

/**
 * 会议室 数据层
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
public interface MeetroomMapper 
{
	/**
     * 查询会议室信息
     * 
     * @param id 会议室ID
     * @return 会议室信息
     */
	public Meetroom selectMeetroomById(Integer id);
	
	/**
     * 查询会议室列表
     * 
     * @param meetroom 会议室信息
     * @return 会议室集合
     */
	public List<Meetroom> selectMeetroomList(Meetroom meetroom);
	
	/**
     * 新增会议室
     * 
     * @param meetroom 会议室信息
     * @return 结果
     */
	public int insertMeetroom(Meetroom meetroom);
	
	/**
     * 修改会议室
     * 
     * @param meetroom 会议室信息
     * @return 结果
     */
	public int updateMeetroom(Meetroom meetroom);
	
	/**
     * 删除会议室
     * 
     * @param id 会议室ID
     * @return 结果
     */
	public int deleteMeetroomById(Integer id);
	
	/**
     * 批量删除会议室
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMeetroomByIds(String[] ids);
	
}