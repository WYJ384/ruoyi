package com.ruoyi.web.controller.projectmanage;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.projectmanage.domain.ProjectNetwork;
import com.ruoyi.projectmanage.service.IProjectNetworkService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备入网工程管理模板Controller
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
@Controller
@RequestMapping("/projectmanage/network")
public class ProjectNetworkController extends BaseController
{
    private String prefix = "projectmanage/network";

    @Autowired
    private IProjectNetworkService projectNetworkService;

    @RequiresPermissions("projectmanage:network:view")
    @GetMapping()
    public String network()
    {
        return prefix + "/network";
    }

    /**
     * 查询设备入网工程管理模板列表
     */
    @RequiresPermissions("projectmanage:network:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectNetwork projectNetwork)
    {
        startPage();
        List<ProjectNetwork> list = projectNetworkService.selectProjectNetworkList(projectNetwork);
        return getDataTable(list);
    }

    /**
     * 导出设备入网工程管理模板列表
     */
    @RequiresPermissions("projectmanage:network:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectNetwork projectNetwork)
    {
        List<ProjectNetwork> list = projectNetworkService.selectProjectNetworkList(projectNetwork);
        ExcelUtil<ProjectNetwork> util = new ExcelUtil<ProjectNetwork>(ProjectNetwork.class);
        return util.exportExcel(list, "network");
    }

    /**
     * 新增设备入网工程管理模板
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备入网工程管理模板
     */
    @RequiresPermissions("projectmanage:network:add")
    @Log(title = "设备入网工程管理模板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectNetwork projectNetwork)
    {
        return toAjax(projectNetworkService.insertProjectNetwork(projectNetwork));
    }

    /**
     * 修改设备入网工程管理模板
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        ProjectNetwork projectNetwork = projectNetworkService.selectProjectNetworkById(id);
        mmap.put("projectNetwork", projectNetwork);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备入网工程管理模板
     */
    @RequiresPermissions("projectmanage:network:edit")
    @Log(title = "设备入网工程管理模板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectNetwork projectNetwork)
    {
        return toAjax(projectNetworkService.updateProjectNetwork(projectNetwork));
    }

    /**
     * 删除设备入网工程管理模板
     */
    @RequiresPermissions("projectmanage:network:remove")
    @Log(title = "设备入网工程管理模板", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectNetworkService.deleteProjectNetworkByIds(ids));
    }
}
