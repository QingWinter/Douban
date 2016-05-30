package com.winter.github.douban.common.network.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Winter on 2016/5/18.
 * Description use this, if the result Json data from server like this
 * {
 * "state":0,
 * "msg":"",
 * "data":{}
 * }
 * email:huang.wqing@qq.com
 */
public class BaseResult<T> {
    @SerializedName("resultcode")
    private int state;
    @SerializedName("reason")
    private String msg;
    @SerializedName("result")
    private T data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
