package io.manasobi.dagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tw.jang on 2016-12-14.
 */

@Singleton
@Component(modules = {InfraLayerModule.class, AppLayerModule.class, AppModule.class})
public interface AppComponent {

    void inject(MainActivity activity);
}
