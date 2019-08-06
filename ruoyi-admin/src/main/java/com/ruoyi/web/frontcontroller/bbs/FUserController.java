package com.ruoyi.web.frontcontroller.bbs;

import com.ruoyi.bbs.domain.Topic;
import com.ruoyi.web.frontcontroller.FBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/f/bbs/user")
public class FUserController extends FBaseController {
    private String prefix = "front/bbs/user";
    @GetMapping("/set")
    public String set(ModelMap modelMap)
    {
        modelMap.addAttribute("currUrl","set");
        return prefix + "/set";
    }
    @GetMapping("/message")
    public String message(ModelMap modelMap)
    {
        modelMap.addAttribute("currUrl","message");
        return prefix + "/message";
    }
    @GetMapping("/home")
    public String home(ModelMap modelMap)
    {
        modelMap.addAttribute("currUrl","home");
        return prefix + "/home";
    }
    @GetMapping("/index")
    public String index(ModelMap modelMap)
    {
        modelMap.addAttribute("currUrl","index");
        return prefix + "/index";
    }
}
