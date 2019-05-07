package com.ruoyi.web.frontcontroller;

import com.ruoyi.common.core.domain.ZtreeExt;
import com.ruoyi.knowledge.domain.CmsCategory;
import com.ruoyi.knowledge.service.ICmsCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/f/knowledge/category")
public class FCategoryController {
    @Autowired
    private ICmsCategoryService cmsCategoryService;


    @GetMapping("/treeData")
    @ResponseBody
    public List<ZtreeExt> treeData()
    {
        List<ZtreeExt> ztrees = cmsCategoryService.selectCategoryTree(new CmsCategory());
        return ztrees;
    }

}
