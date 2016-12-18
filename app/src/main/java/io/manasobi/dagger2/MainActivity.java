package io.manasobi.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject
    WeatherFacade facade;

    @Bind(R.id.editText)
    EditText editText;

    @Bind(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getApplicationComponent().inject(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                facade.fetchWeahter(editText.getText().toString());
            }
        });
    }
    private AppComponent getApplicationComponent() {
        return ((AppApplication) getApplication()).getAppComponent();
    }
}
