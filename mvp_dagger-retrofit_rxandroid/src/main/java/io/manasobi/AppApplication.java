package io.manasobi;

import android.app.Application;

import io.manasobi.data.ApiModule;
import io.manasobi.data.AppComponent;
import io.manasobi.data.AppModule;
import io.manasobi.data.DaggerAppComponent;

/**
 * Created by tw.jang on 2016-12-19.
 */

public class AppApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
