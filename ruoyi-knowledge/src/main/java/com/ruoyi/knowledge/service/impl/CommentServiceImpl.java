package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.CommentMapper;
import com.ruoyi.knowledge.domain.Comment;
import com.ruoyi.knowledge.service.ICommentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评论 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-16
 */
@Service
public class CommentServiceImpl implements ICommentService 
{
	@Autowired
	private CommentMapper commentMapper;

	/**
     * 查询评论信息
     * 
     * @param id 评论ID
     * @return 评论信息
     */
    @Override
	public Comment selectCommentById(String id)
	{
	    return commentMapper.selectCommentById(id);
	}
	
	/**
     * 查询评论列表
     * 
     * @param comment 评论信息
     * @return 评论集合
     */
	@Override
	public List<Comment> selectCommentList(Comment comment)
	{
	    return commentMapper.selectCommentList(comment);
	}
	
    /**
     * 新增评论
     * 
     * @param comment 评论信息
     * @return 结果
     */
	@Override
	public int insertComment(Comment comment)
	{
	    return commentMapper.insertComment(comment);
	}
	
	/**
     * 修改评论
     * 
     * @param comment 评论信息
     * @return 结果
     */
	@Override
	public int updateComment(Comment comment)
	{
	    return commentMapper.updateComment(comment);
	}

	/**
     * 删除评论对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCommentByIds(String ids)
	{
		return commentMapper.deleteCommentByIds(Convert.toStrArray(ids));
	}
	
}
