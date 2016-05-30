package com.winter.github.douban.main.presenter;


import com.winter.github.douban.common.base.BasePresenter;
import com.winter.github.douban.main.view.MovieView;

/**
 * Created by Winter on 2016/5/27.
 * Description
 * email:huang.wqing@qq.com
 */
public interface MoviePresenter extends BasePresenter<MovieView> {

    void getOnlineMovie(String city);
}
