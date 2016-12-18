package dagger2.manasobi.io.dagger2_ex_01;

import lombok.Setter;

/**
 * Created by tw.jang on 2016-12-15.
 */
public class TestModel {

    //
    @Setter
    TestService testService;

    public void print() {
        testService.test();
    }

}
