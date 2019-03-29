package com.ruoyi.web.controller.system;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ActivityDemoServiceImpl {

    /**
     * 更改业务流程状态#{ActivityDemoServiceImpl.updateBizStatus(execution,"tj")}
     * @param execution
     * @param status
     */
    public void updateBizStatus(DelegateExecution execution, String status) {
        String bizId = execution.getProcessBusinessKey();
        //根据业务id自行处理业务表
        System.out.println("业务表["+bizId+"]状态更改成功，状态更改为："+status);
    }

    //流程节点权限用户列表${ActivityDemoServiceImpl.findUsers(execution,sign)}
    public List<String> findUsersForSL(DelegateExecution execution){
        //return Arrays.asList("sly1","sly2");
        return Arrays.asList("马忠义");
    }

    //流程节点权限用户列表${ActivityDemoServiceImpl.findUsers(execution,sign)}
    public List<String> findUsersForSP(DelegateExecution execution){
        return Arrays.asList("uspy2");
    }

}
