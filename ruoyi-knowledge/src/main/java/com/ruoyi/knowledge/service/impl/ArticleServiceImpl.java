package com.ruoyi.knowledge.service.impl;

import java.util.List;
import java.util.UUID;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.knowledge.domain.ArticleData;
import com.ruoyi.knowledge.domain.CmsCategory;
import com.ruoyi.knowledge.service.IArticleDataService;
import com.ruoyi.knowledge.service.ICmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.ArticleMapper;
import com.ruoyi.knowledge.domain.Article;
import com.ruoyi.knowledge.service.IArticleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-05
 */
@Service
public class ArticleServiceImpl implements IArticleService 
{
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ICmsCategoryService cmsCategoryService;
	@Autowired
	private IArticleDataService articleDataService;
	/**
     * 查询文章信息
     * 
     * @param id 文章ID
     * @return 文章信息
     */
    @Override
	public Article selectArticleById(String id)
	{
	    return articleMapper.selectArticleById(id);
	}
	
	/**
     * 查询文章列表
     * 
     * @param article 文章信息
     * @return 文章集合
     */
	@Override
	public List<Article> selectArticleList(Article article)
	{
	    return articleMapper.selectArticleList(article);
	}
	
    /**
     * 新增文章
     * 
     * @param article 文章信息
     * @return 结果
     */
	@Override
	public int insertArticle(Article article)
	{
	    return articleMapper.insertArticle(article);
	}
	
	/**
     * 修改文章
     * 
     * @param article 文章信息
     * @return 结果
     */
	@Override
	public int updateArticle(Article article)
	{
	    return articleMapper.updateArticle(article);
	}

	/**
     * 删除文章对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteArticleByIds(String ids)
	{
		return articleMapper.deleteArticleByIds(Convert.toStrArray(ids));
	}

	@Override
	public String importArticle(List<Article> articleList, boolean updateSupport, String operName) {
		if (StringUtils.isNull(articleList) || articleList.size() == 0)
		{
			throw new BusinessException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (Article article : articleList)
		{
			try
			{
				CmsCategory category = cmsCategoryService.selectCategoryByName(new CmsCategory((article.getCategory())));
				CmsCategory cCategory = cmsCategoryService.selectCategoryByName(new CmsCategory((article.getCcategory())));
				if(cCategory!=null){
					article.setCategoryId(cCategory.getId());
				}else if(category!=null){
					article.setCategoryId(category.getId());
				}
				article.setTitle(article.getKeywords());
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				article.setId(uuid);

				this.insertArticle(article);
				ArticleData articleData=new ArticleData();
				articleData.setId(uuid);
				articleData.setReason(article.getReason());
				articleData.setSolution(article.getSolution());
				articleDataService.insertArticleData(articleData);
				successNum++;
			}
			catch (Exception e)
			{
				failureNum++;
				e.printStackTrace();
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
