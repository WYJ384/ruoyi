package com.ruoyi.projectmanage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.projectmanage.mapper.ProjectBoardCardMapper;
import com.ruoyi.projectmanage.domain.ProjectBoardCard;
import com.ruoyi.projectmanage.service.IProjectBoardCardService;
import com.ruoyi.common.core.text.Convert;

/**
 * 板卡扩容工程管理模板Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
@Service
public class ProjectBoardCardServiceImpl implements IProjectBoardCardService 
{
    @Autowired
    private ProjectBoardCardMapper projectBoardCardMapper;

    /**
     * 查询板卡扩容工程管理模板
     * 
     * @param id 板卡扩容工程管理模板ID
     * @return 板卡扩容工程管理模板
     */
    @Override
    public ProjectBoardCard selectProjectBoardCardById(String id)
    {
        return projectBoardCardMapper.selectProjectBoardCardById(id);
    }

    /**
     * 查询板卡扩容工程管理模板列表
     * 
     * @param projectBoardCard 板卡扩容工程管理模板
     * @return 板卡扩容工程管理模板
     */
    @Override
    public List<ProjectBoardCard> selectProjectBoardCardList(ProjectBoardCard projectBoardCard)
    {
        return projectBoardCardMapper.selectProjectBoardCardList(projectBoardCard);
    }

    /**
     * 新增板卡扩容工程管理模板
     * 
     * @param projectBoardCard 板卡扩容工程管理模板
     * @return 结果
     */
    @Override
    public int insertProjectBoardCard(ProjectBoardCard projectBoardCard)
    {
        return projectBoardCardMapper.insertProjectBoardCard(projectBoardCard);
    }

    /**
     * 修改板卡扩容工程管理模板
     * 
     * @param projectBoardCard 板卡扩容工程管理模板
     * @return 结果
     */
    @Override
    public int updateProjectBoardCard(ProjectBoardCard projectBoardCard)
    {
        return projectBoardCardMapper.updateProjectBoardCard(projectBoardCard);
    }

    /**
     * 删除板卡扩容工程管理模板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectBoardCardByIds(String ids)
    {
        return projectBoardCardMapper.deleteProjectBoardCardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除板卡扩容工程管理模板信息
     * 
     * @param id 板卡扩容工程管理模板ID
     * @return 结果
     */
    @Override
    public int deleteProjectBoardCardById(String id)
    {
        return projectBoardCardMapper.deleteProjectBoardCardById(id);
    }
}
