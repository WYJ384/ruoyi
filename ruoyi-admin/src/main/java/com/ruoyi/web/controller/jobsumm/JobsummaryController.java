package com.ruoyi.web.controller.jobsumm;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.jobsumm.domain.Jobsummary;
import com.ruoyi.jobsumm.service.IJobsummaryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;


/**
 * 工作总结 信息操作处理
 *
 * @author ruoyi
 * @date 2019-06-14
 */
@Controller
@RequestMapping("/jobsumm/jobsummary")
public class JobsummaryController extends BaseController
{
	private String prefix = "jobsumm/jobsummary";

	@Autowired
	private IJobsummaryService jobsummaryService;
    @Autowired
    private ISysUserService userService;

	@RequiresPermissions("jobsumm:jobsummary:view")
	@GetMapping()
	public String jobsummary(ModelMap mmap)
	{
//		Jobsummary jobsummary = jobsummaryService.selectJobsummaryById(id);
		mmap.put("userId", ShiroUtils.getUserId());
		return prefix + "/jobsummary";
	}

	/**
	 * 查询工作总结列表
	 */
	@RequiresPermissions("jobsumm:jobsummary:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Jobsummary jobsummary)
	{
		startPage();
		jobsummary.setCreateBy(ShiroUtils.getUserId().toString());
		jobsummary.setAcceptorUser(ShiroUtils.getUserId().toString());
		List<Jobsummary> list = jobsummaryService.selectJobsummaryList(jobsummary);
		return getDataTable(list);
	}

	@GetMapping("/query/{id}")
	public String query(@PathVariable("id") String id, ModelMap mmap)
	{
		Jobsummary jobsummary = jobsummaryService.selectJobsummaryById(id);
		mmap.put("jobsummary", jobsummary);
		return prefix + "/query";
	}

	/**
	 * 导出工作总结列表
	 */
	@RequiresPermissions("jobsumm:jobsummary:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Jobsummary jobsummary)
	{
		List<Jobsummary> list = jobsummaryService.selectJobsummaryList(jobsummary);
		ExcelUtil<Jobsummary> util = new ExcelUtil<Jobsummary>(Jobsummary.class);
		return util.exportExcel(list, "jobsummary");
	}

	/**
	 * 新增工作总结
	 */
	@GetMapping("/add")
	public String add(ModelMap modelMap)
	{
        List<SysUser> sysUsers = userService.selectUserList(new SysUser());
        modelMap.addAttribute("sysUsers",sysUsers);
		return prefix + "/add";
	}

	/**
	 * 新增保存工作总结
	 */
	@RequiresPermissions("jobsumm:jobsummary:add")
	@Log(title = "工作总结", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Jobsummary jobsummary)
	{
		jobsummary.setId(UUID.randomUUID().toString().replaceAll("-",""));
		jobsummary.setCreateBy(ShiroUtils.getUserId()+"");
		jobsummary.setCreateDate(new Date());
		jobsummary.setSubmitBy(ShiroUtils.getSysUser().getUserName());
		return toAjax(jobsummaryService.insertJobsummary(jobsummary));
	}

	/**
	 * 修改工作总结
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{

        List<SysUser> sysUsers = userService.selectUserList(new SysUser());
        mmap.addAttribute("sysUsers",sysUsers);
        Jobsummary jobsummary = jobsummaryService.selectJobsummaryById(id);
        mmap.put("jobsummary", jobsummary);
		return prefix + "/edit" ;
	}

	/**
	 * 修改保存工作总结
	 */
	@RequiresPermissions("jobsumm:jobsummary:edit")
	@Log(title = "工作总结", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Jobsummary jobsummary)

	{
		jobsummary.setUpdateBy(ShiroUtils.getUserId()+"");
		jobsummary.setUpdateDate(new Date());
		return toAjax(jobsummaryService.updateJobsummary(jobsummary));
	}

	/**
	 * 删除工作总结
	 */
	@RequiresPermissions("jobsumm:jobsummary:remove")
	@Log(title = "工作总结", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		System.out.print(ids);
		return toAjax(jobsummaryService.deleteJobsummaryByIds(ids));
	}

}
