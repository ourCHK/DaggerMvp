package com.potevio.daggertestagain.ui.main;

import com.potevio.daggertestagain.base.BaseCallback;
import com.potevio.daggertestagain.base.BaseView;

import java.util.Map;

/**
 * Created by CHK on 19-6-25.
 */
public interface MainContract {

    interface IMainView extends BaseView {
        void onFail(int code);
        void onSuccess(int code,String msg);
    }

    interface IMainPresenter {
        void test();

        void attemptLogin(Map<String,String> paramsMap);
    }

}
