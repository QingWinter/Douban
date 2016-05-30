package com.winter.github.douban.common.network.base;

import com.winter.github.douban.common.Constants;
import com.winter.github.douban.common.network.HostType;
import com.winter.github.douban.common.network.OkHttpClientHelper;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Winter on 2016/5/20.
 * Description
 * email:huang.wqing@qq.com
 */
public interface BaseNetwork {
    /**
     * Create {@link Retrofit} for client
     */
    class Factory {

        public static <T> T create(Class<T> clazz) {
            return create(clazz, HostType.HTTP);
        }

        public static <T > T create(Class<T> clazz, HostType type) {
            return create(clazz, type, false);
        }

        public static <T> T create(Class<T> clazz, HostType type, boolean retryOnFailure) {
            Retrofit retrofit =new Retrofit.Builder()
                    .baseUrl(Constants.BASE_HTTP_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(OkHttpClientHelper.getClient(type, retryOnFailure))
                    .build();
            return retrofit.create(clazz);
        }

    }

}
