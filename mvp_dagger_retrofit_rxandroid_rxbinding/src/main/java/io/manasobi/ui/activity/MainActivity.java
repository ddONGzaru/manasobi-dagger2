package io.manasobi.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.manasobi.AppApplication;
import io.manasobi.R;
import io.manasobi.di.DaggerExchangeRateComponent;
import io.manasobi.di.ExchangeRateComponent;
import io.manasobi.di.ExchangeRateModule;
import io.manasobi.domain.entity.ExchangeRateResponse;
import io.manasobi.presenter.ExchangeRatePresenter;

public class MainActivity extends AppCompatActivity implements ExchangeRatePresenter.View {

    @Inject ExchangeRatePresenter mPresenter;

    @BindView(R.id.button) Button button;
    @BindView(R.id.txt_jpy) TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component().inject(this);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void onClickButton() {
        mPresenter.getExchangeRate();
    }

    @Override
    public void bindExchangeRate(ExchangeRateResponse exchangeRateResponse) {
        textView.setText("KRW: " + String.valueOf(exchangeRateResponse.getRates().getKRW()));
    }

    private ExchangeRateComponent component() {
        return DaggerExchangeRateComponent.builder()
                    .appComponent(((AppApplication) getApplicationContext()).getAppComponent())
                    .exchangeRateModule(new ExchangeRateModule(this))
                    .build();
    }
}