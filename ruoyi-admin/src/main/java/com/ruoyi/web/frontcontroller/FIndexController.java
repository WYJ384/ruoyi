package com.ruoyi.web.frontcontroller;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.utils.sql.SqlUtil;
import com.ruoyi.knowledge.domain.Article;
import com.ruoyi.knowledge.domain.CmsCategory;
import com.ruoyi.knowledge.service.IArticleService;
import com.ruoyi.knowledge.service.ICmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/f/fIndexController")
public class FIndexController extends FBaseController{

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ICmsCategoryService cmsCategoryService;
    @GetMapping("/index")
    public String index(ModelMap modelMap){
        getMenu(modelMap);
        Article article=new Article();
        //热门知识
        startPage(1,6,"hits desc");
        List<Article> hotArticles = articleService.selectArticleList(article);
        modelMap.addAttribute("hotArticles",hotArticles);
        return "/front/index" ;
    }

}
