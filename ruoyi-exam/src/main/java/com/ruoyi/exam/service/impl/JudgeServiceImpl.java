package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.JudgeMapper;
import com.ruoyi.exam.domain.Judge;
import com.ruoyi.exam.service.IJudgeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 判断题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
@Service
public class JudgeServiceImpl implements IJudgeService 
{
	@Autowired
	private JudgeMapper judgeMapper;

	/**
     * 查询判断题信息
     * 
     * @param id 判断题ID
     * @return 判断题信息
     */
    @Override
	public Judge selectJudgeById(String id)
	{
	    return judgeMapper.selectJudgeById(id);
	}
	
	/**
     * 查询判断题列表
     * 
     * @param judge 判断题信息
     * @return 判断题集合
     */
	@Override
	public List<Judge> selectJudgeList(Judge judge)
	{
	    return judgeMapper.selectJudgeList(judge);
	}
	
    /**
     * 新增判断题
     * 
     * @param judge 判断题信息
     * @return 结果
     */
	@Override
	public int insertJudge(Judge judge)
	{
	    return judgeMapper.insertJudge(judge);
	}
	
	/**
     * 修改判断题
     * 
     * @param judge 判断题信息
     * @return 结果
     */
	@Override
	public int updateJudge(Judge judge)
	{
	    return judgeMapper.updateJudge(judge);
	}

	/**
     * 删除判断题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteJudgeByIds(String ids)
	{
		return judgeMapper.deleteJudgeByIds(Convert.toStrArray(ids));
	}
	
}
