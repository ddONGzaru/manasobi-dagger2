package io.manasobi.exchange;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import io.manasobi.AppApplication;
import io.manasobi.R;
import io.manasobi.data.ExchangeRateResponse;

public class MainActivity extends AppCompatActivity implements ExchangeRateContract.View {

    @Inject
    ExchangeRatePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerExchangeRateComponent.builder()
                .appComponent(((AppApplication) getApplicationContext()).getAppComponent())
                .exchangeRateModule(new ExchangeRateModule(this))
                .build().inject(this);

        mPresenter.getExchangeRate();
    }

    @Override
    public void bindExchangeRate(ExchangeRateResponse exchangeRateResponse) {
        TextView textView = (TextView) findViewById(R.id.txt_jpy);
        textView.setText("JPY: " + String.valueOf(exchangeRateResponse.getRates().getJPY()));
    }
}