package io.manasobi.exchange;

import dagger.Component;
import io.manasobi.PerActivity;
import io.manasobi.data.AppComponent;

/**
 * Created by tw.jang on 2016-12-19.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ExchangeRateModule.class)
public interface ExchangeRateComponent {
    void inject(MainActivity activity);
}

