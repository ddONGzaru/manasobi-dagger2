package io.manasobi.internal.di.module;

import dagger.Module;
import dagger.Provides;
import io.manasobi.base.model.Motor;

@Module
public class MotorModule {

    @Provides
    Motor provideMotor() {
        return new Motor();
    }

}
