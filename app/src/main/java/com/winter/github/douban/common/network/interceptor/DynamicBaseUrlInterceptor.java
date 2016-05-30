package com.winter.github.douban.common.network.interceptor;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Winter on 2016/5/18.
 * Description build a dynamicBaseUrl for OkHttpClient.
 * email:huang.wqing@qq.com
 */
public class DynamicBaseUrlInterceptor implements Interceptor {
    private volatile String host;

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (!TextUtils.isEmpty(host)) {
            HttpUrl newUrl = originalRequest.url().newBuilder()
                    .host(host)
                    .build();
            originalRequest = originalRequest.newBuilder()
                    .url(newUrl)
                    .build();
        }

        return chain.proceed(originalRequest);
    }
}
