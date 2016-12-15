package io.manasobi.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tw.jang on 2016-12-15.
 */

@Module
public class MotorModule {

    @Provides
    Motor provideMotor() {
        return new Motor();
    }
}