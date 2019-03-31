package com.ruoyi.worktask.service;

import com.ruoyi.worktask.domain.WorkTaskActivity;
import java.util.List;

/**
 * 专项工作汇报内容 服务层
 *
 * @author ruoyi
 * @date 2019-03-26
 */
public interface IWorkTaskActivityService
{
	/**
     * 查询专项工作汇报内容信息
     *
     * @param id 专项工作汇报内容ID
     * @return 专项工作汇报内容信息
     */
	public WorkTaskActivity selectWorkTaskActivityById(String id);

	public WorkTaskActivity selectWorkTaskActivityByProId(String proId);


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
     * 删除专项工作汇报内容信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWorkTaskActivityByIds(String ids);

	/**
	 * 查询部门下的主任
	 * @param deptId
	 * @return
	 */


}
