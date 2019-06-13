package com.ruoyi.web.controller.exam;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.exam.domain.LibraryQuestion;
import com.ruoyi.exam.service.ILibraryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/exam/libraryQuestion")
public class LibraryQuestionController extends BaseController {
    private String prefix = "exam/libraryQuestion";

    @Autowired
    private ILibraryService libraryService;
    /**
     * 查询试题库列表
     */
    @RequiresPermissions("exam:library:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LibraryQuestion libraryQuestion)
    {
        startPage();
        List<LibraryQuestion> list = libraryService.selectLibraryQuestionList(libraryQuestion);
        return getDataTable(list);
    }
    /**
     * 新增试题库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
}
