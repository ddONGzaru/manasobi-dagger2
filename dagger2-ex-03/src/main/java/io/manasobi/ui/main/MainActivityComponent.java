package io.manasobi.ui.main;

import android.support.annotation.NonNull;

import dagger.Component;
import io.manasobi.internal.di.PerActivity;
import io.manasobi.internal.di.component.ActivityComponent;
import io.manasobi.internal.di.component.ApplicationComponent;
import io.manasobi.internal.di.module.BikeModule;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                MainActivityModule.class,
                BikeModule.class
        }
)
public interface MainActivityComponent extends ActivityComponent {
    void inject(@NonNull MainActivity mainActivity);
}
