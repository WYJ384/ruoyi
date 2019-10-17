package com.ruoyi.web.controller.projectmanage;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.projectmanage.domain.ProjectEquiReplace;
import com.ruoyi.projectmanage.service.IProjectEquiReplaceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备替换工程管理模板Controller
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
@Controller
@RequestMapping("/projectmanage/replace")
public class ProjectEquiReplaceController extends BaseController
{
    private String prefix = "projectmanage/replace";

    @Autowired
    private IProjectEquiReplaceService projectEquiReplaceService;

    @RequiresPermissions("projectmanage:replace:view")
    @GetMapping()
    public String replace()
    {
        return prefix + "/replace";
    }

    /**
     * 查询设备替换工程管理模板列表
     */
    @RequiresPermissions("projectmanage:replace:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectEquiReplace projectEquiReplace)
    {
        startPage();
        List<ProjectEquiReplace> list = projectEquiReplaceService.selectProjectEquiReplaceList(projectEquiReplace);
        return getDataTable(list);
    }

    /**
     * 导出设备替换工程管理模板列表
     */
    @RequiresPermissions("projectmanage:replace:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectEquiReplace projectEquiReplace)
    {
        List<ProjectEquiReplace> list = projectEquiReplaceService.selectProjectEquiReplaceList(projectEquiReplace);
        ExcelUtil<ProjectEquiReplace> util = new ExcelUtil<ProjectEquiReplace>(ProjectEquiReplace.class);
        return util.exportExcel(list, "replace");
    }

    /**
     * 新增设备替换工程管理模板
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备替换工程管理模板
     */
    @RequiresPermissions("projectmanage:replace:add")
    @Log(title = "设备替换工程管理模板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectEquiReplace projectEquiReplace)
    {
        return toAjax(projectEquiReplaceService.insertProjectEquiReplace(projectEquiReplace));
    }

    /**
     * 修改设备替换工程管理模板
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        ProjectEquiReplace projectEquiReplace = projectEquiReplaceService.selectProjectEquiReplaceById(id);
        mmap.put("projectEquiReplace", projectEquiReplace);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备替换工程管理模板
     */
    @RequiresPermissions("projectmanage:replace:edit")
    @Log(title = "设备替换工程管理模板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectEquiReplace projectEquiReplace)
    {
        return toAjax(projectEquiReplaceService.updateProjectEquiReplace(projectEquiReplace));
    }

    /**
     * 删除设备替换工程管理模板
     */
    @RequiresPermissions("projectmanage:replace:remove")
    @Log(title = "设备替换工程管理模板", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectEquiReplaceService.deleteProjectEquiReplaceByIds(ids));
    }
}
