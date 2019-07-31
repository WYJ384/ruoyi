package com.ruoyi.web.controller.train;

import java.util.*;

import com.ruoyi.activiti.domain.TaskVO;
import com.ruoyi.activiti.service.ActTaskService;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.NOCStringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.train.domain.Train;
import com.ruoyi.train.service.ITrainService;
import com.ruoyi.worktask.domain.WorkTaskFile;
import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
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
import com.ruoyi.train.domain.Approve;
import com.ruoyi.train.service.IApproveService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 付款审批 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-07-23
 */
@Controller
@RequestMapping("/train/approve")
public class ApproveController extends BaseController
{

    private String prefix = "train/approve";
	@Autowired
	private ISysUserService userService;
	@Autowired
	private IApproveService approveService;
	@Autowired
	private ISysDeptService deptService;
	@Autowired
	private ITrainService trainService;
	@Autowired
	private ActTaskService actTaskService;
	@Autowired
	TaskService taskService;
	@Autowired
	HistoryService historyService;
	
	@RequiresPermissions("train:approve:view")
	@GetMapping()
	public String approve()
	{
	    return prefix + "/approve";
	}
	
	/**
	 * 查询付款审批列表
	 */
	@RequiresPermissions("train:approve:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Approve approve)
	{
		startPage();
        List<Approve> list = approveService.selectApproveList(approve);
		return getDataTable(list);
	}

	/**
	 * 查看我的任务  admin 查看所有任务
	 * @return
	 */
	@Log(title = "查询培训任务", businessType = BusinessType.OTHER)
	@RequiresPermissions("train:approve:view")
	@RequestMapping("/myTask")
	@ResponseBody
	TableDataInfo myTask(TaskVO taskVO) {
		List<Approve> list=new ArrayList<Approve>();
		taskVO.setProcessInstanceBusinessKey("3");
		taskVO.setAssignee(ShiroUtils.getUserId()+"");
		List<TaskVO> taskVOS = actTaskService.taskCandidateOrAssigned(taskVO);
		Iterator<TaskVO> taskVOIterator = taskVOS.iterator();
		while (taskVOIterator.hasNext()){
			TaskVO task = taskVOIterator.next();
			Approve approve = approveService.selectApproveByProcessInstanceId(task.getProcessId());
			if(approve==null){
				continue;
			}
			approve.setTask(task);
			list.add(approve);
		}
		return getDataTable(list);
	}
	@RequiresPermissions("train:approve:view")
	@GetMapping("/task")
	public   String task() {
		return prefix + "/tasks";
	}
	@RequiresPermissions("train:approve:view")
	@GetMapping("/shenhe/{id}/{taskId}")
	public   String shenhe(@PathVariable("id") String id,@PathVariable("taskId") String taskId, ModelMap mmap) {
		List<SysUser> sysUsers = userService.selectUserList(new SysUser());
		mmap.addAttribute("sysUsers",sysUsers);
		mmap.addAttribute("taskId",taskId);
		Approve approve = approveService.selectApproveById(id);
		mmap.put("approve", approve);
//		WorkTaskFile activityFile=new WorkTaskFile();
//		activityFile.setWorkTaskId(id);
//		List<WorkTaskFile> workTaskFiles = workTaskFileService.selectWorkTaskFileList(activityFile);
//		mmap.put("workTaskFiles", workTaskFiles);
		return prefix + "/shenhe";
	}
	/**
	 * 导出付款审批列表
	 */
	@RequiresPermissions("train:approve:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Approve approve)
    {
    	List<Approve> list = approveService.selectApproveList(approve);
        ExcelUtil<Approve> util = new ExcelUtil<Approve>(Approve.class);
        return util.exportExcel(list, "approve");
    }
	
	/**
	 * 新增付款审批
	 */
	@GetMapping("/add")
	public String add(Approve approve, ModelMap mmap)
	{
		List<SysUser> sysUsers = userService.selectUserList(new SysUser());
		mmap.addAttribute("sysUsers",sysUsers);
		approve.setJbr(ShiroUtils.getSysUser().getUserName());
		approve.setCreateTime(new Date());
		approve.setId(NOCStringUtils.getUUID());
//		查询申请编号，若果不存在从001开始
		Integer sqbh=approveService.getMaxSQBH();
		if(sqbh==null){
			sqbh=1;
		}
		Long deptId = ShiroUtils.getSysUser().getDeptId();
		SysDept sysDept = deptService.selectDeptById(deptId);
		approve.setSpbh(String.format("%03d", sqbh));
		approve.setSqdw(sysDept.getDeptName());
		mmap.put("approve", approve);

	    return prefix + "/add";
	}

	/**
	 * 新增保存付款审批
	 */
	@RequiresPermissions("train:approve:add")
	@Log(title = "付款审批", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Approve approve)
	{
		approve.setCreateBy(ShiroUtils.getUserId()+"");
		approve.setCreateTime(new Date());
		approve.setJbr(ShiroUtils.getUserId()+"");
		approve.setId(NOCStringUtils.getUUID());
		startApprove(approve);
		return toAjax(approveService.insertApprove(approve));
	}

	/**
	 * 修改付款审批
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Approve approve = approveService.selectApproveById(id);
		mmap.put("approve", approve);
	    return prefix + "/edit";
	}
	@GetMapping("/query/{id}")
	public String query(@PathVariable("id") String id, ModelMap mmap)
	{
		Approve approve = approveService.selectApproveById(id);
		mmap.put("approve", approve);
		return prefix + "/query";
	}
	@Log(title = "付款审批开始", businessType = BusinessType.UPDATE)
	public void startApprove(Approve approve){
		String businessTable = "approve";
		String businessId = "3";
		String title = "付款审批";
		String userId = ShiroUtils.getLoginName();
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("jszcbfzr", approve.getJszcbfzr());
		vars.put("whbmfzr", approve.getWhbmfzr());
		vars.put("bgsfzr", approve.getBgsfzr());
		vars.put("zgfz", approve.getZgfzjl());
		vars.put("zjl", approve.getZjl());
		ProcessInstance processInstance = actTaskService.startProcess("fksplc", businessTable, businessId, title, userId, vars);
		approve.setProcessInstanceId(processInstance.getId());
		approveService.updateApprove(approve);
	}
	/**
	 * 修改保存付款审批
	 */
	@RequiresPermissions("train:approve:edit")
	@Log(title = "付款审批", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Approve approve)
	{
		approve.setUpdateBy(ShiroUtils.getUserId()+"");
		approve.setUpdateTime(new Date());
		return toAjax(approveService.updateApprove(approve));
	}
	
	/**
	 * 删除付款审批
	 */
	@RequiresPermissions("train:approve:remove")
	@Log(title = "付款审批", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(approveService.deleteApproveByIds(ids));
	}


	@RequiresPermissions("train:train:check")
	@Log(title = "培训审核", businessType = BusinessType.DELETE)
	@PostMapping( "/check")
	@ResponseBody
	public AjaxResult check(String result,String taskId,String id,String comment)
	{
		TaskVO taskVO = actTaskService.selectOneTask(taskId);

		Approve approve = approveService.selectApproveById(id);
		TaskVO taskVo=new TaskVO();
		taskVo.setProcessInstanceId(approve.getProcessInstanceId());
		taskService.setAssignee(taskId,ShiroUtils.getUserId()+"");
		taskService.setOwner(taskId,ShiroUtils.getUserId()+"");
		Map<String, Object> vars = new HashMap<String, Object>();
		actTaskService.complete(taskId,approve.getProcessInstanceId(),comment,"",vars);
		return toAjax(1);
	}
}
