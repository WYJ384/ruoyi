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

        article=new Article();
        article.setCategoryId("fd260cf5199b4d4191fa44693ce71ba7");
        startPage(1,6,"hits desc");
        List<Article> yunArticle = articleService.selectArticleList(article);
        modelMap.addAttribute("yunArticle",yunArticle);


        article=new Article();
        article.setCategoryId("01f53126cda445d1a48ab3e3abf264f8");
        startPage(1,6,"hits desc");
        List<Article> chuanshuArticle = articleService.selectArticleList(article);
        modelMap.addAttribute("chuanshuArticle",chuanshuArticle);


        article=new Article();
        article.setCategoryId("2e841af613aa4e4292a24d9e6bd25c74");
        startPage(1,6,"hits desc");
        List<Article> shujuArticle = articleService.selectArticleList(article);
        modelMap.addAttribute("shujuArticle",shujuArticle);
        article=new Article();
        article.setCategoryId("3205c97eab044e62a27b45276b74a1c0");
        startPage(1,6,"hits desc");
        List<Article> iptvArticle = articleService.selectArticleList(article);
        modelMap.addAttribute("iptvArticle",iptvArticle);

        return "/front/index" ;
    }

}
