package com.ruoyi.exam.service.impl;

import java.util.List;

import com.ruoyi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ExamUserMapper;
import com.ruoyi.exam.domain.ExamUser;
import com.ruoyi.exam.service.IExamUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 考试人员 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
@Service
public class ExamUserServiceImpl implements IExamUserService 
{
	@Autowired
	private ExamUserMapper examUserMapper;

	/**
     * 查询考试人员信息
     * 
     * @param examId 考试人员ID
     * @return 考试人员信息
     */
    @Override
	public ExamUser selectExamUserById(String examId)
	{
	    return examUserMapper.selectExamUserById(examId);
	}
	
	/**
     * 查询考试人员列表
     * 
     * @param examUser 考试人员信息
     * @return 考试人员集合
     */
	@Override
	public List<ExamUser> selectExamUserList(ExamUser examUser)
	{
	    return examUserMapper.selectExamUserList(examUser);
	}
	
    /**
     * 新增考试人员
     * 
     * @param examUser 考试人员信息
     * @return 结果
     */
	@Override
	public int insertExamUser(ExamUser examUser)
	{
	    return examUserMapper.insertExamUser(examUser);
	}
	
	/**
     * 修改考试人员
     * 
     * @param examUser 考试人员信息
     * @return 结果
     */
	@Override
	public int updateExamUser(ExamUser examUser)
	{
	    return examUserMapper.updateExamUser(examUser);
	}

	/**
     * 删除考试人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamUserByIds(String ids)
	{
		return examUserMapper.deleteExamUserByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<SysUser> selectUserList(SysUser sysUser) {
		return examUserMapper.selectUserList(sysUser);
	}

}
