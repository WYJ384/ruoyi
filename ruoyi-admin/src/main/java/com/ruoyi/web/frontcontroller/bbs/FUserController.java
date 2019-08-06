package com.ruoyi.web.frontcontroller.bbs;

import com.ruoyi.bbs.domain.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/f/bbs/user")
public class FUserController {
    private String prefix = "front/bbs/user";
    @GetMapping("/set")
    public String set(ModelMap modelMap)
    {
        return prefix + "/set";
    }
    @GetMapping("/message")
    public String message(ModelMap modelMap)
    {
        return prefix + "/message";
    }
    @GetMapping("/home")
    public String home(ModelMap modelMap)
    {
        return prefix + "/home";
    }
    @GetMapping("/index")
    public String index(ModelMap modelMap)
    {
        return prefix + "/index";
    }
}
