package com.potevio.daggertestagain.app;

import android.app.Application;

import com.potevio.daggertestagain.component.AppComponent;
import com.potevio.daggertestagain.component.DaggerAppComponent;
import com.potevio.daggertestagain.constant.ShareConstant;
import com.potevio.daggertestagain.module.AppModule;

/**
 * Created by CHK on 19-6-25.
 */
public class App extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(ShareConstant.IP))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
