package com.ruoyi.web.controller.projectmanage;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.projectmanage.domain.ProjectBoardCard;
import com.ruoyi.projectmanage.service.IProjectBoardCardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 板卡扩容工程管理模板Controller
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
@Controller
@RequestMapping("/projectmanage/card")
public class ProjectBoardCardController extends BaseController
{
    private String prefix = "projectmanage/card";

    @Autowired
    private IProjectBoardCardService projectBoardCardService;

    @RequiresPermissions("projectmanage:card:view")
    @GetMapping()
    public String card()
    {
        return prefix + "/card";
    }

    /**
     * 查询板卡扩容工程管理模板列表
     */
    @RequiresPermissions("projectmanage:card:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectBoardCard projectBoardCard)
    {
        startPage();
        List<ProjectBoardCard> list = projectBoardCardService.selectProjectBoardCardList(projectBoardCard);
        return getDataTable(list);
    }

    /**
     * 导出板卡扩容工程管理模板列表
     */
    @RequiresPermissions("projectmanage:card:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectBoardCard projectBoardCard)
    {
        List<ProjectBoardCard> list = projectBoardCardService.selectProjectBoardCardList(projectBoardCard);
        ExcelUtil<ProjectBoardCard> util = new ExcelUtil<ProjectBoardCard>(ProjectBoardCard.class);
        return util.exportExcel(list, "card");
    }

    /**
     * 新增板卡扩容工程管理模板
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存板卡扩容工程管理模板
     */
    @RequiresPermissions("projectmanage:card:add")
    @Log(title = "板卡扩容工程管理模板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectBoardCard projectBoardCard)
    {
        projectBoardCard.setId(UUID.randomUUID().toString().replaceAll("-",""));
        projectBoardCard.setCreateDate(new Date());
        projectBoardCard.setCreateBy(ShiroUtils.getUserId()+"");
        return toAjax(projectBoardCardService.insertProjectBoardCard(projectBoardCard));
    }

    /**
     * 修改板卡扩容工程管理模板
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        ProjectBoardCard projectBoardCard = projectBoardCardService.selectProjectBoardCardById(id);
        mmap.put("projectBoardCard", projectBoardCard);
        return prefix + "/edit";
    }

    /**
     * 修改保存板卡扩容工程管理模板
     */
    @RequiresPermissions("projectmanage:card:edit")
    @Log(title = "板卡扩容工程管理模板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectBoardCard projectBoardCard)
    {
        projectBoardCard.setUpdateDate(new Date());
        projectBoardCard.setUpdateBy(ShiroUtils.getUserId()+"");
        return toAjax(projectBoardCardService.updateProjectBoardCard(projectBoardCard));
    }

    /**
     * 删除板卡扩容工程管理模板
     */
    @RequiresPermissions("projectmanage:card:remove")
    @Log(title = "板卡扩容工程管理模板", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectBoardCardService.deleteProjectBoardCardByIds(ids));
    }
}
