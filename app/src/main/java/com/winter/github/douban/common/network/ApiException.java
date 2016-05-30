package com.winter.github.douban.common.network;


/**
 * Created by Winter on 2016/5/19.
 * Description
 * email:huang.wqing@qq.com
 */
public class ApiException extends RuntimeException {
    private int state;
    private String msg;
    public ApiException(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }
}
