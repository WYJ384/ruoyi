package com.ruoyi.web.controller;

import com.netgao.sms.protocol.Session;
import com.netgao.sms.protocol.smgp.SMGPConnection;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysNoticeService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@Service
public class MsgSendService {
    @Autowired
    private ISysNoticeService noticeService;
    @Autowired
    private ISysUserService userService;
    @Value("${msg.clientId}")
    private String clientId;
    @Value("${msg.password}")
    private String password;
    @Value("${msg.host}")
    private String host;
    @Value("${msg.port}")
    private Integer port;
    @Value("${msg.spNumber}")
    private String spNumber;
    public void send(String content,String[] phones){
        System.out.println("短信内容"+content+ "号码："+Arrays.toString(phones));
        SMGPConnection conn = new SMGPConnection();
        conn.setClientId(clientId);
        conn.setPassword(password);
        conn.setVersion((byte) 0);
        conn.setAutoReconnect(true);
        conn.setSendInterval(200);
        try {
            conn.connect(host, port);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(conn.isConnected()){
            Session session = conn.getSession();
            long startTime = System.currentTimeMillis();
            try{
                for(int i = 0; i < phones.length; i++) {
                    session.submit(content, spNumber, phones[i]);
                    SysUser sysUser = userService.selectUserByPhoneNumber(phones[i]);
                    if(sysUser!=null){
                        SysNotice notice=new SysNotice();
                        notice.setNoticeContent(content);
                        notice.setCreateTime(new Date());
                        notice.setDisplayUser(sysUser.getUserId()+"");
                        insertNotice(notice);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    session.close();
                    conn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }


    }
    public void insertNotice(SysNotice notice){
        notice.setCreateBy(ShiroUtils.getUserId()+"");
        notice.setRemark(ShiroUtils.getSysUser().getUserName());
        noticeService.insertNotice(notice);
    }
}
