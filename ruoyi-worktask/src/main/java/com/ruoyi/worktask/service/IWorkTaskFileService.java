package com.ruoyi.worktask.service;

import com.ruoyi.worktask.domain.WorkTaskFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 附件 服务层
 * 
 * @author ruoyi
 * @date 2019-03-25
 */
public interface IWorkTaskFileService 
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
     * 删除附件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWorkTaskFileByIds(String ids);

	int insertWorkTaskFile( MultipartFile file,String loginName,String uuid);
}
