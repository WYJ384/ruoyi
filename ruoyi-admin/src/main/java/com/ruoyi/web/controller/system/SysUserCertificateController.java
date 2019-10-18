package com.ruoyi.web.controller.system;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import com.ruoyi.system.domain.SysUserCertificate;
import com.ruoyi.system.service.ISysUserCertificateService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 证书管理Controller
 * 
 * @author ruoyi
 * @date 2019-10-18
 */
@Controller
@RequestMapping("/system/certificate")
public class SysUserCertificateController extends BaseController
{
    private String prefix = "system/certificate";

    @Autowired
    private ISysUserCertificateService sysUserCertificateService;

    @RequiresPermissions("system:certificate:view")
    @GetMapping()
    public String certificate()
    {
        return prefix + "/certificate";
    }

    /**
     * 查询证书管理列表
     */
    @RequiresPermissions("system:certificate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUserCertificate sysUserCertificate)
    {
        startPage();
        List<SysUserCertificate> list = sysUserCertificateService.selectSysUserCertificateList(sysUserCertificate);
        return getDataTable(list);
    }

    /**
     * 导出证书管理列表
     */
    @RequiresPermissions("system:certificate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUserCertificate sysUserCertificate)
    {
        List<SysUserCertificate> list = sysUserCertificateService.selectSysUserCertificateList(sysUserCertificate);
        ExcelUtil<SysUserCertificate> util = new ExcelUtil<SysUserCertificate>(SysUserCertificate.class);
        return util.exportExcel(list, "certificate");
    }

    /**
     * 新增证书管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存证书管理
     */
    @RequiresPermissions("system:certificate:add")
    @Log(title = "证书管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysUserCertificate sysUserCertificate)
    {
        sysUserCertificate.setUserId(ShiroUtils.getUserId()+"");
        sysUserCertificate.setId(UUID.randomUUID().toString().replaceAll("-",""));
        sysUserCertificate.setCreateDate(new Date());
        sysUserCertificate.setCreateBy(ShiroUtils.getUserId()+"");
        return toAjax(sysUserCertificateService.insertSysUserCertificate(sysUserCertificate));
    }

    /**
     * 修改证书管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        SysUserCertificate sysUserCertificate = sysUserCertificateService.selectSysUserCertificateById(id);
        mmap.put("sysUserCertificate", sysUserCertificate);
        return prefix + "/edit";
    }

    /**
     * 修改保存证书管理
     */
    @RequiresPermissions("system:certificate:edit")
    @Log(title = "证书管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysUserCertificate sysUserCertificate)
    {
        sysUserCertificate.setUpdateDate(new Date());
        sysUserCertificate.setUpdateBy(ShiroUtils.getUserId()+"");
        return toAjax(sysUserCertificateService.updateSysUserCertificate(sysUserCertificate));
    }

    /**
     * 删除证书管理
     */
    @RequiresPermissions("system:certificate:remove")
    @Log(title = "证书管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysUserCertificateService.deleteSysUserCertificateByIds(ids));
    }
}
