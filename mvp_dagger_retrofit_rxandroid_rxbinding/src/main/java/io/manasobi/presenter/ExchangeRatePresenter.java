package io.manasobi.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.manasobi.domain.ExchangeRateApi;
import io.manasobi.domain.entity.ExchangeRateResponse;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by tw.jang on 2016-12-19.
 */

public class ExchangeRatePresenter {

    private Retrofit retrofit;
    private View view;

    @Inject
    public ExchangeRatePresenter(Retrofit retrofit, View view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    public void getExchangeRate() {

        retrofit.create(ExchangeRateApi.class)
                .getExchangeRate("USD", "KRW")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    view.bindExchangeRate(res);
                }, throwable -> {
                    Log.d("通信 -> ", "失敗" + throwable.getMessage());
                    Timber.e("Error: " + throwable.getMessage());
                    throwable.printStackTrace();
                });
    }

    public Observable<ExchangeRateResponse> getExchangeRateRx() {
        return retrofit.create(ExchangeRateApi.class)
                        .getExchangeRate("USD", "KRW")
                        .subscribeOn(Schedulers.io());
    }

    public interface View {
        void bindExchangeRate(ExchangeRateResponse exchangeRateResponse);
    }
}
