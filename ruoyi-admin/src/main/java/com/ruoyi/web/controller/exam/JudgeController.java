package com.ruoyi.web.controller.exam;

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
import com.ruoyi.exam.domain.Judge;
import com.ruoyi.exam.service.IJudgeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 判断题 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
@Controller
@RequestMapping("/exam/judge")
public class JudgeController extends BaseController
{
    private String prefix = "exam/judge";
	
	@Autowired
	private IJudgeService judgeService;
	
	@RequiresPermissions("exam:judge:view")
	@GetMapping()
	public String judge()
	{
	    return prefix + "/judge";
	}
	
	/**
	 * 查询判断题列表
	 */
	@RequiresPermissions("exam:judge:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Judge judge)
	{
		startPage();
        List<Judge> list = judgeService.selectJudgeList(judge);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出判断题列表
	 */
	@RequiresPermissions("exam:judge:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Judge judge)
    {
    	List<Judge> list = judgeService.selectJudgeList(judge);
        ExcelUtil<Judge> util = new ExcelUtil<Judge>(Judge.class);
        return util.exportExcel(list, "judge");
    }
	
	/**
	 * 新增判断题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存判断题
	 */
	@RequiresPermissions("exam:judge:add")
	@Log(title = "判断题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Judge judge)
	{		
		return toAjax(judgeService.insertJudge(judge));
	}

	/**
	 * 修改判断题
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Judge judge = judgeService.selectJudgeById(id);
		mmap.put("judge", judge);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存判断题
	 */
	@RequiresPermissions("exam:judge:edit")
	@Log(title = "判断题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Judge judge)
	{		
		return toAjax(judgeService.updateJudge(judge));
	}
	
	/**
	 * 删除判断题
	 */
	@RequiresPermissions("exam:judge:remove")
	@Log(title = "判断题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(judgeService.deleteJudgeByIds(ids));
	}
	
}
