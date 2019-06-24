package com.ruoyi.web.controller.exam;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.framework.util.ShiroUtils;
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
import com.ruoyi.exam.domain.PaperQuestion;
import com.ruoyi.exam.service.IPaperQuestionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 试卷-试题 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
@Controller
@RequestMapping("/exam/paperQuestion")
public class PaperQuestionController extends BaseController
{
    private String prefix = "exam/paperQuestion";
	
	@Autowired
	private IPaperQuestionService paperQuestionService;
	
	@RequiresPermissions("exam:paperQuestion:view")
	@GetMapping()
	public String paperQuestion()
	{
	    return prefix + "/paperQuestion";
	}
	
	/**
	 * 查询试卷-试题列表
	 */
	@RequiresPermissions("exam:paperQuestion:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PaperQuestion paperQuestion)
	{
		startPage();
        List<PaperQuestion> list = paperQuestionService.selectPaperQuestionList(paperQuestion);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出试卷-试题列表
	 */
	@RequiresPermissions("exam:paperQuestion:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PaperQuestion paperQuestion)
    {
    	List<PaperQuestion> list = paperQuestionService.selectPaperQuestionList(paperQuestion);
        ExcelUtil<PaperQuestion> util = new ExcelUtil<PaperQuestion>(PaperQuestion.class);
        return util.exportExcel(list, "paperQuestion");
    }
	
	/**
	 * 新增试卷-试题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存试卷-试题
	 */
	@RequiresPermissions("exam:paperQuestion:add")
	@Log(title = "试卷-试题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PaperQuestion paperQuestion,String ids)
	{
		String[] questions = ids.split(",");
		for (int i = 0; i < questions.length; i++) {
			String questtionId=questions[i];
			paperQuestion.setCreateBy(ShiroUtils.getUserId()+"");
			paperQuestion.setCreateDate(new Date());
			paperQuestion.setQuestionId(questtionId);
			int ret = paperQuestionService.insertPaperQuestion(paperQuestion);

		}

		return toAjax(1);
	}


	
	/**
	 * 修改保存试卷-试题
	 */
	@RequiresPermissions("exam:paperQuestion:edit")
	@Log(title = "试卷-试题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PaperQuestion paperQuestion)
	{		
		return toAjax(paperQuestionService.updatePaperQuestion(paperQuestion));
	}
	
	/**
	 * 删除试卷-试题
	 */
	@RequiresPermissions("exam:paperQuestion:remove")
	@Log(title = "试卷-试题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(paperQuestionService.deletePaperQuestionByIds(ids));
	}
	
}
