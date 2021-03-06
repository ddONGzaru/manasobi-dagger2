package dagger2.manasobi.io.dagger2_ex_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    TestModel testModel;

    @Inject
    TestModel2 testModel2;

    @Inject
    TestModel2 testModel22;

    @Inject TestService2 testService2;

    @Inject TestService testService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component().inject(this);


        if (testModel != null)
            Log.d("Dagger 2" , "testModel is not null 111");

        testModel.print();
        testModel2.print();

        System.out.println(testModel);
        System.out.println(testModel2);
        System.out.println(testModel22);

        //testService = component().getTestService();
        testService.test2();

        //testService2 = component().getTestService2();
        testService2.test2();
        testModel2.print();
    }

    private TestComponent component() {
        return DaggerTestComponent.builder().build();
    }
}

