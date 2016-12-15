package io.manasobi.internal.di.component;

import com.squareup.sqlbrite.BriteDatabase;

import javax.inject.Singleton;

import dagger.Component;
import io.manasobi.base.model.Vehicle;
import io.manasobi.internal.di.module.ApplicationModule;
import io.manasobi.internal.di.module.DataBaseModule;
import io.manasobi.internal.di.module.VehicleModule;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                VehicleModule.class,
                DataBaseModule.class
        }
)
public interface ApplicationComponent {
    Vehicle getVehicle();
    BriteDatabase getBriteDataBase();
}
