package com.ruoyi.bbs.service;

import com.ruoyi.bbs.domain.Topic;
import java.util.List;

/**
 * 主贴 服务层
 * 
 * @author ruoyi
 * @date 2019-08-05
 */
public interface ITopicService 
{
	/**
     * 查询主贴信息
     * 
     * @param id 主贴ID
     * @return 主贴信息
     */
	public Topic selectTopicById(String id);
	
	/**
     * 查询主贴列表
     * 
     * @param topic 主贴信息
     * @return 主贴集合
     */
	public List<Topic> selectTopicList(Topic topic);
	
	/**
     * 新增主贴
     * 
     * @param topic 主贴信息
     * @return 结果
     */
	public int insertTopic(Topic topic);
	
	/**
     * 修改主贴
     * 
     * @param topic 主贴信息
     * @return 结果
     */
	public int updateTopic(Topic topic);
		
	/**
     * 删除主贴信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTopicByIds(String ids);
	
}
