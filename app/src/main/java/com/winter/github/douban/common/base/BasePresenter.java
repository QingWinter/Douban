package com.winter.github.douban.common.base;

/**
 * Created by Winter on 2016/5/27.
 * Description
 * email:huang.wqing@qq.com
 */
public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}
