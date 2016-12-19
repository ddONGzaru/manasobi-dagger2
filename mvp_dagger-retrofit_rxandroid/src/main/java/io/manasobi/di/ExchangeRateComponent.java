package io.manasobi.di;

import dagger.Component;
import io.manasobi.PerActivity;
import io.manasobi.ui.activity.MainActivity;

/**
 * Created by tw.jang on 2016-12-19.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ExchangeRateModule.class)
public interface ExchangeRateComponent {
    void inject(MainActivity activity);
}

