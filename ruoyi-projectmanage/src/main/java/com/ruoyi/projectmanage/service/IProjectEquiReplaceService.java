package com.ruoyi.projectmanage.service;

import com.ruoyi.projectmanage.domain.ProjectEquiReplace;
import java.util.List;

/**
 * 设备替换工程管理模板Service接口
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
public interface IProjectEquiReplaceService 
{
    /**
     * 查询设备替换工程管理模板
     * 
     * @param id 设备替换工程管理模板ID
     * @return 设备替换工程管理模板
     */
    public ProjectEquiReplace selectProjectEquiReplaceById(String id);

    /**
     * 查询设备替换工程管理模板列表
     * 
     * @param projectEquiReplace 设备替换工程管理模板
     * @return 设备替换工程管理模板集合
     */
    public List<ProjectEquiReplace> selectProjectEquiReplaceList(ProjectEquiReplace projectEquiReplace);

    /**
     * 新增设备替换工程管理模板
     * 
     * @param projectEquiReplace 设备替换工程管理模板
     * @return 结果
     */
    public int insertProjectEquiReplace(ProjectEquiReplace projectEquiReplace);

    /**
     * 修改设备替换工程管理模板
     * 
     * @param projectEquiReplace 设备替换工程管理模板
     * @return 结果
     */
    public int updateProjectEquiReplace(ProjectEquiReplace projectEquiReplace);

    /**
     * 批量删除设备替换工程管理模板
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectEquiReplaceByIds(String ids);

    /**
     * 删除设备替换工程管理模板信息
     * 
     * @param id 设备替换工程管理模板ID
     * @return 结果
     */
    public int deleteProjectEquiReplaceById(String id);
}
