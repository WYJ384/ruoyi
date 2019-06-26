package com.ruoyi.web.controller.exam;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.exam.domain.Exam;
import com.ruoyi.exam.domain.LibraryDetail;
import com.ruoyi.exam.domain.PaperQuestion;
import com.ruoyi.exam.service.IExamService;
import com.ruoyi.exam.service.ILibraryDetailService;
import com.ruoyi.exam.service.IPaperQuestionService;
import com.ruoyi.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.exam.domain.Result;
import com.ruoyi.exam.service.IResultService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 考试成绩 信息操作处理
 *
 * @author ruoyi
 * @date 2019-06-26
 */
@Controller
@RequestMapping("/exam/result")
public class ResultController extends BaseController {
    private String prefix = "exam/result";
    @Autowired
    private ILibraryDetailService libraryDetailService;
    @Autowired
    private IResultService resultService;
    @Autowired
    private IExamService examService;
    @Autowired
    private IPaperQuestionService paperQuestionService;
    @RequiresPermissions("exam:result:view")
    @GetMapping()
    public String result() {
        return prefix + "/result";
    }

    /**
     * 查询考试成绩列表
     */
    @RequiresPermissions("exam:result:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Result result) {
        startPage();
        List<Result> list = resultService.selectResultList(result);
        return getDataTable(list);
    }


    /**
     * 导出考试成绩列表
     */
    @RequiresPermissions("exam:result:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Result result) {
        List<Result> list = resultService.selectResultList(result);
        ExcelUtil<Result> util = new ExcelUtil<Result>(Result.class);
        return util.exportExcel(list, "result");
    }

    /**
     * 新增考试成绩
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存考试成绩
     */
    @RequiresPermissions("exam:result:add")
    @Log(title = "考试成绩", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Result result, HttpServletRequest request,String examId) {
        Exam exam = examService.selectExamById(examId);
        String strResult = "";
        Map<String, String[]> parameterMap = request.getParameterMap();
        Double score=0D;
        int i=0;
        for (String key : parameterMap.keySet()) {
            LibraryDetail libraryDetail = libraryDetailService.selectLibraryDetailById(key);
            if(libraryDetail==null){
                continue;
            }
            //试题答案
            String answer = libraryDetail.getAnswer();
            //用户答案
            String userAnswer = StringUtils.join(parameterMap.get(key));

            if(answer.equals(userAnswer)){
                PaperQuestion paperQuestion=new PaperQuestion();
                paperQuestion.setQuestionId(key);
                paperQuestion.setExamPaperId(exam.getExamPaperId());
                List<PaperQuestion> paperQuestions = paperQuestionService.selectPaperQuestionList(paperQuestion);
                PaperQuestion question = paperQuestions.get(0);
                score+=Double.valueOf(question.getRemark4());
            }

            strResult+=key+":"+userAnswer;
            if(i<parameterMap.size()-2){
               strResult+=",";
            }
            i++;
        }
        result.setUserId(ShiroUtils.getUserId()+"");
        result.setCreateBy(ShiroUtils.getUserId()+"");
        result.setExamId(examId);
        result.setScore(score);
        result.setQuestionAnwser(strResult);
		resultService.insertResult(result);
        return toAjax(1);
    }

    /**
     * 修改考试成绩
     */
    @GetMapping("/edit/{examId}")
    public String edit(@PathVariable("examId") String examId, ModelMap mmap) {
        Result result = resultService.selectResultById(examId);
        mmap.put("result", result);
        return prefix + "/edit";
    }

    /**
     * 修改保存考试成绩
     */
    @RequiresPermissions("exam:result:edit")
    @Log(title = "考试成绩", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Result result) {
        return toAjax(resultService.updateResult(result));
    }

    /**
     * 删除考试成绩
     */
    @RequiresPermissions("exam:result:remove")
    @Log(title = "考试成绩", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(resultService.deleteResultByIds(ids));
    }

}
