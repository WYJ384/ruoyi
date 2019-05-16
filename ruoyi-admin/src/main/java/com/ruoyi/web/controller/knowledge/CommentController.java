package com.ruoyi.web.controller.knowledge;

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
import com.ruoyi.knowledge.domain.Comment;
import com.ruoyi.knowledge.service.ICommentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 评论 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-16
 */
@Controller
@RequestMapping("/knowledge/comment")
public class CommentController extends BaseController
{
    private String prefix = "knowledge/comment";
	
	@Autowired
	private ICommentService commentService;
	
	@RequiresPermissions("knowledge:comment:view")
	@GetMapping()
	public String comment()
	{
	    return prefix + "/comment";
	}
	
	/**
	 * 查询评论列表
	 */
	@RequiresPermissions("knowledge:comment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Comment comment)
	{
		startPage();
        List<Comment> list = commentService.selectCommentList(comment);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出评论列表
	 */
	@RequiresPermissions("knowledge:comment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Comment comment)
    {
    	List<Comment> list = commentService.selectCommentList(comment);
        ExcelUtil<Comment> util = new ExcelUtil<Comment>(Comment.class);
        return util.exportExcel(list, "comment");
    }
	
	/**
	 * 新增评论
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存评论
	 */
	@RequiresPermissions("knowledge:comment:add")
	@Log(title = "评论", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Comment comment)
	{		
		return toAjax(commentService.insertComment(comment));
	}

	/**
	 * 修改评论
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Comment comment = commentService.selectCommentById(id);
		mmap.put("comment", comment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存评论
	 */
	@RequiresPermissions("knowledge:comment:edit")
	@Log(title = "评论", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Comment comment)
	{		
		return toAjax(commentService.updateComment(comment));
	}
	
	/**
	 * 删除评论
	 */
	@RequiresPermissions("knowledge:comment:remove")
	@Log(title = "评论", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(commentService.deleteCommentByIds(ids));
	}
	
}
