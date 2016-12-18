package dagger2.manasobi.io.dagger2_ex_01;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tw.jang on 2016-12-15.
 */

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent {

    void inject(MainActivity target);

    //TestService getTestService();

    TestService2 getTestService2();
}
