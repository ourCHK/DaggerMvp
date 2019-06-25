package com.potevio.daggertestagain.ui.main;

import android.util.Log;

import com.potevio.daggertestagain.base.BaseCallback;
import com.potevio.daggertestagain.base.BasePresenter;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by CHK on 19-6-25.
 */
public class MainPresenter extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter{

    @Inject
    MainModel mMainModel;

    @Inject
    public MainPresenter() {
    }

    @Override
    protected MainContract.IMainView getView() {
        return baseView;
    }

    @Override
    public void test() {
        Log.i(MainPresenter.class.getSimpleName(),"test method");
    }

    @Override
    public void attemptLogin(Map<String, String> paramsMap) {
        getView().showLoading("登录中...");
        mMainModel.attemptLogin(paramsMap, new BaseCallback<String>() {
            @Override
            public void onFail(int code) {
                getView().hideLoading();
                getView().onFail(code);
            }

            @Override
            public void onResult(int code, String s) {
                getView().hideLoading();
                getView().onSuccess(code,s);
            }
        });
    }
}
