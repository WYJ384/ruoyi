package com.ruoyi.knowledge.mapper;

import com.ruoyi.knowledge.domain.Comment;
import java.util.List;	

/**
 * 评论 数据层
 * 
 * @author ruoyi
 * @date 2019-05-16
 */
public interface CommentMapper 
{
	/**
     * 查询评论信息
     * 
     * @param id 评论ID
     * @return 评论信息
     */
	public Comment selectCommentById(String id);
	
	/**
     * 查询评论列表
     * 
     * @param comment 评论信息
     * @return 评论集合
     */
	public List<Comment> selectCommentList(Comment comment);
	
	/**
     * 新增评论
     * 
     * @param comment 评论信息
     * @return 结果
     */
	public int insertComment(Comment comment);
	
	/**
     * 修改评论
     * 
     * @param comment 评论信息
     * @return 结果
     */
	public int updateComment(Comment comment);
	
	/**
     * 删除评论
     * 
     * @param id 评论ID
     * @return 结果
     */
	public int deleteCommentById(String id);
	
	/**
     * 批量删除评论
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCommentByIds(String[] ids);
	
}