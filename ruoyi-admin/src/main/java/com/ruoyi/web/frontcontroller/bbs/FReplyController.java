package com.ruoyi.web.frontcontroller.bbs;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.framework.util.NOCStringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.web.frontcontroller.FBaseController;
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
import com.ruoyi.bbs.domain.Reply;
import com.ruoyi.bbs.service.IReplyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 跟帖 信息操作处理
 *
 * @author ruoyi
 * @date 2019-08-05
 */
@Controller
@RequestMapping("/f/bbs/reply")
public class FReplyController extends FBaseController {
    private String prefix = "bbs/reply";

    @Autowired
    private IReplyService replyService;

    @RequiresPermissions("bbs:reply:view")
    @GetMapping()
    public String reply() {
        return prefix + "/reply";
    }

    /**
     * 查询跟帖列表
     */
    @RequiresPermissions("bbs:reply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Reply reply) {
        startPage();
        List<Reply> list = replyService.selectReplyList(reply);
        return getDataTable(list);
    }


    /**
     * 导出跟帖列表
     */
    @RequiresPermissions("bbs:reply:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Reply reply) {
        List<Reply> list = replyService.selectReplyList(reply);
        ExcelUtil<Reply> util = new ExcelUtil<Reply>(Reply.class);
        return util.exportExcel(list, "reply");
    }

    /**
     * 新增跟帖
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存跟帖
     */
//	@RequiresPermissions("bbs:reply:add")
    @Log(title = "跟帖", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> addSave(Reply reply) {
        Map<String, Object> result = new HashMap<String, Object>();
        reply.setId(NOCStringUtils.getUUID());
        reply.setCreateDate(new Date());
        reply.setCreateBy(ShiroUtils.getUserId() + "");
        int status = replyService.insertReply(reply);
        result.put("action", "/f/bbs/topic/jieDetail/" + reply.getTid());
        result.put("msg", "提交成功");
        result.put("status", status);
        return result;
    }

    /**
     * 修改跟帖
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Reply reply = replyService.selectReplyById(id);
        mmap.put("reply", reply);
        return prefix + "/edit";
    }

    /**
     * 修改保存跟帖
     */
//    @RequiresPermissions("bbs:reply:edit")
    @Log(title = "跟帖", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Reply reply) {
        return toAjax(replyService.updateReply(reply));
    }

    @Log(title = "点赞", businessType = BusinessType.UPDATE)
    @PostMapping("/jieda-zan")
    @ResponseBody
    public AjaxResult jiedaZan(Reply reply,Boolean ok) {
        reply = replyService.selectReplyById(reply.getId());
        if(ok==false){
            reply.setZan(reply.getZan() + 1);
        }else{
            reply.setZan(reply.getZan() - 1);
        }

        return toAjax(replyService.updateReply(reply));
    }

    /**
     * 删除跟帖
     */
    @RequiresPermissions("bbs:reply:remove")
    @Log(title = "跟帖", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(replyService.deleteReplyByIds(ids));
    }



    @Log(title = "跟帖", businessType = BusinessType.UPDATE)
    @PostMapping("/getData")
    @ResponseBody
    public Reply getData(String id) {
        Reply reply = replyService.selectReplyById(id);

        return reply;
    }

}
