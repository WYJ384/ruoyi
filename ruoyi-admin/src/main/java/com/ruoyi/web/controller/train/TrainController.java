package com.ruoyi.web.controller.train;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.train.domain.Train;
import com.ruoyi.train.service.ITrainService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 培训审批 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-11
 */
@Controller
@RequestMapping("/train/train")
public class TrainController extends BaseController
{
    private String prefix = "train/train";
	
	@Autowired
	private ITrainService trainService;
	
	@RequiresPermissions("train:train:view")
	@GetMapping()
	public String train()
	{
	    return prefix + "/train";
	}
	
	/**
	 * 查询培训审批列表
	 */
	@RequiresPermissions("train:train:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Train train)
	{
		startPage();
        List<Train> list = trainService.selectTrainList(train);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出培训审批列表
	 */
	@RequiresPermissions("train:train:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Train train)
    {
    	List<Train> list = trainService.selectTrainList(train);
        ExcelUtil<Train> util = new ExcelUtil<Train>(Train.class);
        return util.exportExcel(list, "train");
    }
	
	/**
	 * 新增培训审批
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存培训审批
	 */
	@RequiresPermissions("train:train:add")
	@Log(title = "培训审批", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Train train)
	{
		train.setId(UUID.randomUUID().toString().replaceAll("-",""));
		train.setCreateBy(ShiroUtils.getUserId()+"");
		train.setCreateTime(new Date());
		train.setUserName(ShiroUtils.getSysUser().getUserName());
		train.setUserId(ShiroUtils.getUserId());
		return toAjax(trainService.insertTrain(train));
	}

	/**
	 * 修改培训审批
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Train train = trainService.selectTrainById(id);
		mmap.put("train", train);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存培训审批
	 */
	@RequiresPermissions("train:train:edit")
	@Log(title = "培训审批", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Train train)
	{		
		return toAjax(trainService.updateTrain(train));
	}
	
	/**
	 * 删除培训审批
	 */
	@RequiresPermissions("train:train:remove")
	@Log(title = "培训审批", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(trainService.deleteTrainByIds(ids));
	}
	
}
