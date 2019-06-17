package com.ruoyi.exam.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.LibraryDetailMapper;
import com.ruoyi.exam.domain.LibraryDetail;
import com.ruoyi.exam.service.ILibraryDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 题库内容 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-17
 */
@Service
public class LibraryDetailServiceImpl implements ILibraryDetailService 
{
	@Autowired
	private LibraryDetailMapper libraryDetailMapper;

	/**
     * 查询题库内容信息
     * 
     * @param id 题库内容ID
     * @return 题库内容信息
     */
    @Override
	public LibraryDetail selectLibraryDetailById(String id)
	{
	    return libraryDetailMapper.selectLibraryDetailById(id);
	}
	
	/**
     * 查询题库内容列表
     * 
     * @param libraryDetail 题库内容信息
     * @return 题库内容集合
     */
	@Override
	public List<LibraryDetail> selectLibraryDetailList(LibraryDetail libraryDetail)
	{
	    return libraryDetailMapper.selectLibraryDetailList(libraryDetail);
	}
	
    /**
     * 新增题库内容
     * 
     * @param libraryDetail 题库内容信息
     * @return 结果
     */
	@Override
	public int insertLibraryDetail(LibraryDetail libraryDetail)
	{
	    return libraryDetailMapper.insertLibraryDetail(libraryDetail);
	}
	
	/**
     * 修改题库内容
     * 
     * @param libraryDetail 题库内容信息
     * @return 结果
     */
	@Override
	public int updateLibraryDetail(LibraryDetail libraryDetail)
	{
	    return libraryDetailMapper.updateLibraryDetail(libraryDetail);
	}

	/**
     * 删除题库内容对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLibraryDetailByIds(String ids)
	{
		return libraryDetailMapper.deleteLibraryDetailByIds(Convert.toStrArray(ids));
	}

	@Override
	public String importLibraryDetail(List<LibraryDetail> libraryDetails,  String libId, String operName) {

		if (StringUtils.isNull(libraryDetails) || libraryDetails.size() == 0)
		{
			throw new BusinessException("导入数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (LibraryDetail libraryDetail : libraryDetails)
		{

			try
			{
				libraryDetail.setLibId(libId);
				libraryDetail.setId(UUID.randomUUID().toString().replaceAll("-",""));
				libraryDetail.setCreateBy(operName);
				libraryDetail.setCreateDate(new Date());
				int i = libraryDetailMapper.insertLibraryDetail(libraryDetail);
				if(i>0){
					successNum++;
					successMsg.append("<br/>" + successNum + "、题目 " + libraryDetail.getTitle() + " 导入成功");
				}
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、题目 " + libraryDetail.getTitle() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}

}
