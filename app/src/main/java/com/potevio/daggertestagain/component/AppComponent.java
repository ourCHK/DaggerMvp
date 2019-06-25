package com.potevio.daggertestagain.component;

import com.potevio.daggertestagain.module.AppModule;
import com.potevio.daggertestagain.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by CHK on 19-6-25.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity activity);
}
