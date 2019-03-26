package com.ruoyi.web.controller.filemanager;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.web.core.config.RuoYiProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

/**
 * Created by m on 2019/3/26.
 */
@ControllerAdvice
@RequestMapping("/diskBoxController")
public class DiskBoxController {
    private String prefix = "/filemanager";
    @Autowired
    RuoYiProfile ruoYiProfile;
    private String root;
    @GetMapping("/toMyDiskBox")
    public String toMyDiskBox()
    {
        root=ruoYiProfile.getProfile()+ ShiroUtils.getLoginName();
        File file=new File(root);
        if(!file.exists()){
            file.mkdir();
        }
        return  prefix+"/myDiskBox";
    }
    @GetMapping("/toCommonBox")
    public String toCommonBox()
    {
        root=ruoYiProfile.getProfile()+ "commonbox";
        File file=new File(root);
        if(!file.exists()){
            file.mkdir();
        }
        return  prefix+"/commonBox";
    }
}
