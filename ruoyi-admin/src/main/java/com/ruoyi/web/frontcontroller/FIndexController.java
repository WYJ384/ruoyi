package com.ruoyi.web.frontcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/f/fIndexController")
public class FIndexController {


    @GetMapping("/index")
    public String index(){

        return "/front/index" ;
    }

}
