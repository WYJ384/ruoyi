package com.ruoyi.projectmanage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.projectmanage.mapper.ProjectNetworkMapper;
import com.ruoyi.projectmanage.domain.ProjectNetwork;
import com.ruoyi.projectmanage.service.IProjectNetworkService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备入网工程管理模板Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
@Service
public class ProjectNetworkServiceImpl implements IProjectNetworkService 
{
    @Autowired
    private ProjectNetworkMapper projectNetworkMapper;

    /**
     * 查询设备入网工程管理模板
     * 
     * @param id 设备入网工程管理模板ID
     * @return 设备入网工程管理模板
     */
    @Override
    public ProjectNetwork selectProjectNetworkById(String id)
    {
        return projectNetworkMapper.selectProjectNetworkById(id);
    }

    /**
     * 查询设备入网工程管理模板列表
     * 
     * @param projectNetwork 设备入网工程管理模板
     * @return 设备入网工程管理模板
     */
    @Override
    public List<ProjectNetwork> selectProjectNetworkList(ProjectNetwork projectNetwork)
    {
        return projectNetworkMapper.selectProjectNetworkList(projectNetwork);
    }

    /**
     * 新增设备入网工程管理模板
     * 
     * @param projectNetwork 设备入网工程管理模板
     * @return 结果
     */
    @Override
    public int insertProjectNetwork(ProjectNetwork projectNetwork)
    {
        return projectNetworkMapper.insertProjectNetwork(projectNetwork);
    }

    /**
     * 修改设备入网工程管理模板
     * 
     * @param projectNetwork 设备入网工程管理模板
     * @return 结果
     */
    @Override
    public int updateProjectNetwork(ProjectNetwork projectNetwork)
    {
        return projectNetworkMapper.updateProjectNetwork(projectNetwork);
    }

    /**
     * 删除设备入网工程管理模板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectNetworkByIds(String ids)
    {
        return projectNetworkMapper.deleteProjectNetworkByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备入网工程管理模板信息
     * 
     * @param id 设备入网工程管理模板ID
     * @return 结果
     */
    @Override
    public int deleteProjectNetworkById(String id)
    {
        return projectNetworkMapper.deleteProjectNetworkById(id);
    }
}
