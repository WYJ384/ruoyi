package com.ruoyi.web.controller.worktask;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.worktask.domain.WorkTask;
import com.ruoyi.worktask.service.IWorkTaskService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工作任务 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-20
 */
@Controller
@RequestMapping("/worktask/workTask")
public class WorkTaskController extends BaseController
{
    private String prefix = "worktask/workTask";
	@Autowired
	private IWorkTaskFileService workTaskFileService;
	@Autowired
	private IWorkTaskService workTaskService;
	@Autowired
	private ISysDeptService deptService;
	@Autowired
	private ISysUserService userService;
	@RequiresPermissions("worktask:workTask:view")
	@GetMapping()
	public String workTask()
	{
	    return prefix + "/workTask";
	}



	/**
	 * 查询工作任务列表
	 */
	@RequiresPermissions("worktask:workTask:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WorkTask workTask)
	{
		startPage();
        List<WorkTask> list = workTaskService.selectWorkTaskList(workTask);
		Iterator<WorkTask> taskIterator = list.iterator();
		while (taskIterator.hasNext()){
			WorkTask task = taskIterator.next();
			SysDept cooperateDept = deptService.selectDeptById(Long.valueOf(task.getCooperateDeptId()));
			if(cooperateDept!=null){
				task.setCooperateDeptName(cooperateDept.getDeptName());
			}
			SysDept leadDept = deptService.selectDeptById(Long.valueOf(task.getLeadDeptId()));

			if(leadDept!=null){
				task.setLeadDeptName(leadDept.getDeptName());
			}

		}
		return getDataTable(list);
	}
	@RequiresPermissions("worktask:workTask:list")
	@GetMapping("/subTaskList/{id}")
	public String subTaskList(@PathVariable("id") String id, ModelMap mmap)
	{
		mmap.put("pid",id);
		return prefix + "/subWorkTask";
	}
	
	/**
	 * 导出工作任务列表
	 */
	@RequiresPermissions("worktask:workTask:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkTask workTask)
    {
    	List<WorkTask> list = workTaskService.selectWorkTaskList(workTask);
        ExcelUtil<WorkTask> util = new ExcelUtil<WorkTask>(WorkTask.class);
        return util.exportExcel(list, "workTask");
    }
	
	/**
	 * 新增工作任务
	 */
	@GetMapping("/add")
	public String add( ModelMap mmap)
	{
		SysUser sysUser = new SysUser();
//		sysUser.setDeptId(ShiroUtils.getSysUser().getDeptId());
		mmap.put("users",userService.selectUserList(sysUser));
	    return prefix + "/add";
	}
	/**
	 * 查询我的工作任务列表
	 */
	@RequiresPermissions("worktask:workTask:myTask")
	@PostMapping("/selectWorkTaskListByUserId")
	@ResponseBody
	public TableDataInfo selectWorkTaskListByUserId(WorkTask workTask)
	{
		workTask.setUserId(ShiroUtils.getUserId().intValue());
		startPage();
		List<WorkTask> list = workTaskService.selectWorkTaskListByUserId(workTask);
		return getDataTable(list);
	}
	/**
	 * 我的任务
	 */
	@GetMapping("/toMyTask")
	public String toMyTask( ModelMap mmap)
	{
		//selectWorkTaskListByUserId
		return prefix + "/myTask";
	}
	/**
	 * 部门专项工作
	 */
	@GetMapping("/toDeptTask")
	public String toDeptTask( ModelMap mmap)
	{
		//selectWorkTaskListByUserId
		return prefix + "/deptTask";
	}
	/**
	 * 查询部门专项工作
	 */
	@PostMapping("/selectWorkTaskListByDept")
	@ResponseBody
	public TableDataInfo selectWorkTaskListByDept(WorkTask workTask)
	{
		workTask.setLeadDeptId(ShiroUtils.getSysUser().getDeptId().intValue());
		startPage();
		List<WorkTask> list = workTaskService.selectWorkTaskList(workTask);
		Iterator<WorkTask> taskIterator = list.iterator();
		while (taskIterator.hasNext()){
			WorkTask task = taskIterator.next();
			SysDept cooperateDept = deptService.selectDeptById(Long.valueOf(task.getCooperateDeptId()));
			if(cooperateDept!=null){
				task.setCooperateDeptName(cooperateDept.getDeptName());
			}
			SysDept leadDept = deptService.selectDeptById(Long.valueOf(task.getLeadDeptId()));

			if(leadDept!=null){
				task.setLeadDeptName(leadDept.getDeptName());
			}

		}
		return getDataTable(list);
	}

	/**
	 * 新增保存工作任务
	 */
	@RequiresPermissions("worktask:workTask:add")
	@Log(title = "工作任务", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MultipartFile file, WorkTask workTask)
	{
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		workTask.setId(uuid);
		if(!file.isEmpty()){
			try {
				// 上传文件路径
				String filePath = Global.getUploadPath();
				String originalFilename = file.getOriginalFilename();
				int lastIndexOf = originalFilename.lastIndexOf(".");
				String extension = originalFilename.substring(lastIndexOf);
				// 上传并返回新文件名称
				String fileName = FileUploadUtils.upload(filePath, file,extension);
				WorkTaskFile workTaskFile=new WorkTaskFile();
				workTaskFile.setUpdateBy(ShiroUtils.getLoginName());
				workTaskFile.setUpdateTime(new Date());
				workTaskFile.setCreateBy(ShiroUtils.getLoginName());
				workTaskFile.setCreateTime(new Date());
				workTaskFile.setExtension(extension);
				workTaskFile.setFileName(originalFilename);
				workTaskFile.setFilePath(fileName);
				workTaskFile.setWorkTaskId(uuid);
				workTaskFileService.insertWorkTaskFile(workTaskFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		workTask.setCreateBy(ShiroUtils.getLoginName());
		workTask.setCreateTime(new Date());
		return toAjax(workTaskService.insertWorkTask(workTask));
	}

	/**
	 * 修改工作任务
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		SysUser sysUser = new SysUser();
//		sysUser.setDeptId(ShiroUtils.getSysUser().getDeptId());
		WorkTask workTask = workTaskService.selectWorkTaskById(id);

//		WorkTask task = new WorkTask();
//		task.setPid(id);
//		List<WorkTask> workTasks = workTaskService.selectWorkTaskList(task);
//		if(workTasks!=null&&workTasks.size()>0){
//			workTask.setHasChild(true);
//		}else{
//			workTask.setHasChild(false);
//		}
		//附件
		WorkTaskFile workTaskFile=new WorkTaskFile();
		workTaskFile.setWorkTaskId(id);
		List<WorkTaskFile> workTaskFiles = workTaskFileService.selectWorkTaskFileList(workTaskFile);

		SysDept cooperateDept = deptService.selectDeptById(Long.valueOf(workTask.getCooperateDeptId()));
		if(cooperateDept!=null){
			workTask.setCooperateDeptName(cooperateDept.getDeptName());
		}
		SysDept leadDept = deptService.selectDeptById(Long.valueOf(workTask.getLeadDeptId()));

		if(leadDept!=null){
			workTask.setLeadDeptName(leadDept.getDeptName());
		}

		mmap.put("workTask", workTask);
		mmap.put("workTaskFiles", workTaskFiles);
		mmap.put("users",userService.selectUserList(sysUser));


		return prefix + "/edit";
	}
	/**
	 * 添加子任务
	 */
	@GetMapping("/addSubTask")
	public String addSubTask(String id, ModelMap mmap)
	{
		SysUser sysUser = new SysUser();
		sysUser.setDeptId(ShiroUtils.getSysUser().getDeptId());
		WorkTask workTask = workTaskService.selectWorkTaskById(id);
		mmap.put("workTask", workTask);
		mmap.put("users",userService.selectUserList(sysUser));
		return prefix + "/subAdd";
	}


	/**
	 * 修改保存工作任务
	 */
	@RequiresPermissions("worktask:workTask:edit")
	@Log(title = "工作任务", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MultipartFile file, WorkTask workTask)
	{

		if(!file.isEmpty()){
			try {
				// 上传文件路径
				String filePath = Global.getUploadPath();
				String originalFilename = file.getOriginalFilename();
				int lastIndexOf = originalFilename.lastIndexOf(".");
				String extension = originalFilename.substring(lastIndexOf);
				// 上传并返回新文件名称
				String fileName = FileUploadUtils.upload(filePath, file,extension);
				WorkTaskFile workTaskFile=new WorkTaskFile();
				workTaskFile.setUpdateBy(ShiroUtils.getLoginName());
				workTaskFile.setUpdateTime(new Date());
				workTaskFile.setCreateBy(ShiroUtils.getLoginName());
				workTaskFile.setCreateTime(new Date());
				workTaskFile.setExtension(extension);
				workTaskFile.setFileName(originalFilename);
				workTaskFile.setFilePath(fileName);
				workTaskFile.setWorkTaskId(workTask.getId());
				workTaskFileService.insertWorkTaskFile(workTaskFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		workTask.setUpdateTime(new Date());
		workTask.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(workTaskService.updateWorkTask(workTask));
	}
	
	/**
	 * 删除工作任务
	 */
	@RequiresPermissions("worktask:workTask:remove")
	@Log(title = "工作任务", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(workTaskService.deleteWorkTaskByIds(ids));
	}
	
}
