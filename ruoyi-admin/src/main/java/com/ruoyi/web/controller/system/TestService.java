package com.ruoyi.web.controller.system;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by m on 2019/3/29.
 */
@Service

public class TestService {

    public void activiti() {

        System.out.println("任务已经执行.....................................");
    }

    public List<String> user() {
        return Arrays.asList("admin", "15693120282");
    }
}