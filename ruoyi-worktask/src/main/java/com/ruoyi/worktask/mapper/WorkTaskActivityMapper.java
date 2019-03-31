package com.ruoyi.worktask.mapper;

import com.ruoyi.worktask.domain.WorkTaskActivity;
import java.util.List;

/**
 * 专项工作汇报内容 数据层
 *
 * @author ruoyi
 * @date 2019-03-26
 */
public interface WorkTaskActivityMapper
{
	/**
     * 查询专项工作汇报内容信息
     *
     * @param id 专项工作汇报内容ID
     * @return 专项工作汇报内容信息
     */
	public WorkTaskActivity selectWorkTaskActivityById(String id);

	/**
     * 查询专项工作汇报内容列表
     *
     * @param workTaskActivity 专项工作汇报内容信息
     * @return 专项工作汇报内容集合
     */
	public List<WorkTaskActivity> selectWorkTaskActivityList(WorkTaskActivity workTaskActivity);

	/**
     * 新增专项工作汇报内容
     *
     * @param workTaskActivity 专项工作汇报内容信息
     * @return 结果
     */
	public int insertWorkTaskActivity(WorkTaskActivity workTaskActivity);

	/**
     * 修改专项工作汇报内容
     *
     * @param workTaskActivity 专项工作汇报内容信息
     * @return 结果
     */
	public int updateWorkTaskActivity(WorkTaskActivity workTaskActivity);

	/**
     * 删除专项工作汇报内容
     *
     * @param id 专项工作汇报内容ID
     * @return 结果
     */
	public int deleteWorkTaskActivityById(String id);

	/**
     * 批量删除专项工作汇报内容
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWorkTaskActivityByIds(String[] ids);

	/**
	 * 查询部门下的主任
	 * @param deptId
	 * @return
	 */
	List<String> selectPostByDept(Long deptId);

}
