package com.ruoyi.web.controller.train;

import com.ruoyi.activiti.domain.TaskVO;
import com.ruoyi.activiti.service.ActTaskService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.train.domain.Train;
import com.ruoyi.train.service.ITrainService;
import com.ruoyi.worktask.domain.WorkTask;
import com.ruoyi.worktask.domain.WorkTaskActivity;
import com.ruoyi.worktask.domain.WorkTaskFile;
import com.ruoyi.worktask.service.IWorkTaskFileService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
	private ISysUserService userService;
	@Autowired
	private ITrainService trainService;
	@Autowired
	private ActTaskService actTaskService;
	@Autowired
	TaskService taskService;
	@Autowired
	private IWorkTaskFileService workTaskFileService;
	@Autowired
	private ISysDictDataService dictDataService;
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
	public String add(ModelMap mmap,Train train)
	{
		train.setId(UUID.randomUUID().toString().replaceAll("-",""));
		List<SysUser> sysUsers = userService.selectUserList(new SysUser());
		mmap.addAttribute("sysUsers",sysUsers);
		mmap.put("train", train);
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

		train.setCreateBy(ShiroUtils.getUserId()+"");
		train.setCreateTime(new Date());
		train.setUserName(ShiroUtils.getSysUser().getUserName());
		train.setUserId(ShiroUtils.getUserId());
		if(train.getTrainStatus().equals("2")){
			startTrain(train);
		}
		return toAjax(trainService.insertTrain(train));
	}

	/**
	 * 修改培训审批
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		List<SysUser> sysUsers = userService.selectUserList(new SysUser());
		mmap.addAttribute("sysUsers",sysUsers);
		Train train = trainService.selectTrainById(id);
		mmap.put("train", train);
		WorkTaskFile activityFile=new WorkTaskFile();
		activityFile.setWorkTaskId(id);
		List<WorkTaskFile> workTaskFiles = workTaskFileService.selectWorkTaskFileList(activityFile);
		mmap.put("workTaskFiles", workTaskFiles);
	    return prefix + "/edit";
	}
	@RequiresPermissions("train:train:view")
	@GetMapping("/shenhe/{id}/{taskId}")
	public   String shenhe(@PathVariable("id") String id,@PathVariable("taskId") String taskId, ModelMap mmap) {
		List<SysUser> sysUsers = userService.selectUserList(new SysUser());
		mmap.addAttribute("sysUsers",sysUsers);
		mmap.addAttribute("taskId",taskId);
		Train train = trainService.selectTrainById(id);
		train.setTransportation(dictDataService.selectDictLabel("transportation", train.getTransportation()));
		train.setTrainType(dictDataService.selectDictLabel("trainType", train.getTrainType()));
		mmap.put("train", train);
		WorkTaskFile activityFile=new WorkTaskFile();
		activityFile.setWorkTaskId(id);
		List<WorkTaskFile> workTaskFiles = workTaskFileService.selectWorkTaskFileList(activityFile);
		mmap.put("workTaskFiles", workTaskFiles);
		return prefix + "/shenhe";
	}
	@RequiresPermissions("train:train:view")
	@GetMapping("/query/{id}")
	public   String query(@PathVariable("id") String id, ModelMap mmap) {
		List<SysUser> sysUsers = userService.selectUserList(new SysUser());
		mmap.addAttribute("sysUsers",sysUsers);
		Train train = trainService.selectTrainById(id);
		train.setTransportation(dictDataService.selectDictLabel("transportation", train.getTransportation()));
		train.setTrainType(dictDataService.selectDictLabel("trainType", train.getTrainType()));
		mmap.put("train", train);
		WorkTaskFile activityFile=new WorkTaskFile();
		activityFile.setWorkTaskId(id);
		List<WorkTaskFile> workTaskFiles = workTaskFileService.selectWorkTaskFileList(activityFile);
		mmap.put("workTaskFiles", workTaskFiles);
		return prefix + "/query";
	}

	@Log(title = "培训审批开始", businessType = BusinessType.UPDATE)
	public void startTrain(Train train){
		String businessTable = "train";
		String businessId = "2";
		String title = "专项工作任务";
		String userId = ShiroUtils.getLoginName();
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("bmzr", train.getBmzr());
		ProcessInstance processInstance = actTaskService.startProcess("pxsqlc", businessTable, businessId, title, userId, vars);
		train.setProcessInstanceId(processInstance.getId());
		trainService.updateTrain(train);
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
		if(train.getTrainStatus().equals("2")){
			startTrain(train);
		}
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
	/**
	 * 查看我的任务  admin 查看所有任务
	 * @return
	 */
	@Log(title = "查询培训任务", businessType = BusinessType.OTHER)
	@RequiresPermissions("train:train:view")
	@RequestMapping("/myTask")
	@ResponseBody
	TableDataInfo myTask(TaskVO taskVO) {
		List<Train> list=new ArrayList<Train>();
		taskVO.setProcessInstanceBusinessKey("2");
		taskVO.setAssignee(ShiroUtils.getUserId()+"");
		List<TaskVO> taskVOS = actTaskService.taskCandidateOrAssigned(taskVO);
		Iterator<TaskVO> taskVOIterator = taskVOS.iterator();
		while (taskVOIterator.hasNext()){
			TaskVO task = taskVOIterator.next();
			Train train = trainService.selectTrainByProcessInstanceId(task.getProcessId());
			train.setTask(task);
			list.add(train);
		}
		return getDataTable(list);
	}
	@RequiresPermissions("train:train:view")
	@GetMapping("/task")
	public   String task() {
		return prefix + "/tasks";
	}


	/**
	 * 删除培训审批
	 */
	@RequiresPermissions("train:train:check")
	@Log(title = "培训审核", businessType = BusinessType.DELETE)
	@PostMapping( "/check")
	@ResponseBody
	public AjaxResult check(String result,String taskId,String id)
	{
		TaskVO taskVO = actTaskService.selectOneTask(taskId);
		boolean pass=false;
		Train train = trainService.selectTrainById(id);
		if(result.equals("1")){//通过
			pass=true;
			if(taskVO!=null&&taskVO.getKey().equals("zjlsh")){
				train.setTrainStatus("3");
				trainService.updateTrain(train);
			}
		}else if(result.equals("2")){//不通过
			pass=false;
			train.setTrainStatus("4");
			trainService.updateTrain(train);
		}


		TaskVO taskVo=new TaskVO();
		taskVo.setProcessInstanceId(train.getProcessInstanceId());
		taskService.setAssignee(taskId,ShiroUtils.getUserId()+"");
		taskService.setOwner(taskId,ShiroUtils.getLoginName());
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("bgs", train.getBgs());
		vars.put("pxwyhbgs", train.getPxwyhbgs());
		vars.put("jsfzr", train.getJsfzr());
		vars.put("zfgzjl", train.getZfgzjl());
		vars.put("zjl", train.getZjl());
		vars.put("pass", pass);
		actTaskService.completeTask(taskId, vars);
		return toAjax(1);
	}
}
