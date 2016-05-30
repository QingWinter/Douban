package com.winter.github.douban.common.network;

import android.support.annotation.Nullable;


import com.winter.github.douban.BuildConfig;
import com.winter.github.douban.common.App;
import com.winter.github.douban.common.Constants;
import com.winter.github.douban.common.network.interceptor.DynamicBaseUrlInterceptor;
import com.winter.github.douban.common.network.interceptor.HeadInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Winter on 2016/5/18.
 * Description
 * email:huang.wqing@qq.com
 */
public class OkHttpClientHelper {

    public static OkHttpClient getClient(HostType type, boolean retryOnFailure) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeadInterceptor())
                .addInterceptor(OkHttpClientHelper.getLoggingInterceptor())
                .addInterceptor(getDynamicBaseUrlInterceptor(type))
                .retryOnConnectionFailure(retryOnFailure)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .sslSocketFactory(getSslSocketFactory())
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        //return true, client will not verify hostname
                        return true;
                    }
                })
                .cookieJar(new CookieJar() {
                    private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(HttpUrl.parse(url.host()), cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(HttpUrl.parse(url.host()));
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                })

                .build();
        return client;
    }

    private static Interceptor getDynamicBaseUrlInterceptor(HostType type) {
        DynamicBaseUrlInterceptor interceptor = new DynamicBaseUrlInterceptor();
        switch (type) {
            case HTTP:
                //do nothing, use default baseUrl
                break;
            case HTTPS:
                interceptor.setHost(Constants.BASE_HTTPS_URL);
                break;
        }
        return interceptor;
    }

    public static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // In debug mode print the whole body of response
        if (BuildConfig.LOG_DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return logging;
    }

    @Nullable
    private static SSLSocketFactory getSslSocketFactory() {
        SSLSocketFactory sslSocketFactory = null;
        try {
            sslSocketFactory = SSLSocketFactoryHook.getSslSocketFactory(
                    null,
                    App.getApp().getAssets().open("starline2.bks"),
                    ""
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sslSocketFactory;
    }
}
