package com.potevio.daggertestagain.module;

import com.google.gson.Gson;
import com.potevio.daggertestagain.model.net.LoggingInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CHK on 19-6-25.
 */
@Module
public class AppModule {

    private String ip;

    public AppModule(String ip) {
        this.ip = ip;
    }

    @Provides
    @Singleton
    LoggingInterceptor provideLoggingInterceptor() {
        return  new LoggingInterceptor();
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return new Gson();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(LoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ip)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
