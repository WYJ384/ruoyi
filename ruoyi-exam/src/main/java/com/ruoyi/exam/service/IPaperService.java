package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.Paper;
import java.util.List;

/**
 * 试卷 服务层
 * 
 * @author ruoyi
 * @date 2019-06-19
 */
public interface IPaperService 
{
	/**
     * 查询试卷信息
     * 
     * @param id 试卷ID
     * @return 试卷信息
     */
	public Paper selectPaperById(String id);
	
	/**
     * 查询试卷列表
     * 
     * @param paper 试卷信息
     * @return 试卷集合
     */
	public List<Paper> selectPaperList(Paper paper);
	
	/**
     * 新增试卷
     * 
     * @param paper 试卷信息
     * @return 结果
     */
	public int insertPaper(Paper paper);
	
	/**
     * 修改试卷
     * 
     * @param paper 试卷信息
     * @return 结果
     */
	public int updatePaper(Paper paper);
		
	/**
     * 删除试卷信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePaperByIds(String ids);
	
}
