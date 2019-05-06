package com.ruoyi.web.controller.knowledge;

import java.lang.reflect.Array;
import java.util.*;

import com.ruoyi.common.config.Global;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.knowledge.domain.CmsCategory;
import com.ruoyi.knowledge.service.ICmsCategoryService;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.knowledge.domain.Article;
import com.ruoyi.knowledge.service.IArticleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 文章 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-05
 */
@Controller
@RequestMapping("/knowledge/article")
public class ArticleController extends BaseController
{
    private String prefix = "knowledge/article";
    @Autowired
    private IWorkTaskFileService workTaskFileService;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICmsCategoryService cmsCategoryService;

	@RequiresPermissions("knowledge:article:view")
	@GetMapping()
	public String article()
	{
	    return prefix + "/article";
	}
	
	/**
	 * 查询文章列表
	 */
	@RequiresPermissions("knowledge:article:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Article article)
	{
		startPage();
        List<Article> list = articleService.selectArticleList(article);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出文章列表
	 */
	@RequiresPermissions("knowledge:article:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Article article)
    {
    	List<Article> list = articleService.selectArticleList(article);
        ExcelUtil<Article> util = new ExcelUtil<Article>(Article.class);
        return util.exportExcel(list, "article");
    }
	
	/**
	 * 新增文章
	 */
	@GetMapping("/add")
	public String add(Article article, ModelMap mmap)
	{
		article.setId(UUID.randomUUID().toString().replaceAll("-",""));
		mmap.put("article",article);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文章
	 */
	@RequiresPermissions("knowledge:article:add")
	@Log(title = "文章", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Article article)
	{
//		article.setId(UUID.randomUUID().toString().replaceAll("-",""));
		article.setDelFlag("0");
		article.setCreateBy(ShiroUtils.getLoginName());
		article.setCreateDate(new Date());
		return toAjax(articleService.insertArticle(article));
	}

	/**
	 * 修改文章
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
        WorkTaskFile activityFile=new WorkTaskFile();
        activityFile.setWorkTaskId(id);
        List<WorkTaskFile> workTaskFiles = workTaskFileService.selectWorkTaskFileList(activityFile);
		String files="";
		for (int i = 0; i < workTaskFiles.size(); i++) {
			WorkTaskFile workTaskFile = workTaskFiles.get(i);
			files+= workTaskFile.getFileName();
			if(i< workTaskFiles.size()-1){
				files+=",";
			}

		}

		Article article = articleService.selectArticleById(id);
		mmap.put("article", article);
		System.out.println(files);
		mmap.put("files", files);

		CmsCategory cmsCategory = cmsCategoryService.selectCmsCategoryById(article.getCategoryId());
		mmap.put("cmsCategory", cmsCategory);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文章
	 */
	@RequiresPermissions("knowledge:article:edit")
	@Log(title = "文章", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Article article)
	{
		article.setUpdateBy(ShiroUtils.getLoginName());
		article.setUpdateDate(new Date());
		return toAjax(articleService.updateArticle(article));
	}
	
	/**
	 * 删除文章
	 */
	@RequiresPermissions("knowledge:article:remove")
	@Log(title = "文章", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(articleService.deleteArticleByIds(ids));
	}
	
}