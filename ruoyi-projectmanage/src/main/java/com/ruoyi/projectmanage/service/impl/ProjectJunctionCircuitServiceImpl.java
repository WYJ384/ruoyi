package com.ruoyi.projectmanage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.projectmanage.mapper.ProjectJunctionCircuitMapper;
import com.ruoyi.projectmanage.domain.ProjectJunctionCircuit;
import com.ruoyi.projectmanage.service.IProjectJunctionCircuitService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备入网工程管理模板Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
@Service
public class ProjectJunctionCircuitServiceImpl implements IProjectJunctionCircuitService 
{
    @Autowired
    private ProjectJunctionCircuitMapper projectJunctionCircuitMapper;

    /**
     * 查询设备入网工程管理模板
     * 
     * @param id 设备入网工程管理模板ID
     * @return 设备入网工程管理模板
     */
    @Override
    public ProjectJunctionCircuit selectProjectJunctionCircuitById(String id)
    {
        return projectJunctionCircuitMapper.selectProjectJunctionCircuitById(id);
    }

    /**
     * 查询设备入网工程管理模板列表
     * 
     * @param projectJunctionCircuit 设备入网工程管理模板
     * @return 设备入网工程管理模板
     */
    @Override
    public List<ProjectJunctionCircuit> selectProjectJunctionCircuitList(ProjectJunctionCircuit projectJunctionCircuit)
    {
        return projectJunctionCircuitMapper.selectProjectJunctionCircuitList(projectJunctionCircuit);
    }

    /**
     * 新增设备入网工程管理模板
     * 
     * @param projectJunctionCircuit 设备入网工程管理模板
     * @return 结果
     */
    @Override
    public int insertProjectJunctionCircuit(ProjectJunctionCircuit projectJunctionCircuit)
    {
        return projectJunctionCircuitMapper.insertProjectJunctionCircuit(projectJunctionCircuit);
    }

    /**
     * 修改设备入网工程管理模板
     * 
     * @param projectJunctionCircuit 设备入网工程管理模板
     * @return 结果
     */
    @Override
    public int updateProjectJunctionCircuit(ProjectJunctionCircuit projectJunctionCircuit)
    {
        return projectJunctionCircuitMapper.updateProjectJunctionCircuit(projectJunctionCircuit);
    }

    /**
     * 删除设备入网工程管理模板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectJunctionCircuitByIds(String ids)
    {
        return projectJunctionCircuitMapper.deleteProjectJunctionCircuitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备入网工程管理模板信息
     * 
     * @param id 设备入网工程管理模板ID
     * @return 结果
     */
    @Override
    public int deleteProjectJunctionCircuitById(String id)
    {
        return projectJunctionCircuitMapper.deleteProjectJunctionCircuitById(id);
    }
}
