package io.manasobi;

import android.app.Application;

import io.manasobi.internal.di.component.ApplicationComponent;
import io.manasobi.internal.di.component.DaggerApplicationComponent;
import io.manasobi.internal.di.module.ApplicationModule;
import io.manasobi.internal.di.module.DataBaseModule;


public class ExampleApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataBaseModule(new DataBaseModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
