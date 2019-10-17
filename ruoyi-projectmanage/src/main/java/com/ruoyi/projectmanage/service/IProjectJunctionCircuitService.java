package com.ruoyi.projectmanage.service;

import com.ruoyi.projectmanage.domain.ProjectJunctionCircuit;
import java.util.List;

/**
 * 设备入网工程管理模板Service接口
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
public interface IProjectJunctionCircuitService 
{
    /**
     * 查询设备入网工程管理模板
     * 
     * @param id 设备入网工程管理模板ID
     * @return 设备入网工程管理模板
     */
    public ProjectJunctionCircuit selectProjectJunctionCircuitById(String id);

    /**
     * 查询设备入网工程管理模板列表
     * 
     * @param projectJunctionCircuit 设备入网工程管理模板
     * @return 设备入网工程管理模板集合
     */
    public List<ProjectJunctionCircuit> selectProjectJunctionCircuitList(ProjectJunctionCircuit projectJunctionCircuit);

    /**
     * 新增设备入网工程管理模板
     * 
     * @param projectJunctionCircuit 设备入网工程管理模板
     * @return 结果
     */
    public int insertProjectJunctionCircuit(ProjectJunctionCircuit projectJunctionCircuit);

    /**
     * 修改设备入网工程管理模板
     * 
     * @param projectJunctionCircuit 设备入网工程管理模板
     * @return 结果
     */
    public int updateProjectJunctionCircuit(ProjectJunctionCircuit projectJunctionCircuit);

    /**
     * 批量删除设备入网工程管理模板
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectJunctionCircuitByIds(String ids);

    /**
     * 删除设备入网工程管理模板信息
     * 
     * @param id 设备入网工程管理模板ID
     * @return 结果
     */
    public int deleteProjectJunctionCircuitById(String id);
}
