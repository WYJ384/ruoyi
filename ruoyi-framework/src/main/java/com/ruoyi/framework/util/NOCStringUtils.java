package com.ruoyi.framework.util;

import java.util.UUID;

public class NOCStringUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
