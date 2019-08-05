package com.ruoyi.web.frontcontroller.bbs;


import com.ruoyi.bbs.domain.Topic;
import com.ruoyi.bbs.service.ITopicService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.NOCStringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 主贴 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-05
 */
@Controller
@RequestMapping("/f/bbs/topic")
public class FTopicController extends BaseController
{
    private String prefix = "front/bbs";
	
	@Autowired
	private ITopicService topicService;
	
	@GetMapping("/index")
	public String topic(Topic topic,Integer pageSize,Integer pageNum,ModelMap modelMap)
	{
		pageSize=10;
		startPage();
		List<Topic> topicList = topicService.selectTopicList(topic);
		modelMap.addAttribute("topicList",topicList);
		return prefix + "/index";
	}
	
	/**
	 * 查询主贴列表
	 */
//	@RequiresPermissions("bbs:topic:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Topic topic)
	{
		startPage();
        List<Topic> list = topicService.selectTopicList(topic);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出主贴列表
	 */
	@RequiresPermissions("bbs:topic:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Topic topic)
    {
    	List<Topic> list = topicService.selectTopicList(topic);
        ExcelUtil<Topic> util = new ExcelUtil<Topic>(Topic.class);
        return util.exportExcel(list, "topic");
    }
	
	/**
	 * 新增主贴
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/jie/add";
	}

	@GetMapping("/jieIndex")
	public String jieIndex()
	{
		return prefix + "/jie/index";
	}
	@GetMapping("/jieDetail")
	public String jieDetail()
	{
		return prefix + "/jie/detail";
	}
	/**
	 * 新增保存主贴
	 */
	@Log(title = "主贴", businessType = BusinessType.INSERT)
	@PostMapping("/addSave")
	@ResponseBody
	public AjaxResult addSave(Topic topic)
	{
		topic.setId(NOCStringUtils.getUUID());
		topic.setCreateDate(new Date());
		topic.setCreateBy(ShiroUtils.getUserId()+"");
		return toAjax(topicService.insertTopic(topic));
	}

	/**
	 * 修改主贴
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		Topic topic = topicService.selectTopicById(id);
		mmap.put("topic", topic);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存主贴
	 */
	@RequiresPermissions("bbs:topic:edit")
	@Log(title = "主贴", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Topic topic)
	{		
		return toAjax(topicService.updateTopic(topic));
	}
	
	/**
	 * 删除主贴
	 */
	@RequiresPermissions("bbs:topic:remove")
	@Log(title = "主贴", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(topicService.deleteTopicByIds(ids));
	}
	
}
