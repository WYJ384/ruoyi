package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MeetroomMapper;
import com.ruoyi.system.domain.Meetroom;
import com.ruoyi.system.service.IMeetroomService;
import com.ruoyi.common.core.text.Convert;

/**
 * 会议室 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
@Service
public class MeetroomServiceImpl implements IMeetroomService 
{
	@Autowired
	private MeetroomMapper meetroomMapper;

	/**
     * 查询会议室信息
     * 
     * @param id 会议室ID
     * @return 会议室信息
     */
    @Override
	public Meetroom selectMeetroomById(Integer id)
	{
	    return meetroomMapper.selectMeetroomById(id);
	}
	
	/**
     * 查询会议室列表
     * 
     * @param meetroom 会议室信息
     * @return 会议室集合
     */
	@Override
	public List<Meetroom> selectMeetroomList(Meetroom meetroom)
	{
	    return meetroomMapper.selectMeetroomList(meetroom);
	}
	
    /**
     * 新增会议室
     * 
     * @param meetroom 会议室信息
     * @return 结果
     */
	@Override
	public int insertMeetroom(Meetroom meetroom)
	{
	    return meetroomMapper.insertMeetroom(meetroom);
	}
	
	/**
     * 修改会议室
     * 
     * @param meetroom 会议室信息
     * @return 结果
     */
	@Override
	public int updateMeetroom(Meetroom meetroom)
	{
	    return meetroomMapper.updateMeetroom(meetroom);
	}

	/**
     * 删除会议室对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMeetroomByIds(String ids)
	{
		return meetroomMapper.deleteMeetroomByIds(Convert.toStrArray(ids));
	}
	
}
