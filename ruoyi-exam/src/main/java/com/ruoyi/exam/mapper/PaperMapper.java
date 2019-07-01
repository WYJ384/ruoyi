package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.Paper;
import java.util.List;	

/**
 * 试卷 数据层
 * 
 * @author ruoyi
 * @date 2019-06-19
 */
public interface PaperMapper 
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
     * 删除试卷
     * 
     * @param id 试卷ID
     * @return 结果
     */
	public int deletePaperById(String id);
	
	/**
     * 批量删除试卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePaperByIds(String[] ids);

	/**
	 * 更新试卷分数和总分
	 * @param paper
	 * @return
	 */
	public int updatePaperScore(Paper paper);
}