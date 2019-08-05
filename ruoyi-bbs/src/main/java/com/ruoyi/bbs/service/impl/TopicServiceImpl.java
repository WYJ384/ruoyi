package com.ruoyi.bbs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bbs.mapper.TopicMapper;
import com.ruoyi.bbs.domain.Topic;
import com.ruoyi.bbs.service.ITopicService;
import com.ruoyi.common.core.text.Convert;

/**
 * 主贴 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-05
 */
@Service
public class TopicServiceImpl implements ITopicService 
{
	@Autowired
	private TopicMapper topicMapper;

	/**
     * 查询主贴信息
     * 
     * @param id 主贴ID
     * @return 主贴信息
     */
    @Override
	public Topic selectTopicById(String id)
	{
	    return topicMapper.selectTopicById(id);
	}
	
	/**
     * 查询主贴列表
     * 
     * @param topic 主贴信息
     * @return 主贴集合
     */
	@Override
	public List<Topic> selectTopicList(Topic topic)
	{
	    return topicMapper.selectTopicList(topic);
	}
	
    /**
     * 新增主贴
     * 
     * @param topic 主贴信息
     * @return 结果
     */
	@Override
	public int insertTopic(Topic topic)
	{
	    return topicMapper.insertTopic(topic);
	}
	
	/**
     * 修改主贴
     * 
     * @param topic 主贴信息
     * @return 结果
     */
	@Override
	public int updateTopic(Topic topic)
	{
	    return topicMapper.updateTopic(topic);
	}

	/**
     * 删除主贴对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTopicByIds(String ids)
	{
		return topicMapper.deleteTopicByIds(Convert.toStrArray(ids));
	}
	
}
