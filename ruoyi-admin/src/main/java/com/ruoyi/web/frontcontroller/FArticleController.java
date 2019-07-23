package com.ruoyi.web.frontcontroller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.exam.domain.LibraryDetail;
import com.ruoyi.exam.domain.SingleChoice;
import com.ruoyi.exam.service.ILibraryDetailService;
import com.ruoyi.exam.service.ILibraryService;
import com.ruoyi.exam.service.ISingleChoiceService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.knowledge.domain.Article;
import com.ruoyi.knowledge.domain.ArticleData;
import com.ruoyi.knowledge.domain.CmsCategory;
import com.ruoyi.knowledge.service.IArticleDataService;
import com.ruoyi.knowledge.service.IArticleService;
import com.ruoyi.knowledge.service.ICmsCategoryService;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 文章 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-05
 */
@Controller
@RequestMapping("/f/knowledge/article")
public class FArticleController extends FBaseController
{
    private String prefix = "knowledge/article";
    @Autowired
    private IWorkTaskFileService workTaskFileService;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICmsCategoryService cmsCategoryService;
	@Autowired
	private IArticleDataService articleDataService;

	@Autowired
	private ILibraryService libraryService;
	@Autowired
	private ILibraryDetailService libraryDetailService;
	@Autowired
	private ISingleChoiceService singleChoiceService;
	@GetMapping("/article/{id}")
	public String article(@PathVariable("id") String id,ModelMap modelMap,String libId)
	{
		Article article = articleService.selectArticleById(id);
		article.setHits(article.getHits()+1);
		articleService.updateArticle(article);
		modelMap.addAttribute("article",article);
		WorkTaskFile activityFile=new WorkTaskFile();
		activityFile.setWorkTaskId(id);
		List<WorkTaskFile> workTaskFiles = workTaskFileService.selectWorkTaskFileList(activityFile);
		modelMap.addAttribute("workTaskFiles",workTaskFiles);
		ArticleData articleData = articleDataService.selectArticleDataById(id);
		if(articleData==null){
			articleData=new ArticleData();
			articleData.setId(id);
			articleData.setAllowComment("1");
			articleDataService.updateArticleData(articleData);
		}
		modelMap.put("articleData", articleData);
		getMenu(modelMap);
		CmsCategory cmsCategory = cmsCategoryService.selectCmsCategoryById(article.getCategoryId());
		String customContentView = cmsCategory.getCustomContentView();
		modelMap.put("cmsCategory", cmsCategory);

		LibraryDetail libraryDetail=new LibraryDetail();
		libraryDetail.setLibId(libId);
		List<LibraryDetail> libraryDetails = libraryDetailService.selectLibraryDetailList(libraryDetail);
		modelMap.put("libraryDetails", libraryDetails);
		SingleChoice singleChoice=new SingleChoice();
		singleChoice.setCreateBy(ShiroUtils.getUserId()+"");
		singleChoice.setChoiceG(article.getId());
		List<SingleChoice> singleChoices = singleChoiceService.selectSingleChoiceList(singleChoice);
		if(singleChoices!=null&&singleChoices.size()>0){
			modelMap.put("isScore", true);
		}else{
			modelMap.put("isScore", false);
		}
		if(StringUtils.isNotEmpty(customContentView)){
			return "/front/"+prefix + "/"+customContentView;
		}else{
			return "/front/"+prefix + "/content";
		}
	}
	@GetMapping("/downloadFile/{id}")
	public void downloadFile(@PathVariable("id") Integer id, HttpServletResponse response) throws Exception
	{
		WorkTaskFile sysFile = workTaskFileService.selectWorkTaskFileById(id);
		String filePath = sysFile.getFilePath();
		String path = Global.getUploadPath() + filePath;
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + sysFile.getFilePath());
		FileUtils.writeBytes(path, response.getOutputStream());
	}
	@GetMapping("/search")
	public String search(String keywords,ModelMap modelMap)
	{
		getMenu(modelMap);
		modelMap.addAttribute("keywords",keywords);
		return "/front/"+prefix + "/column";
	}
	@GetMapping("/column/{categoryId}")
	public String column(@PathVariable("categoryId") String categoryId,ModelMap modelMap)
	{
		getMenu(modelMap);
		CmsCategory cmsCategory = cmsCategoryService.selectCmsCategoryById(categoryId);
		String customListView = cmsCategory.getCustomListView();
		modelMap.addAttribute("categoryId",categoryId);
		modelMap.addAttribute("cmsCategory",cmsCategory);
		if(StringUtils.isNotEmpty(customListView)){
			return "/front/"+prefix + "/"+customListView;
		}else{
			return "/front/"+prefix + "/column";
		}
	}
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Article article)
	{
		startPage();
		List<Article> list = articleService.selectArticleList(article);
		return getDataTable(list);
	}

	
}
