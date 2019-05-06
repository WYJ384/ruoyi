package com.ruoyi.knowledge.service;

import com.ruoyi.knowledge.domain.ArticleData;
import java.util.List;

/**
 * 文章详 服务层
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
public interface IArticleDataService 
{
	/**
     * 查询文章详信息
     * 
     * @param id 文章详ID
     * @return 文章详信息
     */
	public ArticleData selectArticleDataById(String id);
	
	/**
     * 查询文章详列表
     * 
     * @param articleData 文章详信息
     * @return 文章详集合
     */
	public List<ArticleData> selectArticleDataList(ArticleData articleData);
	
	/**
     * 新增文章详
     * 
     * @param articleData 文章详信息
     * @return 结果
     */
	public int insertArticleData(ArticleData articleData);
	
	/**
     * 修改文章详
     * 
     * @param articleData 文章详信息
     * @return 结果
     */
	public int updateArticleData(ArticleData articleData);
		
	/**
     * 删除文章详信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteArticleDataByIds(String ids);
	
}
