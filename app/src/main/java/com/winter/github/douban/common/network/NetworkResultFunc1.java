package com.winter.github.douban.common.network;


import com.winter.github.douban.common.network.base.BaseResult;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Winter on 2016/5/19.
 * Description Parse the result from server, if state = 200 return the data to client, else handle the exception.
 * email:huang.wqing@qq.com
 */
public class NetworkResultFunc1<T> implements Func1<BaseResult<T>, Observable<T>> {

    @Override
    public Observable<T> call(final BaseResult<T> tBaseResult) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                int state = tBaseResult.getState();
                String msg = tBaseResult.getMsg();
                switch (state) {
                    case 200://result OK;
                        subscriber.onNext(tBaseResult.getData());
                        break;
                    default:
                        subscriber.onError(new ApiException(state, msg));
                        break;
                }
                subscriber.onCompleted();
            }
        });
    }

}
