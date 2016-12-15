package io.manasobi.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tw.jang on 2016-12-14.
 */

@Module
public class AppLayerModule {

    @Provides
    public WeatherFacade provideWeatherFacade(WeatherRepository repository) {
        return new WeatherFacade(repository);
    }
}
