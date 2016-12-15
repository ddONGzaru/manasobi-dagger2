package io.manasobi.internal.di.module;

import dagger.Module;
import dagger.Provides;
import io.manasobi.base.model.Bike;
import io.manasobi.base.model.Motor;

@Module(
        includes = MotorModule.class
)
public class BikeModule {

    @Provides
    Bike provideBike(Motor motor) {
        return new Bike(motor);
    }
}
