package com.ruoyi.activiti.comm.base;

import com.ruoyi.common.core.domain.AjaxResult;

import java.util.HashMap;

/**
 * 操作消息提醒
 * 
 * @author ruoyi
 */
public class AjaxResultAct extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResultAct()
    {
    }

    /**
     * 返回错误消息
     * 
     * @return 错误消息
     */
    public static AjaxResultAct error()
    {
        return error(1, "操作失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResultAct error(String msg)
    {
        return error(500, msg);
    }

    /**
     * 返回错误消息
     * 
     * @param code 错误码
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResultAct error(int code, String msg)
    {
        AjaxResultAct json = new AjaxResultAct();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功消息
     * 
     * @param msg 内容
     * @return 成功消息
     */
    public static AjaxResultAct success(String msg)
    {
        AjaxResultAct json = new AjaxResultAct();
        json.put("msg", msg);
        json.put("code", 0);
        return json;
    }
    
    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static AjaxResultAct success()
    {
        return AjaxResultAct.success("操作成功");
    }

    /**
     * 返回成功消息
     * 
     * @param key 键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public AjaxResultAct put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}
