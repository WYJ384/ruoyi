package com.ruoyi.framework.aspectj;


import com.ruoyi.common.annotation.DataFilter;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 数据过滤，切面处理类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017年10月23日 下午13:33:35
 */
@Aspect
@Component
public class DataFilterAspect {


    /**
     * 切点
     */
    @Pointcut("@annotation(com.ruoyi.common.annotation.DataFilter)")
    public void dataFilterCut() {

    }

    /**
     * 前置通知
     *
     * @param point 连接点
     */
    @Before("dataFilterCut()")
    public void dataFilter(JoinPoint point) {
        //获取参数
        Object params = point.getArgs()[0];
        // 获取当前的用户
        SysUser currentUser = ShiroUtils.getSysUser();
        if (currentUser != null) {
            // 如果是超级管理员，则不过滤数据
            if (!currentUser.isAdmin()) {
                String filterSQL = getFilterSQL(currentUser, point);
                if (com.ruoyi.common.utils.StringUtils.isNotBlank(filterSQL))
                {
                    BaseEntity baseEntity = (BaseEntity) point.getArgs()[0];
                    baseEntity.getParams().put("filterSql", filterSQL);
                    System.out.println(baseEntity.getParams());
                }
            }
        }
    }

    /**
     * 获取数据过滤的SQL
     *
     * @param user  登录用户
     * @param point 连接点
     * @return sql
     */
    private String getFilterSQL(SysUser user, JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataFilter dataFilter = signature.getMethod().getAnnotation(DataFilter.class);

        String userAlias = dataFilter.userAlias();
        String deptAlias = dataFilter.deptAlias();

        StringBuilder filterSql = new StringBuilder();
        filterSql.append(" and ( ");
        if (StringUtils.isNotEmpty(deptAlias) || StringUtils.isNotBlank(userAlias)) {
            if (StringUtils.isNotBlank(userAlias)) {
                //没有部门数据权限，也能查询本人数据
                filterSql.append(userAlias);
                filterSql.append(" = ");
                filterSql.append(user.getLoginName());
                filterSql.append(" ");
            }
        } else {
            return "";
        }
        filterSql.append(" ) ");
        return filterSql.toString();
    }

    /**
     * 取出用户权限
     *
     * @param userId 登录用户Id
     * @return 权限
     */
    private String getAliasByUser(Long userId) {
        @SuppressWarnings("unchecked")
//        List<Long> roleOrglist = sysRoleDeptService.queryDeptIdListByUserId(userId);
                StringBuilder roleStr = new StringBuilder();
        String alias = "";
//        if (roleOrglist != null && !roleOrglist.isEmpty()) {
//            for (Long roleId : roleOrglist) {
//                roleStr.append(",");
//                roleStr.append("'");
//                roleStr.append(roleId);
//                roleStr.append("'");
//            }
//            alias = roleStr.toString().substring(1, roleStr.length());
//        }
        return alias;
    }
}
