package com.potevio.daggertestagain.service;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by CHK on 19-6-24.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("putian/User/login")
    Call<ResponseBody> login(@FieldMap Map<String, String> paramsMap);

}
