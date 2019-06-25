package com.potevio.daggertestagain.ui.main;

import com.google.gson.Gson;
import com.potevio.daggertestagain.base.BaseCallback;
import com.potevio.daggertestagain.service.ApiService;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by CHK on 19-6-25.
 */
public class MainModel {

    @Inject
    Retrofit mRetrofit;

    @Inject
    Gson gson;

    @Inject
    public MainModel() {

    }

    public void attemptLogin(Map<String,String> paramsMap, final BaseCallback<String> baseCallback) {
        mRetrofit.create(ApiService.class)
                .login(paramsMap)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String responseString = response.body().string();
                            baseCallback.onResult(200,responseString);
                            return;
                        } catch (IOException ie) {
                            ie.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        baseCallback.onFail(-1);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseCallback.onFail(-1);
                    }
                });
    }

}
