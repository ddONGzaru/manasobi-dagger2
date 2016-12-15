package io.manasobi.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tw.jang on 2016-12-14.
 */

@Module
public class InfraLayerModule {

    @Provides
    public WeatherRepository provideWeatherRepository(Context context) {
        return new WeatherRepository(context);
    }
}
