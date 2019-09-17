package com.ruoyi.bbs.mapper;

import com.ruoyi.bbs.domain.Reply;
import java.util.List;	

/**
 * 跟帖 数据层
 * 
 * @author ruoyi
 * @date 2019-08-05
 */
public interface ReplyMapper 
{
	/**
     * 查询跟帖信息
     * 
     * @param id 跟帖ID
     * @return 跟帖信息
     */
	public Reply selectReplyById(String id);
	
	/**
     * 查询跟帖列表
     * 
     * @param reply 跟帖信息
     * @return 跟帖集合
     */
	public List<Reply> selectReplyList(Reply reply);
	
	/**
     * 新增跟帖
     * 
     * @param reply 跟帖信息
     * @return 结果
     */
	public int insertReply(Reply reply);
	
	/**
     * 修改跟帖
     * 
     * @param reply 跟帖信息
     * @return 结果
     */
	public int updateReply(Reply reply);
	
	/**
     * 删除跟帖
     * 
     * @param id 跟帖ID
     * @return 结果
     */
	public int deleteReplyById(String id);
	
	/**
     * 批量删除跟帖
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteReplyByIds(String[] ids);

	/**
	 * 根据主题查询评论数量
	 * @param tid
	 * @return
	 */
	public int selectCountByTid(String tid);
	
}