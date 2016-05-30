package com.winter.github.douban.main.presenter;

import com.winter.github.douban.main.view.MovieView;

import rx.Subscription;

/**
 * Created by Winter on 2016/5/27.
 * Description
 * email:huang.wqing@qq.com
 */
public class MoviePresenterImp implements MoviePresenter {
    private Subscription subscription;
    private MovieView view;

    @Override
    public void attachView(MovieView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (null != subscription && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void getOnlineMovie(String city) {

    }
}
