package com.winter.github.douban.common;

import android.view.View;

/**
 * Created by Winter on 2016/6/1.
 * Description Used with custom Transitions to map a View from a removed or hidden
 * Fragment to a View from a shown or added Fragment.
 * email:huang.wqing@qq.com
 */
public class SharedElement {
    private View view;
    private String name;

    public SharedElement(String name, View view) {
        this.name = name;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
