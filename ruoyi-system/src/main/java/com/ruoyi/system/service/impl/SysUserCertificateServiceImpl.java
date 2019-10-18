package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysUserCertificateMapper;
import com.ruoyi.system.domain.SysUserCertificate;
import com.ruoyi.system.service.ISysUserCertificateService;
import com.ruoyi.common.core.text.Convert;

/**
 * 证书管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-18
 */
@Service
public class SysUserCertificateServiceImpl implements ISysUserCertificateService 
{
    @Autowired
    private SysUserCertificateMapper sysUserCertificateMapper;

    /**
     * 查询证书管理
     * 
     * @param id 证书管理ID
     * @return 证书管理
     */
    @Override
    public SysUserCertificate selectSysUserCertificateById(String id)
    {
        return sysUserCertificateMapper.selectSysUserCertificateById(id);
    }

    /**
     * 查询证书管理列表
     * 
     * @param sysUserCertificate 证书管理
     * @return 证书管理
     */
    @Override
    public List<SysUserCertificate> selectSysUserCertificateList(SysUserCertificate sysUserCertificate)
    {
        return sysUserCertificateMapper.selectSysUserCertificateList(sysUserCertificate);
    }

    /**
     * 新增证书管理
     * 
     * @param sysUserCertificate 证书管理
     * @return 结果
     */
    @Override
    public int insertSysUserCertificate(SysUserCertificate sysUserCertificate)
    {
        return sysUserCertificateMapper.insertSysUserCertificate(sysUserCertificate);
    }

    /**
     * 修改证书管理
     * 
     * @param sysUserCertificate 证书管理
     * @return 结果
     */
    @Override
    public int updateSysUserCertificate(SysUserCertificate sysUserCertificate)
    {
        return sysUserCertificateMapper.updateSysUserCertificate(sysUserCertificate);
    }

    /**
     * 删除证书管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysUserCertificateByIds(String ids)
    {
        return sysUserCertificateMapper.deleteSysUserCertificateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除证书管理信息
     * 
     * @param id 证书管理ID
     * @return 结果
     */
    @Override
    public int deleteSysUserCertificateById(String id)
    {
        return sysUserCertificateMapper.deleteSysUserCertificateById(id);
    }
}
