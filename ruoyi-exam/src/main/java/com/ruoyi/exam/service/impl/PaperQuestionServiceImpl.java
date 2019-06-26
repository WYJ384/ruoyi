package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.PaperQuestionMapper;
import com.ruoyi.exam.domain.PaperQuestion;
import com.ruoyi.exam.service.IPaperQuestionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 试卷-试题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
@Service
public class PaperQuestionServiceImpl implements IPaperQuestionService 
{
	@Autowired
	private PaperQuestionMapper paperQuestionMapper;

	/**
     * 查询试卷-试题信息
     * 
     * @param examPaperId 试卷-试题ID
     * @return 试卷-试题信息
     */
    @Override
	public List<PaperQuestion>  selectPaperQuestionById(String examPaperId)
	{
	    return paperQuestionMapper.selectPaperQuestionById(examPaperId);
	}
	
	/**
     * 查询试卷-试题列表
     * 
     * @param paperQuestion 试卷-试题信息
     * @return 试卷-试题集合
     */
	@Override
	public List<PaperQuestion> selectPaperQuestionList(PaperQuestion paperQuestion)
	{
	    return paperQuestionMapper.selectPaperQuestionList(paperQuestion);
	}
	
    /**
     * 新增试卷-试题
     * 
     * @param paperQuestion 试卷-试题信息
     * @return 结果
     */
	@Override
	public int insertPaperQuestion(PaperQuestion paperQuestion)
	{
	    return paperQuestionMapper.insertPaperQuestion(paperQuestion);
	}
	
	/**
     * 修改试卷-试题
     * 
     * @param paperQuestion 试卷-试题信息
     * @return 结果
     */
	@Override
	public int updatePaperQuestion(PaperQuestion paperQuestion)
	{
	    return paperQuestionMapper.updatePaperQuestion(paperQuestion);
	}

	@Override
	public int updatePaperQuestionScore(PaperQuestion paperQuestion) {
		return  paperQuestionMapper.updatePaperQuestionScore(paperQuestion);
	}

	/**
     * 删除试卷-试题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePaperQuestionByIds(String ids)
	{
		return paperQuestionMapper.deletePaperQuestionByIds(Convert.toStrArray(ids));
	}
	
}
