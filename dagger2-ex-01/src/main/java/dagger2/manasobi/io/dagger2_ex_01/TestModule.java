package dagger2.manasobi.io.dagger2_ex_01;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tw.jang on 2016-12-15.
 */

@Module
public class TestModule {

    /*private TestService testService;

    public TestModule(TestService testService) {
        this.testService = testService;
    }*/

    @Singleton
    @Provides
    TestModel provideTestModel(TestService service){

        TestModel testModel = new TestModel();
        testModel.setTestService(service);

        return testModel;
    }

    @Singleton
    @Provides
    TestService provideTestService() {
        return new TestService();
    }
}
