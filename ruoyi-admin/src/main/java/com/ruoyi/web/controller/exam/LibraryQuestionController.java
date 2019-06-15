package com.ruoyi.web.controller.exam;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.exam.domain.Library;
import com.ruoyi.exam.domain.LibraryQuestion;
import com.ruoyi.exam.domain.MultChoice;
import com.ruoyi.exam.domain.SingleChoice;
import com.ruoyi.exam.service.ILibraryService;
import com.ruoyi.exam.service.IMultChoiceService;
import com.ruoyi.exam.service.ISingleChoiceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exam/libraryQuestion")
public class LibraryQuestionController extends BaseController {
    private String prefix = "exam/libraryQuestion";
    private String singleChoicePrefix = "exam/singleChoice";
    private String multChoiceServicePrefix = "exam/multChoice";

    @Autowired
    private IMultChoiceService multChoiceService;
    @Autowired
    private ISingleChoiceService singleChoiceService;
    @Autowired
    private ILibraryService libraryService;

    /**
     * 查询试题库列表
     */
    @RequiresPermissions("exam:library:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LibraryQuestion libraryQuestion) {
        startPage();
        List<LibraryQuestion> list = libraryService.selectLibraryQuestionList(libraryQuestion);
        return getDataTable(list);
    }

    /**
     * 新增试题库
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap mmap) {
        Library library = libraryService.selectLibraryById(id);
        mmap.addAttribute("library", library);
        return prefix + "/add";
    }

    /**
     * 修改试题库
     */
    @GetMapping("/edit/{id}/{type}")
    public String edit(@PathVariable("id") String id, @PathVariable("type") String type, ModelMap mmap) {
        if (type.equals("单选题")) {
            SingleChoice singleChoice = singleChoiceService.selectSingleChoiceById(id);
            mmap.put("singleChoice", singleChoice);
            return singleChoicePrefix + "/edit";
        } else if (type.equals("多选题")) {
            MultChoice multChoice = multChoiceService.selectMultChoiceById(id);
            mmap.put("multChoice", multChoice);
            return multChoiceServicePrefix + "/edit";
        }
        return prefix + "/edit";
    }

    /**
     * 修改试题库
     */
    @PostMapping("/remove/{id}/{type}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") String id, @PathVariable("type") String type, ModelMap mmap) {
        if (type.equals("单选题")) {
            toAjax(singleChoiceService.deleteSingleChoiceByIds(id));
        } else if (type.equals("多选题")) {
            toAjax(multChoiceService.deleteMultChoiceByIds(id));
        }
        return toAjax(1);
    }
}
