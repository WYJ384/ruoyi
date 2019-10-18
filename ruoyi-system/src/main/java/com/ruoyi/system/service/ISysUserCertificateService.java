package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysUserCertificate;
import java.util.List;

/**
 * 证书管理Service接口
 * 
 * @author ruoyi
 * @date 2019-10-18
 */
public interface ISysUserCertificateService 
{
    /**
     * 查询证书管理
     * 
     * @param id 证书管理ID
     * @return 证书管理
     */
    public SysUserCertificate selectSysUserCertificateById(String id);

    /**
     * 查询证书管理列表
     * 
     * @param sysUserCertificate 证书管理
     * @return 证书管理集合
     */
    public List<SysUserCertificate> selectSysUserCertificateList(SysUserCertificate sysUserCertificate);

    /**
     * 新增证书管理
     * 
     * @param sysUserCertificate 证书管理
     * @return 结果
     */
    public int insertSysUserCertificate(SysUserCertificate sysUserCertificate);

    /**
     * 修改证书管理
     * 
     * @param sysUserCertificate 证书管理
     * @return 结果
     */
    public int updateSysUserCertificate(SysUserCertificate sysUserCertificate);

    /**
     * 批量删除证书管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserCertificateByIds(String ids);

    /**
     * 删除证书管理信息
     * 
     * @param id 证书管理ID
     * @return 结果
     */
    public int deleteSysUserCertificateById(String id);
}
