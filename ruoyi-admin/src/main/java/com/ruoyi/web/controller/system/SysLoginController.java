package com.ruoyi.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruoyi.bbs.domain.Section;
import com.ruoyi.bbs.service.ISectionService;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.knowledge.domain.CmsCategory;
import com.ruoyi.knowledge.service.ICmsCategoryService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.MsgSendService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@Controller
public class SysLoginController extends BaseController
{
    @Autowired
    private MsgSendService msgSendService;
    @Autowired
    private ISysUserService userService;


    @Autowired
    private SysPasswordService passwordService;
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }
    @Autowired
    private ICmsCategoryService cmsCategoryService;
    @Autowired
    private ISectionService sectionService;
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe, HttpSession session)
    {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            SysUser sysUser = ShiroUtils.getSysUser();
            session.setAttribute("sysUser",sysUser);

            CmsCategory cmsCategory = new CmsCategory();
            cmsCategory.setDelFlag("0");
            cmsCategory.setInMenu("0");
            List<CmsCategory> cmsCategories = cmsCategoryService.selectCmsCategoryList(cmsCategory);
            Section section=new Section();
            List<Section> sections = sectionService.selectSectionList(section);
            session.setAttribute("sections",sections);
            session.setAttribute("cmsCategories",cmsCategories);

            return success();
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "/error/unauth";
    }

    @GetMapping("/forget")
    public String forget(HttpServletRequest request, HttpServletResponse response)
    {
        return "forget";
    }

    @PostMapping("/genVerifyNo")
    @ResponseBody
    public AjaxResult genVerifyNo(HttpServletRequest request, HttpServletResponse response, String phone)
    {

        SysUser sysUser = userService.selectUserByPhoneNumber(phone);
        if(sysUser==null){
            return AjaxResult.error("手机号错误");
        }else{
            HttpSession session = request.getSession();
            int random =(int)((Math.random()*9+1)*100000);
            session.setAttribute("verifyNo",random);
            msgSendService.send("办公系统验证码:"+random,new String[]{sysUser.getPhonenumber()});
        }
       return AjaxResult.success("验证码已发送到您手机上");
    }
    @PostMapping("/forgetReset")
    @ResponseBody
    public AjaxResult forgetReset(HttpServletRequest request, HttpServletResponse response,String verifyNo,String phone)
    {
        HttpSession session = request.getSession();
        if(session.getAttribute("verifyNo")==null){
            AjaxResult.error("发送异常");
        }else{
            String sysverifyNo = ((Integer) session.getAttribute("verifyNo")).toString();
            if(sysverifyNo.equals(verifyNo)){
                SysUser user = userService.selectUserByPhoneNumber(phone);
                if(user==null){
                    return AjaxResult.error("手机号错误");
                }
                int random =(int)((Math.random()*9+1)*100000);
                String password="gsnoc@"+random;
                user.setSalt(ShiroUtils.randomSalt());
                user.setPassword(passwordService.encryptPassword(user.getLoginName(), password, user.getSalt()));
                AjaxResult ajaxResult = toAjax(userService.resetUserPwd(user));
                session.setAttribute("verifyNo","");
                msgSendService.send("您的密码重置为："+password,new String[]{user.getPhonenumber()});
                return ajaxResult;
            }else {
                return AjaxResult.error("验证码错误");
            }
        }
        return AjaxResult.success();
    }

}
