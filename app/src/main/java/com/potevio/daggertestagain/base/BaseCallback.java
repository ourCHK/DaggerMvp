package com.potevio.daggertestagain.base;

/**
 * Created by CHK on 19-6-25.
 */
public interface BaseCallback<T> {

    void onFail(int code);

    void onResult(int code,T t);


}
