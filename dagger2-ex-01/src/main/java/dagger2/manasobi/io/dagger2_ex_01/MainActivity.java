package dagger2.manasobi.io.dagger2_ex_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private TestComponent component;

    @Inject
    TestModel testModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component = DaggerTestComponent.builder().testModule(new TestModule()).build();
        component.inject(this);

        if (testModel != null)
            Log.d("Dagger 2" , "testModel is not null");
    }
}
