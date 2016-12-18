package dagger2.manasobi.io.dagger2_ex_01;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tw.jang on 2016-12-18.
 */
@Singleton
public class TestService2 {

    @Inject
    public TestService2() {
    }

    public void test() {
        System.out.println("TEST SERVICE 2 :: test");
    }

    public void test2() {
        System.out.println("TEST SERVICE 2 :: test2");
    }
}
