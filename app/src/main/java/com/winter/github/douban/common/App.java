package com.winter.github.douban.common;

import android.app.Application;

/**
 * Created by Winter on 2016/5/27.
 * Description
 * email:huang.wqing@qq.com
 */
public class App extends Application {
    public static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public synchronized static Application getApp() {
        return instance;
    }
}
