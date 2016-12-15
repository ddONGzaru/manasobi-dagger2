package io.manasobi.internal.di.module;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import io.manasobi.base.model.Motor;
import io.manasobi.base.model.Vehicle;

@Module(
        includes = {
                MotorModule.class
        }
)
public class VehicleModule {

    @Provides
    Vehicle privdeVehicle(@NonNull Motor motor) {
        return new Vehicle(motor);
    }

}
