package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.ArticleDataMapper;
import com.ruoyi.knowledge.domain.ArticleData;
import com.ruoyi.knowledge.service.IArticleDataService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章详 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
@Service
public class ArticleDataServiceImpl implements IArticleDataService 
{
	@Autowired
	private ArticleDataMapper articleDataMapper;

	/**
     * 查询文章详信息
     * 
     * @param id 文章详ID
     * @return 文章详信息
     */
    @Override
	public ArticleData selectArticleDataById(String id)
	{
	    return articleDataMapper.selectArticleDataById(id);
	}
	
	/**
     * 查询文章详列表
     * 
     * @param articleData 文章详信息
     * @return 文章详集合
     */
	@Override
	public List<ArticleData> selectArticleDataList(ArticleData articleData)
	{
	    return articleDataMapper.selectArticleDataList(articleData);
	}
	
    /**
     * 新增文章详
     * 
     * @param articleData 文章详信息
     * @return 结果
     */
	@Override
	public int insertArticleData(ArticleData articleData)
	{
	    return articleDataMapper.insertArticleData(articleData);
	}
	
	/**
     * 修改文章详
     * 
     * @param articleData 文章详信息
     * @return 结果
     */
	@Override
	public int updateArticleData(ArticleData articleData)
	{
	    return articleDataMapper.updateArticleData(articleData);
	}

	/**
     * 删除文章详对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteArticleDataByIds(String ids)
	{
		return articleDataMapper.deleteArticleDataByIds(Convert.toStrArray(ids));
	}
	
}
