package com.ruoyi.knowledge.service;

import com.ruoyi.knowledge.domain.Guestbook;
import java.util.List;

/**
 * 留言板 服务层
 * 
 * @author ruoyi
 * @date 2019-07-02
 */
public interface IGuestbookService 
{
	/**
     * 查询留言板信息
     * 
     * @param id 留言板ID
     * @return 留言板信息
     */
	public Guestbook selectGuestbookById(String id);
	
	/**
     * 查询留言板列表
     * 
     * @param guestbook 留言板信息
     * @return 留言板集合
     */
	public List<Guestbook> selectGuestbookList(Guestbook guestbook);
	
	/**
     * 新增留言板
     * 
     * @param guestbook 留言板信息
     * @return 结果
     */
	public int insertGuestbook(Guestbook guestbook);
	
	/**
     * 修改留言板
     * 
     * @param guestbook 留言板信息
     * @return 结果
     */
	public int updateGuestbook(Guestbook guestbook);
		
	/**
     * 删除留言板信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGuestbookByIds(String ids);
	
}
