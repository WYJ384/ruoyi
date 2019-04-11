package com.ruoyi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testController")
public class TestController {


    @RequestMapping("/toIndex")
    public String toIndex() {
        return "/ueditor";
    }
}
