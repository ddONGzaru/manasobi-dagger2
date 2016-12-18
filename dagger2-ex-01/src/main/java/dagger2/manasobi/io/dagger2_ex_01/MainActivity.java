package dagger2.manasobi.io.dagger2_ex_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    TestModel testModel;

    @Inject
    TestModel testModel2;

    private TestService testService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component().inject(this);


        if (testModel != null)
            Log.d("Dagger 2" , "testModel is not null");

        testModel.print();

        System.out.println(testModel);
        System.out.println(testModel2);

        testService = component().getTestService();

        testService.test2();
    }

    private TestComponent component() {
        return DaggerTestComponent.builder().build();
    }
}
