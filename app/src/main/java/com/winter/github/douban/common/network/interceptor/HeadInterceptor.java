package com.winter.github.douban.common.network.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Winter on 2016/5/20.
 * Description
 * email:huang.wqing@qq.com
 */
public class HeadInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        RequestBody oidBody = originalRequest.body();
        //if the server needs to verify post params, use this to get post params;
        Map<String, String> params = new HashMap<>();
        if (oidBody instanceof FormBody) {
            FormBody formBody = (FormBody) oidBody;
            for (int i = 0; i < formBody.size(); i++) {
                params.put(formBody.encodedName(i), formBody.encodedValue(i));
            }
        }
        Request compressedRequest = originalRequest.newBuilder()
                .headers(Headers.of(getHeaders(params)))
                .build();

        return chain.proceed(compressedRequest);
    }

    public static Map<String, String> getHeaders(Map<String, String> params) {
        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Accept", Constants.Http.ContentType.CONTENT_TYPE_JSON);
//        headers.put("Content-Type", Constants.Http.ContentType.CONTENT_TYPE_JSON + "; charset=UTF-8");
//        headers.put("appname", Platform.UAAPPNAME + Platform.getVersionName(BuyerApplication.getInstance()));
//        headers.put("OS", Platform.OS);
//        headers.put("DVUA", Platform.DVUA);
//        headers.put("NT", Platform.getNetWorkTypeName(BuyerApplication.getInstance()));
//        String token = BuyerApplication.getToken();
//        if (TextUtils.isEmpty(token)) {
//            token = SharePreferenceUtils.getString(BuyerApplication.getInstance(), "token");
//            BuyerApplication.token = token;
//        }
//        headers.put("Token", token);
//        headers.put("DVID", Platform.getEquipmentId(BuyerApplication.getInstance()));
//        headers.put("ChannelId", Platform.getChannelId());
//        EncryptionParams encryptionParams = new EncryptionParams(params);
//        headers.put("CMT", encryptionParams.getParam());
//        headers.put("TM", encryptionParams.getTimestamp());

        return headers;
    }
}
