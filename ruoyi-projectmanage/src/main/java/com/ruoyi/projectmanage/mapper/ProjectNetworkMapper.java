package com.ruoyi.projectmanage.mapper;

import com.ruoyi.projectmanage.domain.ProjectNetwork;
import java.util.List;

/**
 * 设备入网工程管理模板Mapper接口
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
public interface ProjectNetworkMapper 
{
    /**
     * 查询设备入网工程管理模板
     * 
     * @param id 设备入网工程管理模板ID
     * @return 设备入网工程管理模板
     */
    public ProjectNetwork selectProjectNetworkById(String id);

    /**
     * 查询设备入网工程管理模板列表
     * 
     * @param projectNetwork 设备入网工程管理模板
     * @return 设备入网工程管理模板集合
     */
    public List<ProjectNetwork> selectProjectNetworkList(ProjectNetwork projectNetwork);

    /**
     * 新增设备入网工程管理模板
     * 
     * @param projectNetwork 设备入网工程管理模板
     * @return 结果
     */
    public int insertProjectNetwork(ProjectNetwork projectNetwork);

    /**
     * 修改设备入网工程管理模板
     * 
     * @param projectNetwork 设备入网工程管理模板
     * @return 结果
     */
    public int updateProjectNetwork(ProjectNetwork projectNetwork);

    /**
     * 删除设备入网工程管理模板
     * 
     * @param id 设备入网工程管理模板ID
     * @return 结果
     */
    public int deleteProjectNetworkById(String id);

    /**
     * 批量删除设备入网工程管理模板
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectNetworkByIds(String[] ids);
}
