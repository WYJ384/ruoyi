package com.ruoyi.web.controller.taskscore;

import java.util.*;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.taskscore.domain.*;
import com.ruoyi.taskscore.service.IScoreActivityDetailService;
import com.ruoyi.taskscore.service.IScoringPointerService;
import org.apache.commons.lang3.time.DateFormatUtils;
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
import com.ruoyi.taskscore.service.IScoreActivityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 评分活动 信息操作处理
 *
 * @author ruoyi
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/taskscore/scoreActivity")
public class ScoreActivityController extends BaseController {
    private String prefix = "taskscore/scoreActivity";

    @Autowired
    private IScoreActivityService scoreActivityService;
    @Autowired
    private IScoringPointerService scoringPointerService;

    @Autowired
    private IScoreActivityDetailService scoreActivityDetailService;

    @RequiresPermissions("taskscore:scoreActivity:view")
    @GetMapping()
    public String scoreActivity() {
        return prefix + "/scoreActivity";
    }

    /**
     * 查询评分活动列表
     */
    @RequiresPermissions("taskscore:scoreActivity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ScoreActivity scoreActivity) {
        startPage();
        List<ScoreActivity> list = scoreActivityService.selectScoreActivityList(scoreActivity);
        Iterator<ScoreActivity> activityIterator = list.iterator();
        while (activityIterator.hasNext()) {
            ScoreActivity activity = activityIterator.next();
            Double scoreSum = 0D;
            String activityId = activity.getId();
            ScoreActivityDetail activityDetail = new ScoreActivityDetail();
            activityDetail.setActivityId(activityId);
            List<ScoreActivityDetail> scoreActivityDetails = scoreActivityDetailService.selectScoreActivityDetailList(activityDetail);
            Iterator<ScoreActivityDetail> detailIterator = scoreActivityDetails.iterator();
            while (detailIterator.hasNext()) {
                ScoreActivityDetail detail = detailIterator.next();
                Double score = detail.getScore();
                if (score != null) {
                    scoreSum += score;
                }
            }
            activity.setRemark(scoreSum + "");
        }
        return getDataTable(list);
    }


    /**
     * 导出评分活动列表
     */
    @RequiresPermissions("taskscore:scoreActivity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScoreActivity scoreActivity) {
        List<ScoreActivity> list = scoreActivityService.selectScoreActivityList(scoreActivity);
        ExcelUtil<ScoreActivity> util = new ExcelUtil<ScoreActivity>(ScoreActivity.class);
        return util.exportExcel(list, "scoreActivity");
    }

    /**
     * 新增评分活动
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存评分活动
     */
    @RequiresPermissions("taskscore:scoreActivity:add")
    @Log(title = "评分活动", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ScoreActivity scoreActivity) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        scoreActivity.setId(uuid);
        scoreActivity.setCreateBy(ShiroUtils.getLoginName());
        scoreActivity.setCreateTime(new Date());
        String deptId = scoreActivity.getScoringPointerId();
        ScoringPointer scoringPointer = new ScoringPointer();
        scoringPointer.setDeptId(deptId);
        List<ScoringPointer> scoringPointers = scoringPointerService.selectScoringPointerList(scoringPointer);
        if (scoringPointers.isEmpty()) {
            return AjaxResult.error(1, "请为该部门添加评分指标");
        }
        Iterator<ScoringPointer> scoringPointerIterator = scoringPointers.iterator();
        while (scoringPointerIterator.hasNext()) {
            ScoringPointer pointer = scoringPointerIterator.next();
            ScoreActivityDetail scoreActivityDetail = new ScoreActivityDetail();
            scoreActivityDetail.setActivityId(uuid);
            scoreActivityDetail.setScorePointerId(pointer.getId());
            scoreActivityDetailService.insertScoreActivityDetail(scoreActivityDetail);
        }

        return toAjax(scoreActivityService.insertScoreActivity(scoreActivity));
    }

    /**
     * 修改评分活动
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        ScoreActivity scoreActivity = scoreActivityService.selectScoreActivityById(id);
        mmap.put("scoreActivity", scoreActivity);

        return prefix + "/edit";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, ModelMap mmap) {
        ScoreActivity scoreActivity = scoreActivityService.selectScoreActivityById(id);
        mmap.put("scoreActivity", scoreActivity);
        ScoreActivityDetail scoreActivityDetail = new ScoreActivityDetail();
        scoreActivityDetail.setActivityId(scoreActivity.getId());
        List<ScoreActivityDetail> scoreActivityDetails = scoreActivityDetailService.selectScoreActivityDetailList(scoreActivityDetail);
        mmap.put("scoreActivityDetails", scoreActivityDetails);
        return prefix + "/detail";
    }

    @GetMapping("/statistics")
    public String statistics(ModelMap mmap) {
        List<ScoreActivityVO> scoreActivityVOList=new ArrayList<ScoreActivityVO>();
        ScoreActivity scoreActivity = new ScoreActivity();
        scoreActivity.setBeginTime(DateFormatUtils.format(new Date(),"yyyy-MM"));
        List<ScoreActivity> scoreActivities = scoreActivityService.selectScoreActivityList(scoreActivity);
        Iterator<ScoreActivity> scoreActivityIterator = scoreActivities.iterator();
        while (scoreActivityIterator.hasNext()){
            ScoreActivity activity = scoreActivityIterator.next();
            ScoreActivityDetail scoreActivityDetail = new ScoreActivityDetail();
            scoreActivityDetail.setActivityId(activity.getId());
            ScoreActivityVO scoreActivityVO=new ScoreActivityVO();
            scoreActivityVO.setActivityId(activity.getId());
            ScoreDeptVO scoreDeptVO=new ScoreDeptVO();
            scoreDeptVO.setActivityId(activity.getId());
            List<ScoreDeptVO> deptMonthScore = scoreActivityDetailService.getDeptMonthScore(scoreDeptVO);
            Iterator<ScoreDeptVO> deptVOIterator = deptMonthScore.iterator();
            while (deptVOIterator.hasNext()){
                ScoreDeptVO deptVO = deptVOIterator.next();
                scoreActivityVO.setDeptName(deptVO.getDeptName());
                String pointerType = deptVO.getPointerType();
                if(StringUtils.isEmpty(pointerType)){
                    continue;
                }
                Double score = deptVO.getScore();
                if(score==null){
                    score=0D;
                }
                if(pointerType.equals("省公司考核得分")){
                    scoreActivityVO.setShenggongsikaohe(score);
                }else  if(pointerType.equals("总经理考核")){
                    scoreActivityVO.setZongjingliScore(score);
                }else  if(pointerType.equals("分管领导考核1")){
                    scoreActivityVO.setFenguanScore1(score);
                }else  if(pointerType.equals("分管领导考核2")){
                    scoreActivityVO.setFenguanScore2(score);
                }else  if(pointerType.equals("分管领导考核3")){
                    scoreActivityVO.setFenguanScore3(score);
                }else  if(pointerType.equals("省市一体化考核")){
                    scoreActivityVO.setShengshiyitihuaScore(score);
                }else  if(pointerType.equals("安全生产考核")){
                    scoreActivityVO.setAnquanshengchanScore(score);
                }else  if(pointerType.equals("政企支撑考核")){
                    scoreActivityVO.setZhengqizhicheng(score);
                }else  if(pointerType.equals("监控工单考核")){
                    scoreActivityVO.setJiankonggongdan(score);
                }else  if(pointerType.equals("党建工作考核")){
                    scoreActivityVO.setDangjiangongzuo(score);
                }else  if(pointerType.equals("网络安全考核")){
                    scoreActivityVO.setWangluoanquan(score);
                }else  if(pointerType.equals("资源融智")){
                    scoreActivityVO.setZiyuan(score);
                }else  if(pointerType.equals("基础维护管理提升")){
                    scoreActivityVO.setJichu(score);
                }else  if(pointerType.equals("总经理加扣分")){
                    scoreActivityVO.setZongjinglijiafen(score);
                }else  if(pointerType.equals("省公司月度考核")){
                    scoreActivityVO.setShenggongsiyuedukaohe(score);
                }
            }
//            scoreActivityVO.setTotalScore();
//
//            this.totalScore = shenggongsikaohe * (zongjingliScore*0.4 + fenguanScore1 + fenguanScore2 + fenguanScore3 +
//                    shengshiyitihuaScore + anquanshengchanScore + zhengqizhicheng + jiankonggongdan + dangjiangongzuo + wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
            getDeptScore(scoreActivityVO);
            scoreActivityVOList.add(scoreActivityVO);
        }

        mmap.addAttribute("scoreActivityVOList",scoreActivityVOList);
        mmap.addAttribute("month", DateFormatUtils.format(new Date(),"MM"));

        return prefix + "/statistics";
    }
    public void getDeptScore(ScoreActivityVO scoreActivityVO){
        Double shenggongsikaohe = scoreActivityVO.getShenggongsikaohe();
        Double shenggongsiyuedukaohe = scoreActivityVO.getShenggongsiyuedukaohe();
        Double zongjingliScore = scoreActivityVO.getZongjingliScore();
        Double anquanshengchanScore = scoreActivityVO.getAnquanshengchanScore();
        Double dangjiangongzuo = scoreActivityVO.getDangjiangongzuo();
        Double jiankonggongdan = scoreActivityVO.getJiankonggongdan();
        Double zhengqizhicheng = scoreActivityVO.getZhengqizhicheng();
        Double wangluoanquan = scoreActivityVO.getWangluoanquan();
        Double jichu = scoreActivityVO.getJichu();
        Double zongjinglijiafen = scoreActivityVO.getZongjinglijiafen();
        Double fenguanScore1 = scoreActivityVO.getFenguanScore1();
        if(fenguanScore1==null){
            fenguanScore1=0D;
        }
        Double fenguanScore2 = scoreActivityVO.getFenguanScore2();
        if(fenguanScore2==null){
            fenguanScore2=0D;
        }
        Double shengshiyitihuaScore = scoreActivityVO.getShengshiyitihuaScore();
        Double totalScore=0D;
        if(scoreActivityVO.getDeptName().equals("办公室")){
            totalScore = shenggongsikaohe * (zongjingliScore*0.4 + fenguanScore1*0.2 + fenguanScore2*0.2  +
                     anquanshengchanScore  + wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
        }else if(scoreActivityVO.getDeptName().equals("技术支撑部")){
            totalScore = shenggongsikaohe * (zongjingliScore*0.3 + fenguanScore1*0.2 + fenguanScore2*0.2  +
                    anquanshengchanScore +jiankonggongdan + wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
        }else if(scoreActivityVO.getDeptName().equals("移动业务运营部")){
            totalScore = shenggongsikaohe * (zongjingliScore*0.15 + fenguanScore1*0.15+shengshiyitihuaScore+anquanshengchanScore+zhengqizhicheng  +
                     +jiankonggongdan +dangjiangongzuo+ wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
        }else if(scoreActivityVO.getDeptName().equals("承载网络运营部")){
            totalScore = shenggongsikaohe * (zongjingliScore*0.3 + fenguanScore1*0.3 +anquanshengchanScore+zhengqizhicheng  +
                    +jiankonggongdan +dangjiangongzuo+ wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
        }else if(scoreActivityVO.getDeptName().equals("云与IDC运营部")){
            totalScore = shenggongsikaohe * (zongjingliScore*0.15 + fenguanScore1*0.15   +shengshiyitihuaScore+anquanshengchanScore+zhengqizhicheng  +
                    +jiankonggongdan +dangjiangongzuo+ wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
        }else if(scoreActivityVO.getDeptName().equals("政企支撑中心")){
            totalScore = shenggongsikaohe * (zongjingliScore*0.20 + fenguanScore1*0.20   +shengshiyitihuaScore+anquanshengchanScore  +
                    +jiankonggongdan +dangjiangongzuo+ wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
        }else if(scoreActivityVO.getDeptName().equals("监控调度部")){
            totalScore = shenggongsikaohe * (zongjingliScore*0.20 + fenguanScore1*0.20   +shengshiyitihuaScore+anquanshengchanScore+zhengqizhicheng  +
                     +dangjiangongzuo+ wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
        }else if(scoreActivityVO.getDeptName().equals("宽带与视频运营部")){
            totalScore = shenggongsikaohe * (zongjingliScore*0.30 + fenguanScore1*0.30 +anquanshengchanScore+zhengqizhicheng  +
                    +jiankonggongdan +dangjiangongzuo+ wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
        }else if(scoreActivityVO.getDeptName().equals("基础设施维护部")){
            totalScore = shenggongsikaohe * (zongjingliScore*0.40 + fenguanScore1*0.30 +anquanshengchanScore  +
                    +jiankonggongdan +dangjiangongzuo+ wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;
        }
        scoreActivityVO.setTotalScore(totalScore);
    }

    /**
     * 修改保存评分活动
     */
    @RequiresPermissions("taskscore:scoreActivity:edit")
    @Log(title = "评分活动", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ScoreActivity scoreActivity) {
        scoreActivity.setUpdateBy(ShiroUtils.getLoginName());
        scoreActivity.setUpdateTime(new Date());
        return toAjax(scoreActivityService.updateScoreActivity(scoreActivity));
    }

    /**
     * 删除评分活动
     */
    @RequiresPermissions("taskscore:scoreActivity:remove")
    @Log(title = "评分活动", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(scoreActivityService.deleteScoreActivityByIds(ids));
    }

}
