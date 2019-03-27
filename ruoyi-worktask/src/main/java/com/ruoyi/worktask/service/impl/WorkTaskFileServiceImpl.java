package com.ruoyi.worktask.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.file.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.worktask.mapper.WorkTaskFileMapper;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 附件 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-25
 */
@Service
public class WorkTaskFileServiceImpl implements IWorkTaskFileService 
{
	@Autowired
	private WorkTaskFileMapper workTaskFileMapper;

	/**
     * 查询附件信息
     * 
     * @param id 附件ID
     * @return 附件信息
     */
    @Override
	public WorkTaskFile selectWorkTaskFileById(Integer id)
	{
	    return workTaskFileMapper.selectWorkTaskFileById(id);
	}
	
	/**
     * 查询附件列表
     * 
     * @param workTaskFile 附件信息
     * @return 附件集合
     */
	@Override
	public List<WorkTaskFile> selectWorkTaskFileList(WorkTaskFile workTaskFile)
	{
	    return workTaskFileMapper.selectWorkTaskFileList(workTaskFile);
	}
	
    /**
     * 新增附件
     * 
     * @param workTaskFile 附件信息
     * @return 结果
     */
	@Override
	public int insertWorkTaskFile(WorkTaskFile workTaskFile)
	{
	    return workTaskFileMapper.insertWorkTaskFile(workTaskFile);
	}
	
	/**
     * 修改附件
     * 
     * @param workTaskFile 附件信息
     * @return 结果
     */
	@Override
	public int updateWorkTaskFile(WorkTaskFile workTaskFile)
	{
	    return workTaskFileMapper.updateWorkTaskFile(workTaskFile);
	}

	/**
     * 删除附件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWorkTaskFileByIds(String ids)
	{
		return workTaskFileMapper.deleteWorkTaskFileByIds(Convert.toStrArray(ids));
	}

	@Override
	public int insertWorkTaskFile(MultipartFile file,String loginName,String uuid) {
		// 上传文件路径
		String filePath = Global.getUploadPath();
		String originalFilename = file.getOriginalFilename();
		int lastIndexOf = originalFilename.lastIndexOf(".");
		String extension = originalFilename.substring(lastIndexOf);
		// 上传并返回新文件名称
		String fileName = null;
		try {
			fileName = FileUploadUtils.upload(filePath, file,extension);
			WorkTaskFile workTaskFile=new WorkTaskFile();
			workTaskFile.setUpdateBy(loginName);
			workTaskFile.setUpdateTime(new Date());
			workTaskFile.setCreateBy(loginName);
			workTaskFile.setCreateTime(new Date());
			workTaskFile.setExtension(extension);
			workTaskFile.setFileName(originalFilename);
			workTaskFile.setFilePath(fileName);
			workTaskFile.setWorkTaskId(uuid);
			workTaskFileMapper.insertWorkTaskFile(workTaskFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
