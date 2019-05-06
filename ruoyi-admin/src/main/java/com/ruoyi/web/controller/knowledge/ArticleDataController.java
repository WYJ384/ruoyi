package com.ruoyi.web.controller.knowledge;

import java.util.List;
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
import com.ruoyi.knowledge.domain.ArticleData;
import com.ruoyi.knowledge.service.IArticleDataService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 文章详 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
@Controller
@RequestMapping("/knowledge/articleData")
public class ArticleDataController extends BaseController
{
    private String prefix = "knowledge/articleData";
	
	@Autowired
	private IArticleDataService articleDataService;
	
	@RequiresPermissions("knowledge:articleData:view")
	@GetMapping()
	public String articleData()
	{
	    return prefix + "/articleData";
	}
	
	/**
	 * 查询文章详列表
	 */
	@RequiresPermissions("knowledge:articleData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ArticleData articleData)
	{
		startPage();
        List<ArticleData> list = articleDataService.selectArticleDataList(articleData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出文章详列表
	 */
	@RequiresPermissions("knowledge:articleData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ArticleData articleData)
    {
    	List<ArticleData> list = articleDataService.selectArticleDataList(articleData);
        ExcelUtil<ArticleData> util = new ExcelUtil<ArticleData>(ArticleData.class);
        return util.exportExcel(list, "articleData");
    }
	
	/**
	 * 新增文章详
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文章详
	 */
	@RequiresPermissions("knowledge:articleData:add")
	@Log(title = "文章详", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ArticleData articleData)
	{		
		return toAjax(articleDataService.insertArticleData(articleData));
	}

	/**
	 * 修改文章详
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ArticleData articleData = articleDataService.selectArticleDataById(id);
		mmap.put("articleData", articleData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文章详
	 */
	@RequiresPermissions("knowledge:articleData:edit")
	@Log(title = "文章详", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ArticleData articleData)
	{		
		return toAjax(articleDataService.updateArticleData(articleData));
	}
	
	/**
	 * 删除文章详
	 */
	@RequiresPermissions("knowledge:articleData:remove")
	@Log(title = "文章详", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(articleDataService.deleteArticleDataByIds(ids));
	}
	
}
