package dagger2.manasobi.io.dagger2_ex_01;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tw.jang on 2016-12-15.
 */
@Singleton
public class TestModel2 {

    private TestService2 testService;

    @Inject
    public TestModel2(TestService2 testService) {
        this.testService = testService;
    }

    public void print() {
        testService.test2();
    }

}
