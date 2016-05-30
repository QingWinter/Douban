package com.winter.github.douban.main.model.api;

import com.winter.github.douban.main.model.bean.OnlineMovie;
import com.winter.github.douban.common.network.base.BaseResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Winter on 2016/5/27.
 * Description
 * email:huang.wqing@qq.com
 */
public interface MovieApi {

    /**
     * 获取正在热映电影列表
     * @param city
     * @return
     */
    @GET("/v2/movie/in_theaters")
    Observable<BaseResult<OnlineMovie>> getOnlineMovie(@Path("city") String city);



}
