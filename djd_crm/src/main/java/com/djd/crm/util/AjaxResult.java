package com.djd.crm.util;

/**
 * Created by HP on 2020/11/26.
 * ajax请求，返回结果对象
 * {"success":true,"msg":"保存成功"}
 * {"success":false,"msg":"保存失败"}
 */
public class AjaxResult {
    private boolean success;
    private String msg;

    public AjaxResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public AjaxResult(String msg) {
        this.msg = msg;
    }

    public AjaxResult() {

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
