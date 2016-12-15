package io.manasobi.internal.di.component;

import dagger.Component;
import io.manasobi.internal.di.PerActivity;
import io.manasobi.internal.di.module.ActivityModule;

@PerActivity
@Component(
        modules = ActivityModule.class
)
public interface ActivityComponent {
}
