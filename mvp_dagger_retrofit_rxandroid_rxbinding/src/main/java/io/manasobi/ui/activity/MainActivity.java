package io.manasobi.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.manasobi.AppApplication;
import io.manasobi.R;
import io.manasobi.di.DaggerExchangeRateComponent;
import io.manasobi.di.ExchangeRateComponent;
import io.manasobi.domain.entity.ExchangeRateResponse;
import io.manasobi.presenter.ExchangeRatePresenter;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements ExchangeRatePresenter.View {

    @Inject ExchangeRatePresenter presenter;

    @BindView(R.id.button) Button button;
    @BindView(R.id.txt_jpy) TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component().inject(this);
        presenter.setView(this);
        ButterKnife.bind(this);

        onClickButtonRx();
    }


    void onClickButtonRx() {

        RxView.clicks(button)
              .switchMap(event -> presenter.getExchangeRateRx())
                                           .doOnError(this::showError)
                                           .onErrorResumeNext(Observable.empty())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(res -> {
                  textView.setText("[KRW] :: " + String.valueOf(res.getRates().getKRW()));
              }, throwable -> {
                  Log.d("通信 -> ", "失敗" + throwable.getMessage());
                  Timber.e("Error: " + throwable.getMessage());
                  throwable.printStackTrace();
              });

    }
/*
    @OnClick(R.id.button)
    void onClickButton() {
        presenter.getExchangeRate();
    }
*/

    private void showError(Throwable t) {

        Timber.e(t.getMessage());

        String message = t.getMessage();
        if (t instanceof HttpException) {
            HttpException httpException = (HttpException) t;
            if (httpException.code() == 403)
                message = "403 에러";
            else if (httpException.code() == 404)
                message = "404 에러";
        }
        textView.setText(message);
    }


    @Override
    public void bindExchangeRate(ExchangeRateResponse exchangeRateResponse) {
        textView.setText("KRW :: " + String.valueOf(exchangeRateResponse.getRates().getKRW()));
    }

    private ExchangeRateComponent component() {
        return DaggerExchangeRateComponent.builder()
                    .appComponent(((AppApplication) getApplicationContext()).getAppComponent())
                    .build();
    }
}