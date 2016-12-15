package io.manasobi.internal.di.module;

import android.app.Activity;
import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import io.manasobi.internal.di.PerActivity;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(@NonNull Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    Activity provideActivity() {
        return this.activity;
    }
}
