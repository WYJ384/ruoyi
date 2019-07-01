package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ExamMapper;
import com.ruoyi.exam.domain.Exam;
import com.ruoyi.exam.service.IExamService;
import com.ruoyi.common.core.text.Convert;

/**
 * 考试 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
@Service
public class ExamServiceImpl implements IExamService 
{
	@Autowired
	private ExamMapper examMapper;

	/**
     * 查询考试信息
     * 
     * @param id 考试ID
     * @return 考试信息
     */
    @Override
	public Exam selectExamById(String id)
	{
	    return examMapper.selectExamById(id);
	}
	
	/**
     * 查询考试列表
     * 
     * @param exam 考试信息
     * @return 考试集合
     */
	@Override
	public List<Exam> selectExamList(Exam exam)
	{
	    return examMapper.selectExamList(exam);
	}

	@Override
	public List<Exam> myExamList(Exam exam) {

		return examMapper.myExamList(exam);
	}

	/**
     * 新增考试
     * 
     * @param exam 考试信息
     * @return 结果
     */
	@Override
	public int insertExam(Exam exam)
	{
	    return examMapper.insertExam(exam);
	}
	
	/**
     * 修改考试
     * 
     * @param exam 考试信息
     * @return 结果
     */
	@Override
	public int updateExam(Exam exam)
	{
	    return examMapper.updateExam(exam);
	}

	/**
     * 删除考试对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamByIds(String ids)
	{
		return examMapper.deleteExamByIds(Convert.toStrArray(ids));
	}

	@Override
	public Integer getExamByExamPaperId(String examPaperId) {
		return examMapper.getExamByExamPaperId(examPaperId);
	}

}
