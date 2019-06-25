package com.ruoyi.web.controller.exam;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.exam.domain.ExamUser;
import com.ruoyi.exam.domain.Paper;
import com.ruoyi.exam.domain.PaperQuestion;
import com.ruoyi.exam.service.IExamUserService;
import com.ruoyi.exam.service.IPaperQuestionService;
import com.ruoyi.exam.service.IPaperService;
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
import com.ruoyi.exam.domain.Exam;
import com.ruoyi.exam.service.IExamService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 考试 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
@Controller
@RequestMapping("/exam/exam")
public class ExamController extends BaseController
{
    private String prefix = "exam/exam";
	@Autowired
	private IPaperService paperService;
	@Autowired
	private IExamService examService;
	@Autowired
	private ISysUserService userService;
	@Autowired
	private IPaperQuestionService paperQuestionService;
	@Autowired
	private IExamUserService examUserService;

	@RequiresPermissions("exam:exam:view")
	@GetMapping()
	public String exam()
	{
	    return prefix + "/exam";
	}
	
	/**
	 * 查询考试列表
	 */
	@RequiresPermissions("exam:exam:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Exam exam)
	{
		startPage();
        List<Exam> list = examService.selectExamList(exam);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出考试列表
	 */
	@RequiresPermissions("exam:exam:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Exam exam)
    {
    	List<Exam> list = examService.selectExamList(exam);
        ExcelUtil<Exam> util = new ExcelUtil<Exam>(Exam.class);
        return util.exportExcel(list, "exam");
    }
	
	/**
	 * 新增考试
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		Paper paper=new Paper();
		List<Paper> papers = paperService.selectPaperList(paper);
		SysUser sysUser=new SysUser();
		List<SysUser> users = userService.selectUserList(sysUser);
		mmap.addAttribute("users",users);
		mmap.addAttribute("papers",papers);
		mmap.addAttribute("id",UUID.randomUUID().toString().replaceAll("-",""));
	    return prefix + "/add";
	}
	@GetMapping("/examUser/{id}")
	public String examUser(@PathVariable("id") String id, ModelMap mmap)
	{

		mmap.addAttribute("id",id);
		return prefix + "/examUser";
	}
	@GetMapping("/myExam")
	public String myExam(ModelMap mmap)
	{
		return prefix + "/myExam";
	}
	@GetMapping("/examing/{id}")
	public String examing(@PathVariable("id") String id,ModelMap mmap)
	{
		List<PaperQuestion>  paperQuestions = paperQuestionService.selectPaperQuestionById(id);
		mmap.addAttribute("paperQuestions",paperQuestions);
		return prefix + "/examing";
	}

	/**
	 * 查询考试列表
	 */
	@PostMapping("/myExamList")
	@ResponseBody
	public TableDataInfo myExamList(Exam exam)
	{
		startPage();
		exam.setUserId(ShiroUtils.getUserId()+"");
		List<Exam> list = examService.myExamList(exam);
		return getDataTable(list);
	}

	@GetMapping("/query/{id}")
	public String query(@PathVariable("id") String id, ModelMap mmap)
	{

		ExamUser examUser=new ExamUser();
		examUser.setExamId(id);
		List<ExamUser> examUserList = examUserService.selectExamUserList(examUser);
		mmap.addAttribute("examUserList",examUserList);

		Exam exam = examService.selectExamById(id);
		mmap.put("exam", exam);
		Paper paper=new Paper();
		List<Paper> papers = paperService.selectPaperList(paper);
		SysUser sysUser=new SysUser();
		List<SysUser> users = userService.selectUserList(sysUser);
		mmap.addAttribute("users",users);
		mmap.addAttribute("papers",papers);
		return prefix + "/query";
	}
	/**
	 * 新增保存考试
	 */
	@RequiresPermissions("exam:exam:add")
	@Log(title = "考试", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Exam exam)
	{
		exam.setId(UUID.randomUUID().toString().replaceAll("-",""));
		exam.setCreateBy(ShiroUtils.getUserId()+"");
		exam.setCreateDate(new Date());
		return toAjax(examService.insertExam(exam));
	}

	/**
	 * 修改考试
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Paper paper=new Paper();
		List<Paper> papers = paperService.selectPaperList(paper);
		SysUser sysUser=new SysUser();
		List<SysUser> users = userService.selectUserList(sysUser);
		mmap.addAttribute("users",users);
		mmap.addAttribute("papers",papers);
		Exam exam = examService.selectExamById(id);
		mmap.put("exam", exam);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考试
	 */
	@RequiresPermissions("exam:exam:edit")
	@Log(title = "考试", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Exam exam)
	{		
		return toAjax(examService.updateExam(exam));
	}
	
	/**
	 * 删除考试
	 */
	@RequiresPermissions("exam:exam:remove")
	@Log(title = "考试", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examService.deleteExamByIds(ids));
	}
	
}
