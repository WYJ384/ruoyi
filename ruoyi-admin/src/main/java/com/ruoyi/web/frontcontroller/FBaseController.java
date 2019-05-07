package com.ruoyi.web.frontcontroller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableDataInfo;
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
    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

}
