package com.ruoyi.web.controller;

import com.netgao.sms.protocol.Session;
import com.netgao.sms.protocol.smgp.SMGPConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MsgSendService {
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
            for(int i = 0; i < phones.length; i++) {
                session.submit(content, spNumber, phones[i]);
            }

        }


    }
}
