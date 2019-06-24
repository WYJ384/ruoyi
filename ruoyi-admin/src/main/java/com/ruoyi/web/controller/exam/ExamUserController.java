package com.ruoyi.web.controller.exam;

import java.util.Date;
import java.util.List;

import com.ruoyi.exam.domain.PaperQuestion;
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
import com.ruoyi.exam.domain.ExamUser;
import com.ruoyi.exam.service.IExamUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 考试人员 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-24
 */
@Controller
@RequestMapping("/exam/examUser")
public class ExamUserController extends BaseController
{
    private String prefix = "exam/examUser";
	
	@Autowired
	private IExamUserService examUserService;
	
	@RequiresPermissions("exam:examUser:view")
	@GetMapping()
	public String examUser()
	{
	    return prefix + "/examUser";
	}
	
	/**
	 * 查询考试人员列表
	 */
	@RequiresPermissions("exam:examUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamUser examUser)
	{
		startPage();
        List<ExamUser> list = examUserService.selectExamUserList(examUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出考试人员列表
	 */
	@RequiresPermissions("exam:examUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamUser examUser)
    {
    	List<ExamUser> list = examUserService.selectExamUserList(examUser);
        ExcelUtil<ExamUser> util = new ExcelUtil<ExamUser>(ExamUser.class);
        return util.exportExcel(list, "examUser");
    }
	
	/**
	 * 新增考试人员
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
	@Log(title = "考试人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamUser examUser, String ids)
	{
		String[] userIds = ids.split(",");
		for (int i = 0; i < userIds.length; i++) {
			String userId=userIds[i];
			examUser.setCreateBy(ShiroUtils.getUserId()+"");
			examUser.setCreateDate(new Date());
			examUser.setUserId(userId);
			int ret = examUserService.insertExamUser(examUser);

		}
		return toAjax(1);
	}

	/**
	 * 修改考试人员
	 */
	@GetMapping("/edit/{examId}")
	public String edit(@PathVariable("examId") String examId, ModelMap mmap)
	{
		ExamUser examUser = examUserService.selectExamUserById(examId);
		mmap.put("examUser", examUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考试人员
	 */
	@RequiresPermissions("exam:examUser:edit")
	@Log(title = "考试人员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamUser examUser)
	{		
		return toAjax(examUserService.updateExamUser(examUser));
	}
	
	/**
	 * 删除考试人员
	 */
	@RequiresPermissions("exam:examUser:remove")
	@Log(title = "考试人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examUserService.deleteExamUserByIds(ids));
	}
	
}
