package io.manasobi.internal.di.module;

import android.content.Context;
import android.support.annotation.NonNull;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.manasobi.ExampleApplication;
import io.manasobi.internal.di.ApplicationContext;
import io.manasobi.internal.di.PerApp;

@PerApp
@Module
public class ApplicationModule {

    private ExampleApplication billyApplication;

    public ApplicationModule(@NonNull ExampleApplication billyApplication) {

        this.billyApplication = billyApplication;
    }

    @Singleton
    @ApplicationContext
    @Provides
    Context provideContext() {
        return this.billyApplication.getApplicationContext();
    }
}
