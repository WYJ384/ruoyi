package com.ruoyi.bbs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bbs.mapper.ReplyMapper;
import com.ruoyi.bbs.domain.Reply;
import com.ruoyi.bbs.service.IReplyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 跟帖 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-05
 */
@Service
public class ReplyServiceImpl implements IReplyService 
{
	@Autowired
	private ReplyMapper replyMapper;

	/**
     * 查询跟帖信息
     * 
     * @param id 跟帖ID
     * @return 跟帖信息
     */
    @Override
	public Reply selectReplyById(String id)
	{
	    return replyMapper.selectReplyById(id);
	}
	
	/**
     * 查询跟帖列表
     * 
     * @param reply 跟帖信息
     * @return 跟帖集合
     */
	@Override
	public List<Reply> selectReplyList(Reply reply)
	{
	    return replyMapper.selectReplyList(reply);
	}
	
    /**
     * 新增跟帖
     * 
     * @param reply 跟帖信息
     * @return 结果
     */
	@Override
	public int insertReply(Reply reply)
	{
	    return replyMapper.insertReply(reply);
	}
	
	/**
     * 修改跟帖
     * 
     * @param reply 跟帖信息
     * @return 结果
     */
	@Override
	public int updateReply(Reply reply)
	{
	    return replyMapper.updateReply(reply);
	}

	/**
     * 删除跟帖对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteReplyByIds(String ids)
	{
		return replyMapper.deleteReplyByIds(Convert.toStrArray(ids));
	}
	
}
