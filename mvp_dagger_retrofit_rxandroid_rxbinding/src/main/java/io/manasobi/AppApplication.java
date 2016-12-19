package io.manasobi;

import android.app.Application;

import io.manasobi.di.AppComponent;
import io.manasobi.di.DaggerAppComponent;

/**
 * Created by tw.jang on 2016-12-19.
 */

public class AppApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                                          .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
