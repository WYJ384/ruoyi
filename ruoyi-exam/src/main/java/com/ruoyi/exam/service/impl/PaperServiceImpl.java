package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.PaperMapper;
import com.ruoyi.exam.domain.Paper;
import com.ruoyi.exam.service.IPaperService;
import com.ruoyi.common.core.text.Convert;

/**
 * 试卷 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-19
 */
@Service
public class PaperServiceImpl implements IPaperService 
{
	@Autowired
	private PaperMapper paperMapper;

	/**
     * 查询试卷信息
     * 
     * @param id 试卷ID
     * @return 试卷信息
     */
    @Override
	public Paper selectPaperById(String id)
	{
	    return paperMapper.selectPaperById(id);
	}
	
	/**
     * 查询试卷列表
     * 
     * @param paper 试卷信息
     * @return 试卷集合
     */
	@Override
	public List<Paper> selectPaperList(Paper paper)
	{
	    return paperMapper.selectPaperList(paper);
	}
	
    /**
     * 新增试卷
     * 
     * @param paper 试卷信息
     * @return 结果
     */
	@Override
	public int insertPaper(Paper paper)
	{
	    return paperMapper.insertPaper(paper);
	}
	
	/**
     * 修改试卷
     * 
     * @param paper 试卷信息
     * @return 结果
     */
	@Override
	public int updatePaper(Paper paper)
	{
	    return paperMapper.updatePaper(paper);
	}

	/**
     * 删除试卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePaperByIds(String ids)
	{
		return paperMapper.deletePaperByIds(Convert.toStrArray(ids));
	}

	@Override
	public int updatePaperScore(Paper paper) {
		return paperMapper.updatePaperScore(paper);
	}

}
