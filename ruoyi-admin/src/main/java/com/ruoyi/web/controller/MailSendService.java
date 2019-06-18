package com.ruoyi.web.controller;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailSendService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private ISysUserService userService;
    @Value("${spring.mail.username}")
    private String mailUserName;
    /**
     * 发送单个邮件
     * @param to 邮件接受对象
     * @param subject 主题
     * @param text 邮件内容
     * @throws Exception
     */
    public void sendSimpleMail(String to,String subject,String text) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailUserName);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    /**
     * 批量发送邮件
     * @param simpleMailMessages
     * @throws Exception
     */
    public void sendSimpleMails(SimpleMailMessage[] simpleMailMessages) throws Exception {
        mailSender.send(simpleMailMessages);
    }

    /**
     * 登陆名逗号分隔发送邮件
     * @param loginNames
     * @param text
     * @throws Exception
     */
    public void sendSimpleMails(String loginNames,String text) throws Exception {
        String[] userArr = loginNames.split(",");
        List<SimpleMailMessage> simpleMailMessageList=new ArrayList<SimpleMailMessage>();
        for (int i = 0; i < userArr.length; i++) {
            String loginName=userArr[i];
            if(org.apache.commons.lang3.StringUtils.isNotEmpty(loginName)){
                SysUser sysUser = userService.selectUserByLoginName(loginName);
                if(sysUser!=null&& org.apache.commons.lang3.StringUtils.isNotEmpty(sysUser.getEmail())){
                    String userEmail = sysUser.getEmail();
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setFrom(mailUserName);
                    message.setTo(userEmail);
                    message.setSubject("NOC办公系统发送");
                    message.setText(text);
                    simpleMailMessageList.add(message);
                }
            }
        }
        SimpleMailMessage[] simpleMailMessages = new SimpleMailMessage[simpleMailMessageList.size()];
        simpleMailMessageList.toArray(simpleMailMessages);
        try {
           sendSimpleMails(simpleMailMessages);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户ID逗号分隔发送邮件
     * @param userIds
     * @param text
     * @throws Exception
     */
    public void sendSimpleMailsByUserIds(String userIds,String text) throws Exception {
        String[] userArr = userIds.split(",");
        List<SimpleMailMessage> simpleMailMessageList=new ArrayList<SimpleMailMessage>();
        for (int i = 0; i < userArr.length; i++) {
            String userId=userArr[i];
            if(org.apache.commons.lang3.StringUtils.isNotEmpty(userId)){
                SysUser sysUser = userService.selectUserById(Long.valueOf(userId));
                if(sysUser!=null&& org.apache.commons.lang3.StringUtils.isNotEmpty(sysUser.getEmail())){
                    String userEmail = sysUser.getEmail();
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setFrom(mailUserName);
                    message.setTo(userEmail);
                    message.setSubject("NOC办公系统发送");
                    message.setText(text);
                    simpleMailMessageList.add(message);
                }
            }
        }
        SimpleMailMessage[] simpleMailMessages = new SimpleMailMessage[simpleMailMessageList.size()];
        simpleMailMessageList.toArray(simpleMailMessages);
        try {
            sendSimpleMails(simpleMailMessages);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param userId
     * @param text
     */
    public void sendMailByUserId(String userId,String text){
        SysUser sysUser = userService.selectUserById(Long.valueOf(userId));
        if(sysUser!=null&& org.apache.commons.lang3.StringUtils.isNotEmpty(sysUser.getEmail())){
            try {
                sendSimpleMail(sysUser.getEmail(),"NOC办公系统发送",text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}

