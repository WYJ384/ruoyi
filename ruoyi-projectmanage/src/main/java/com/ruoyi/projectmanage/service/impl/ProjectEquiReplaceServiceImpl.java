package com.ruoyi.projectmanage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.projectmanage.mapper.ProjectEquiReplaceMapper;
import com.ruoyi.projectmanage.domain.ProjectEquiReplace;
import com.ruoyi.projectmanage.service.IProjectEquiReplaceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备替换工程管理模板Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
@Service
public class ProjectEquiReplaceServiceImpl implements IProjectEquiReplaceService 
{
    @Autowired
    private ProjectEquiReplaceMapper projectEquiReplaceMapper;

    /**
     * 查询设备替换工程管理模板
     * 
     * @param id 设备替换工程管理模板ID
     * @return 设备替换工程管理模板
     */
    @Override
    public ProjectEquiReplace selectProjectEquiReplaceById(String id)
    {
        return projectEquiReplaceMapper.selectProjectEquiReplaceById(id);
    }

    /**
     * 查询设备替换工程管理模板列表
     * 
     * @param projectEquiReplace 设备替换工程管理模板
     * @return 设备替换工程管理模板
     */
    @Override
    public List<ProjectEquiReplace> selectProjectEquiReplaceList(ProjectEquiReplace projectEquiReplace)
    {
        return projectEquiReplaceMapper.selectProjectEquiReplaceList(projectEquiReplace);
    }

    /**
     * 新增设备替换工程管理模板
     * 
     * @param projectEquiReplace 设备替换工程管理模板
     * @return 结果
     */
    @Override
    public int insertProjectEquiReplace(ProjectEquiReplace projectEquiReplace)
    {
        return projectEquiReplaceMapper.insertProjectEquiReplace(projectEquiReplace);
    }

    /**
     * 修改设备替换工程管理模板
     * 
     * @param projectEquiReplace 设备替换工程管理模板
     * @return 结果
     */
    @Override
    public int updateProjectEquiReplace(ProjectEquiReplace projectEquiReplace)
    {
        return projectEquiReplaceMapper.updateProjectEquiReplace(projectEquiReplace);
    }

    /**
     * 删除设备替换工程管理模板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectEquiReplaceByIds(String ids)
    {
        return projectEquiReplaceMapper.deleteProjectEquiReplaceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备替换工程管理模板信息
     * 
     * @param id 设备替换工程管理模板ID
     * @return 结果
     */
    @Override
    public int deleteProjectEquiReplaceById(String id)
    {
        return projectEquiReplaceMapper.deleteProjectEquiReplaceById(id);
    }
}
