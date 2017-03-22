package com.wafersystems.cloud.vo;
/**
 * Created with IntelliJ IDEA.
 * User: roc
 * Date: 13-5-9
 * Time: 涓嬪崍3:27
 * Email: liu.pengcheng@live.cn
 */
public class FailMsg {

    //澶辫触杩斿洖1
    private Integer result;
    //杩斿洖澶辫触鍘熷洜
    private String msg;

    public FailMsg() {
    }

    public FailMsg(Integer result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
