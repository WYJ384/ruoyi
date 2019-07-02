package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.GuestbookMapper;
import com.ruoyi.knowledge.domain.Guestbook;
import com.ruoyi.knowledge.service.IGuestbookService;
import com.ruoyi.common.core.text.Convert;

/**
 * 留言板 服务层实现
 * 
 * @author ruoyi
 * @date 2019-07-02
 */
@Service
public class GuestbookServiceImpl implements IGuestbookService 
{
	@Autowired
	private GuestbookMapper guestbookMapper;

	/**
     * 查询留言板信息
     * 
     * @param id 留言板ID
     * @return 留言板信息
     */
    @Override
	public Guestbook selectGuestbookById(String id)
	{
	    return guestbookMapper.selectGuestbookById(id);
	}
	
	/**
     * 查询留言板列表
     * 
     * @param guestbook 留言板信息
     * @return 留言板集合
     */
	@Override
	public List<Guestbook> selectGuestbookList(Guestbook guestbook)
	{
	    return guestbookMapper.selectGuestbookList(guestbook);
	}
	
    /**
     * 新增留言板
     * 
     * @param guestbook 留言板信息
     * @return 结果
     */
	@Override
	public int insertGuestbook(Guestbook guestbook)
	{
	    return guestbookMapper.insertGuestbook(guestbook);
	}
	
	/**
     * 修改留言板
     * 
     * @param guestbook 留言板信息
     * @return 结果
     */
	@Override
	public int updateGuestbook(Guestbook guestbook)
	{
	    return guestbookMapper.updateGuestbook(guestbook);
	}

	/**
     * 删除留言板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGuestbookByIds(String ids)
	{
		return guestbookMapper.deleteGuestbookByIds(Convert.toStrArray(ids));
	}
	
}
