package com.ruoyi.worktask.mapper;

import com.ruoyi.worktask.domain.WorkTaskFile;
import java.util.List;	

/**
 * 附件 数据层
 * 
 * @author ruoyi
 * @date 2019-03-25
 */
public interface WorkTaskFileMapper 
{
	/**
     * 查询附件信息
     * 
     * @param id 附件ID
     * @return 附件信息
     */
	public WorkTaskFile selectWorkTaskFileById(Integer id);
	
	/**
     * 查询附件列表
     * 
     * @param workTaskFile 附件信息
     * @return 附件集合
     */
	public List<WorkTaskFile> selectWorkTaskFileList(WorkTaskFile workTaskFile);
	
	/**
     * 新增附件
     * 
     * @param workTaskFile 附件信息
     * @return 结果
     */
	public int insertWorkTaskFile(WorkTaskFile workTaskFile);
	
	/**
     * 修改附件
     * 
     * @param workTaskFile 附件信息
     * @return 结果
     */
	public int updateWorkTaskFile(WorkTaskFile workTaskFile);
	
	/**
     * 删除附件
     * 
     * @param id 附件ID
     * @return 结果
     */
	public int deleteWorkTaskFileById(Integer id);
	
	/**
     * 批量删除附件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWorkTaskFileByIds(String[] ids);
	
}