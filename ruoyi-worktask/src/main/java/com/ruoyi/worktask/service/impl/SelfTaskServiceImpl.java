package com.ruoyi.worktask.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.worktask.domain.BasicFacilities;
import com.ruoyi.worktask.domain.BasicMaintenance;
import com.ruoyi.worktask.domain.Goodness;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.worktask.mapper.SelfTaskMapper;
import com.ruoyi.worktask.domain.SelfTask;
import com.ruoyi.worktask.service.ISelfTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * 任务 服务层实现
 *
 * @author ruoyi
 * @date 2019-05-08
 */
@Service
public class SelfTaskServiceImpl implements ISelfTaskService {
    @Autowired
    private SelfTaskMapper selfTaskMapper;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysDeptService sysDeptService;
    /**
     * 查询任务信息
     *
     * @param id 任务ID
     * @return 任务信息
     */
    @Override
    public SelfTask selectSelfTaskById(String id) {
        return selfTaskMapper.selectSelfTaskById(id);
    }

    @Override
    public Goodness selectGoodnessTaskById(String id) {

        return selfTaskMapper.selectGoodnessTaskById(id);
    }

    /**
     * 查询任务列表
     *
     * @param selfTask 任务信息
     * @return 任务集合
     */
    @Override
    public List<SelfTask> selectSelfTaskList(SelfTask selfTask) {
        return selfTaskMapper.selectSelfTaskList(selfTask);
    }

    @Override
    public List<Goodness> goodnessTaskList(Goodness goodness) {

        return selfTaskMapper.goodnessTaskList(goodness);
    }

    /**
     * 新增任务
     *
     * @param selfTask 任务信息
     * @return 结果
     */
    @Override
    public int insertSelfTask(SelfTask selfTask) {
        return selfTaskMapper.insertSelfTask(selfTask);
    }

    /**
     * 修改任务
     *
     * @param selfTask 任务信息
     * @return 结果
     */
    @Override
    public int updateSelfTask(SelfTask selfTask) {
        return selfTaskMapper.updateSelfTask(selfTask);
    }

    /**
     * 删除任务对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSelfTaskByIds(String ids) {
        return selfTaskMapper.deleteSelfTaskByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<BasicMaintenance> basicmaintenanceTaskList(BasicMaintenance selfTask) {
        return selfTaskMapper.basicmaintenanceTaskList(selfTask);
    }

    @Override
    public BasicMaintenance selectBasicMaintenanceTaskById(String id) {
        return selfTaskMapper.selectBasicMaintenanceTaskById(id);
    }

    @Override
    public String importGoodness(List<Goodness> goodnessList, String operName) {
        if (StringUtils.isNull(goodnessList) || goodnessList.size() == 0) {
            throw new BusinessException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Goodness goodness : goodnessList) {

            SelfTask selfTask = new SelfTask();
            try {
                goodness.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                goodness.setCreateBy(operName);
                goodness.setCreateTime(new Date());
                goodness.setStartDate(new Date());
                BeanUtils.copyProperties(goodness, selfTask);
                selfTask.setSelvalTaskType("3");
                selfTask.setTaskStatus("0");
                String remark2 = selfTask.getRemark2();//责任部门
                SysDept dept=new SysDept();
                dept.setDeptName(remark2);
                List<SysDept> sysDepts = sysDeptService.selectDeptList(dept);
                if(sysDepts!=null&&sysDepts.size()>0){
                    selfTask.setRemark2(sysDepts.get(0).getDeptId()+"");
                }
//                String remark3=selfTask.getRemark3();//配合部门
//                dept=new SysDept();
//                dept.setDeptName(remark3);
//                sysDepts = sysDeptService.selectDeptList(dept);
//                if(sysDepts!=null&&sysDepts.size()>0){
//                    selfTask.setRemark3(sysDepts.get(0).getDeptId()+"");
//                }
                /** 任务执行人 */
                String executorUser=selfTask.getExecutorUser();
                if(StringUtils.isNotEmpty(executorUser)){
                    selfTask.setRemark(executorUser.replaceAll(";",","));
                }
                selfTask.setExecutorUser(getUserIds(executorUser));
                /** 任务验收人 */
                 String acceptorUser=selfTask.getAcceptorUser();
                 selfTask.setAcceptorUser(getUserId(acceptorUser));
                int i = selfTaskMapper.insertSelfTask(selfTask);
                if (i > 0) {
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据 " + goodness.getTaskTitle() + " 导入成功");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、数据 " + goodness.getTaskTitle() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public String importBasicmaintenance(List<BasicMaintenance> basicMaintenanceList, String operName) {
        if (StringUtils.isNull(basicMaintenanceList) || basicMaintenanceList.size() == 0) {
            throw new BusinessException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BasicMaintenance basicMaintenance : basicMaintenanceList) {

            SelfTask selfTask = new SelfTask();
            try {
                basicMaintenance.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                basicMaintenance.setCreateBy(operName);
                basicMaintenance.setCreateTime(new Date());
                basicMaintenance.setStartDate(new Date());
                BeanUtils.copyProperties(basicMaintenance, selfTask);
                selfTask.setSelvalTaskType("4");
                selfTask.setTaskStatus("0");

                String remark2 = selfTask.getRemark2();//责任部门
                if(StringUtils.isEmpty(remark2)){
                    continue;
                }
                SysDept dept=new SysDept();
                dept.setDeptName(remark2);
                List<SysDept> sysDepts = sysDeptService.selectDeptList(dept);
                if(sysDepts!=null&&sysDepts.size()>0){
                    selfTask.setRemark2(sysDepts.get(0).getDeptId()+"");
                }
                /** 任务执行人 */
                String executorUser=selfTask.getExecutorUser();
                if(StringUtils.isNotEmpty(executorUser)){
                    selfTask.setRemark(executorUser.replaceAll(";",","));
                }
                selfTask.setExecutorUser(getUserIds(executorUser));
                /** 任务验收人 */
                String acceptorUser=selfTask.getAcceptorUser();
                selfTask.setAcceptorUser(getUserId(acceptorUser));
                int i = selfTaskMapper.insertSelfTask(selfTask);
                if (i > 0) {
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据 " + basicMaintenance.getTaskTitle() + " 导入成功");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、数据 " + basicMaintenance.getTaskTitle() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public String importBasicFacilities(List<BasicFacilities> basicFacilitiesList, String operName) {
        return null;
    }

    @Override
    public List<BasicFacilities> basicfacilitiesTaskList(BasicFacilities selfTask) {
        return selfTaskMapper.basicFacilitiesTaskList(selfTask);
    }

    @Override
    public BasicFacilities selectBasicFacilitiesTaskById(String id) {
        return selfTaskMapper.selectBasicFacilitiesTaskById(id);
    }

    private String getUserId(String userName) {
        if(StringUtils.isNotEmpty(userName)){
            SysUser sysUser=new SysUser();
            sysUser.setUserName(userName);
            List<SysUser> sysUsers = sysUserService.selectUserList(sysUser);
            if(sysUsers!=null&&sysUsers.size()>0){
                Long userId = sysUsers.get(0).getUserId();
                return userId+"";
            }
        }
        return null;
    }

    private String getUserIds(String userNames){
        if(StringUtils.isNotEmpty(userNames)){
            String[] executorUsers = userNames.split(";");
            String userIds="";
            for(String userName:executorUsers){
                SysUser sysUser=new SysUser();
                sysUser.setUserName(userName);
                List<SysUser> sysUsers = sysUserService.selectUserList(sysUser);
                if(sysUsers!=null&&sysUsers.size()>0){
                    Long userId = sysUsers.get(0).getUserId();
                    userIds+=userId+",";
                }
            }
            return userIds;
        }
       return null;
    }
}
