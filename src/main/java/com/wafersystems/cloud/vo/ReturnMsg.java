package com.wafersystems.cloud.vo;

/**
 * Created with IntelliJ IDEA.
 * User: roc
 * Date: 13-5-9
 * Time: 下午3:27
 * Email: liu.pengcheng@live.cn
 */
public class ReturnMsg {

    //失败返回1
    private Integer result;
    //返回失败原因
    private String msg;

    public ReturnMsg() {
    }

    public ReturnMsg(Integer result, String msg) {
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

	@Override
	public String toString() {
		
		return "{\"result\":"+result+",\"msg\":\""+msg+"\"}";
	}
    
    
}
