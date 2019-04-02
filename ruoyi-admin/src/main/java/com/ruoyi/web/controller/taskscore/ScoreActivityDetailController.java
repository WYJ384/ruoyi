package com.ruoyi.web.controller.taskscore;

import java.util.Date;
import java.util.List;

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
import com.ruoyi.taskscore.domain.ScoreActivityDetail;
import com.ruoyi.taskscore.service.IScoreActivityDetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 评分活动详情 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/taskscore/scoreActivityDetail")
public class ScoreActivityDetailController extends BaseController
{
    private String prefix = "taskscore/scoreActivityDetail";
	
	@Autowired
	private IScoreActivityDetailService scoreActivityDetailService;
	
	@RequiresPermissions("taskscore:scoreActivityDetail:view")
	@GetMapping()
	public String scoreActivityDetail()
	{
	    return prefix + "/scoreActivityDetail";
	}


	@GetMapping("/deptScore")
	public String deptScore()
	{
		return prefix + "/deptScore";
	}


	/**
	 * 查询评分活动详情列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ScoreActivityDetail scoreActivityDetail)
	{
		startPage();
        List<ScoreActivityDetail> list = scoreActivityDetailService.selectScoreActivityDetailList(scoreActivityDetail);
		return getDataTable(list);
	}

	@PostMapping("/deptDetailList")
	@ResponseBody
	public TableDataInfo deptDetailList(ScoreActivityDetail scoreActivityDetail)
	{
		scoreActivityDetail.setEvalDeptId(ShiroUtils.getSysUser().getDeptId()+"");
		scoreActivityDetail.setActivityStatus("1");
		startPage();
		List<ScoreActivityDetail> list = scoreActivityDetailService.selectScoreActivityDetailList(scoreActivityDetail);
		return getDataTable(list);
	}

	/**
	 * 导出评分活动详情列表
	 */
	@RequiresPermissions("taskscore:scoreActivityDetail:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScoreActivityDetail scoreActivityDetail)
    {
    	List<ScoreActivityDetail> list = scoreActivityDetailService.selectScoreActivityDetailList(scoreActivityDetail);
        ExcelUtil<ScoreActivityDetail> util = new ExcelUtil<ScoreActivityDetail>(ScoreActivityDetail.class);
        return util.exportExcel(list, "scoreActivityDetail");
    }
	
	/**
	 * 新增评分活动详情
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存评分活动详情
	 */
	@RequiresPermissions("taskscore:scoreActivityDetail:add")
	@Log(title = "评分活动详情", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ScoreActivityDetail scoreActivityDetail)
	{		
		return toAjax(scoreActivityDetailService.insertScoreActivityDetail(scoreActivityDetail));
	}

	/**
	 * 修改评分活动详情
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ScoreActivityDetail scoreActivityDetail = scoreActivityDetailService.selectScoreActivityDetailById(id);
		mmap.put("scoreActivityDetail", scoreActivityDetail);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存评分活动详情
	 */
	@Log(title = "评分活动详情", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ScoreActivityDetail scoreActivityDetail)
	{
		scoreActivityDetail.setUpdateBy(ShiroUtils.getLoginName());
		scoreActivityDetail.setUpdateTime(new Date());
		scoreActivityDetail.setActivityStatus("2");
		return toAjax(scoreActivityDetailService.updateScoreActivityDetail(scoreActivityDetail));
	}
	
	/**
	 * 删除评分活动详情
	 */
	@RequiresPermissions("taskscore:scoreActivityDetail:remove")
	@Log(title = "评分活动详情", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(scoreActivityDetailService.deleteScoreActivityDetailByIds(ids));
	}
	
}
