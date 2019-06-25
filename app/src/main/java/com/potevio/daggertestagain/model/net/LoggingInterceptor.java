package com.potevio.daggertestagain.model.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by CHK on 19-6-24.
 */
public class LoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request  = chain.request();
        return chain.proceed(request);
    }
}
