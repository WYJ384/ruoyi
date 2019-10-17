package com.ruoyi.web.controller.projectmanage;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.projectmanage.domain.ProjectJunctionCircuit;
import com.ruoyi.projectmanage.service.IProjectJunctionCircuitService;
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
@RequestMapping("/projectmanage/circuit")
public class ProjectJunctionCircuitController extends BaseController
{
    private String prefix = "projectmanage/circuit";

    @Autowired
    private IProjectJunctionCircuitService projectJunctionCircuitService;

    @RequiresPermissions("projectmanage:circuit:view")
    @GetMapping()
    public String circuit()
    {
        return prefix + "/circuit";
    }

    /**
     * 查询设备入网工程管理模板列表
     */
    @RequiresPermissions("projectmanage:circuit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectJunctionCircuit projectJunctionCircuit)
    {
        startPage();
        List<ProjectJunctionCircuit> list = projectJunctionCircuitService.selectProjectJunctionCircuitList(projectJunctionCircuit);
        return getDataTable(list);
    }

    /**
     * 导出设备入网工程管理模板列表
     */
    @RequiresPermissions("projectmanage:circuit:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectJunctionCircuit projectJunctionCircuit)
    {
        List<ProjectJunctionCircuit> list = projectJunctionCircuitService.selectProjectJunctionCircuitList(projectJunctionCircuit);
        ExcelUtil<ProjectJunctionCircuit> util = new ExcelUtil<ProjectJunctionCircuit>(ProjectJunctionCircuit.class);
        return util.exportExcel(list, "circuit");
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
    @RequiresPermissions("projectmanage:circuit:add")
    @Log(title = "设备入网工程管理模板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectJunctionCircuit projectJunctionCircuit)
    {
        return toAjax(projectJunctionCircuitService.insertProjectJunctionCircuit(projectJunctionCircuit));
    }

    /**
     * 修改设备入网工程管理模板
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        ProjectJunctionCircuit projectJunctionCircuit = projectJunctionCircuitService.selectProjectJunctionCircuitById(id);
        mmap.put("projectJunctionCircuit", projectJunctionCircuit);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备入网工程管理模板
     */
    @RequiresPermissions("projectmanage:circuit:edit")
    @Log(title = "设备入网工程管理模板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectJunctionCircuit projectJunctionCircuit)
    {
        return toAjax(projectJunctionCircuitService.updateProjectJunctionCircuit(projectJunctionCircuit));
    }

    /**
     * 删除设备入网工程管理模板
     */
    @RequiresPermissions("projectmanage:circuit:remove")
    @Log(title = "设备入网工程管理模板", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectJunctionCircuitService.deleteProjectJunctionCircuitByIds(ids));
    }
}
