package com.ruoyi.web.frontcontroller;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.sql.SqlUtil;
import com.ruoyi.knowledge.domain.CmsCategory;
import com.ruoyi.knowledge.service.ICmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.util.List;

@Controller
public class FBaseController {
    @Autowired
    private ICmsCategoryService cmsCategoryService;
    protected void getMenu(ModelMap modelMap)
    {
        CmsCategory cmsCategory = new CmsCategory();
        cmsCategory.setDelFlag("0");
        cmsCategory.setInMenu("0");
        List<CmsCategory> cmsCategories = cmsCategoryService.selectCmsCategoryList(cmsCategory);
        modelMap.addAttribute("cmsCategories",cmsCategories);
    }
}
