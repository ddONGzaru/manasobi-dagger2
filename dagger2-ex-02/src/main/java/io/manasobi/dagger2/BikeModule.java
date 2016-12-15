package io.manasobi.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tw.jang on 2016-12-15.
 */

@Module(includes = MotorModule.class)
public class BikeModule {

    @Provides
    Bike provideBike(Motor motor) {
        return new Bike(motor);
    }
}
