package com.ruoyi.projectmanage.service;

import com.ruoyi.projectmanage.domain.ProjectBoardCard;
import java.util.List;

/**
 * 板卡扩容工程管理模板Service接口
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
public interface IProjectBoardCardService 
{
    /**
     * 查询板卡扩容工程管理模板
     * 
     * @param id 板卡扩容工程管理模板ID
     * @return 板卡扩容工程管理模板
     */
    public ProjectBoardCard selectProjectBoardCardById(String id);

    /**
     * 查询板卡扩容工程管理模板列表
     * 
     * @param projectBoardCard 板卡扩容工程管理模板
     * @return 板卡扩容工程管理模板集合
     */
    public List<ProjectBoardCard> selectProjectBoardCardList(ProjectBoardCard projectBoardCard);

    /**
     * 新增板卡扩容工程管理模板
     * 
     * @param projectBoardCard 板卡扩容工程管理模板
     * @return 结果
     */
    public int insertProjectBoardCard(ProjectBoardCard projectBoardCard);

    /**
     * 修改板卡扩容工程管理模板
     * 
     * @param projectBoardCard 板卡扩容工程管理模板
     * @return 结果
     */
    public int updateProjectBoardCard(ProjectBoardCard projectBoardCard);

    /**
     * 批量删除板卡扩容工程管理模板
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectBoardCardByIds(String ids);

    /**
     * 删除板卡扩容工程管理模板信息
     * 
     * @param id 板卡扩容工程管理模板ID
     * @return 结果
     */
    public int deleteProjectBoardCardById(String id);
}
