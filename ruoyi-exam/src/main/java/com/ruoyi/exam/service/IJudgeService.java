package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.Judge;
import java.util.List;

/**
 * 判断题 服务层
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
public interface IJudgeService 
{
	/**
     * 查询判断题信息
     * 
     * @param id 判断题ID
     * @return 判断题信息
     */
	public Judge selectJudgeById(String id);
	
	/**
     * 查询判断题列表
     * 
     * @param judge 判断题信息
     * @return 判断题集合
     */
	public List<Judge> selectJudgeList(Judge judge);
	
	/**
     * 新增判断题
     * 
     * @param judge 判断题信息
     * @return 结果
     */
	public int insertJudge(Judge judge);
	
	/**
     * 修改判断题
     * 
     * @param judge 判断题信息
     * @return 结果
     */
	public int updateJudge(Judge judge);
		
	/**
     * 删除判断题信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteJudgeByIds(String ids);
	
}
