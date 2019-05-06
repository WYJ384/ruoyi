package com.ruoyi.web.frontcontroller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.knowledge.domain.Article;
import com.ruoyi.knowledge.service.IArticleService;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
public class FArticleController extends BaseController
{
    private String prefix = "knowledge/article";
    @Autowired
    private IWorkTaskFileService workTaskFileService;
	@Autowired
	private IArticleService articleService;
	
	@GetMapping("/article/{id}")
	public String article(@PathVariable("id") String id,ModelMap modelMap)
	{
		Article article = articleService.selectArticleById(id);
		modelMap.addAttribute("article",article);
		WorkTaskFile activityFile=new WorkTaskFile();
		activityFile.setWorkTaskId(id);
		List<WorkTaskFile> workTaskFiles = workTaskFileService.selectWorkTaskFileList(activityFile);
		modelMap.addAttribute("workTaskFiles",workTaskFiles);
		return "/front/"+prefix + "/content";
	}
	

	
}
