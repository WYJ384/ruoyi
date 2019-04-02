package com.ruoyi.web.controller.taskscore;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.taskscore.domain.ScoreActivityDetail;
import com.ruoyi.taskscore.domain.ScoringPointer;
import com.ruoyi.taskscore.service.IScoreActivityDetailService;
import com.ruoyi.taskscore.service.IScoringPointerService;
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
import com.ruoyi.taskscore.domain.ScoreActivity;
import com.ruoyi.taskscore.service.IScoreActivityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 评分活动 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/taskscore/scoreActivity")
public class ScoreActivityController extends BaseController
{
    private String prefix = "taskscore/scoreActivity";
	
	@Autowired
	private IScoreActivityService scoreActivityService;
	@Autowired
	private IScoringPointerService scoringPointerService;

	@Autowired
	private IScoreActivityDetailService scoreActivityDetailService;
	@RequiresPermissions("taskscore:scoreActivity:view")
	@GetMapping()
	public String scoreActivity()
	{
	    return prefix + "/scoreActivity";
	}
	
	/**
	 * 查询评分活动列表
	 */
	@RequiresPermissions("taskscore:scoreActivity:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ScoreActivity scoreActivity)
	{
		startPage();
        List<ScoreActivity> list = scoreActivityService.selectScoreActivityList(scoreActivity);
		Iterator<ScoreActivity> activityIterator = list.iterator();
		while (activityIterator.hasNext()){
			ScoreActivity activity = activityIterator.next();
			Double scoreSum=0D;
			String activityId = activity.getId();
			ScoreActivityDetail activityDetail=new ScoreActivityDetail();
			activityDetail.setActivityId(activityId);
			List<ScoreActivityDetail> scoreActivityDetails = scoreActivityDetailService.selectScoreActivityDetailList(activityDetail);
			Iterator<ScoreActivityDetail> detailIterator = scoreActivityDetails.iterator();
			while (detailIterator.hasNext()){
				ScoreActivityDetail detail = detailIterator.next();
				Double score = detail.getScore();
				if(score!=null){
					scoreSum+=score;
				}
			}
			activity.setRemark(scoreSum+"");
		}
		return getDataTable(list);
	}
	
	
	/**
	 * 导出评分活动列表
	 */
	@RequiresPermissions("taskscore:scoreActivity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScoreActivity scoreActivity)
    {
    	List<ScoreActivity> list = scoreActivityService.selectScoreActivityList(scoreActivity);
        ExcelUtil<ScoreActivity> util = new ExcelUtil<ScoreActivity>(ScoreActivity.class);
        return util.exportExcel(list, "scoreActivity");
    }
	
	/**
	 * 新增评分活动
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存评分活动
	 */
	@RequiresPermissions("taskscore:scoreActivity:add")
	@Log(title = "评分活动", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ScoreActivity scoreActivity)
	{
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		scoreActivity.setId(uuid);
		scoreActivity.setCreateBy(ShiroUtils.getLoginName());
		scoreActivity.setCreateTime(new Date());
		String deptId = scoreActivity.getScoringPointerId();
		ScoringPointer scoringPointer=new ScoringPointer();
		scoringPointer.setDeptId(deptId);
		List<ScoringPointer> scoringPointers = scoringPointerService.selectScoringPointerList(scoringPointer);
		if(scoringPointers.isEmpty()){
			return  AjaxResult.error(1,"请为该部门添加评分指标");
		}
		Iterator<ScoringPointer> scoringPointerIterator = scoringPointers.iterator();
		while (scoringPointerIterator.hasNext()){
			ScoringPointer pointer = scoringPointerIterator.next();
			ScoreActivityDetail	scoreActivityDetail=new ScoreActivityDetail();
			scoreActivityDetail.setActivityId(uuid);
			scoreActivityDetail.setScorePointerId(pointer.getId());
			scoreActivityDetailService.insertScoreActivityDetail(scoreActivityDetail);
		}

		return toAjax(scoreActivityService.insertScoreActivity(scoreActivity));
	}

	/**
	 * 修改评分活动
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ScoreActivity scoreActivity = scoreActivityService.selectScoreActivityById(id);
		mmap.put("scoreActivity", scoreActivity);

		return prefix + "/edit";
	}

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") String id, ModelMap mmap)
	{
		ScoreActivity scoreActivity = scoreActivityService.selectScoreActivityById(id);
		mmap.put("scoreActivity", scoreActivity);
		ScoreActivityDetail scoreActivityDetail=new ScoreActivityDetail();
		scoreActivityDetail.setActivityId(scoreActivity.getId());
		List<ScoreActivityDetail> scoreActivityDetails = scoreActivityDetailService.selectScoreActivityDetailList(scoreActivityDetail);
		mmap.put("scoreActivityDetails", scoreActivityDetails);
		return prefix + "/detail";
	}
	
	/**
	 * 修改保存评分活动
	 */
	@RequiresPermissions("taskscore:scoreActivity:edit")
	@Log(title = "评分活动", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ScoreActivity scoreActivity)
	{
		scoreActivity.setUpdateBy(ShiroUtils.getLoginName());
		scoreActivity.setUpdateTime(new Date());
		return toAjax(scoreActivityService.updateScoreActivity(scoreActivity));
	}
	
	/**
	 * 删除评分活动
	 */
	@RequiresPermissions("taskscore:scoreActivity:remove")
	@Log(title = "评分活动", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(scoreActivityService.deleteScoreActivityByIds(ids));
	}
	
}
