package dagger2.manasobi.io.dagger2_ex_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity2 extends AppCompatActivity {

    @Inject
    TestModel2 testModel2;

    @Inject
    TestModel2 testModel22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (testModel2 != null)
            Log.d("Dagger 2" , "testModel is not null");

        testModel2.print();

        System.out.println(testModel2);
        System.out.println(testModel22);

        testModel2.print();
    }

    private TestComponent component() {
        return DaggerTestComponent.builder().build();
    }
}

