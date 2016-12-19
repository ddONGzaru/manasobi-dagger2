package io.manasobi.exchange;

import android.util.Log;

import javax.inject.Inject;

import io.manasobi.data.ExchangeRateResponse;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tw.jang on 2016-12-19.
 */

public class ExchangeRatePresenter implements ExchangeRateContract.Presenter {
    private Retrofit mRetrofit;
    private ExchangeRateContract.View mView;

    @Inject
    public ExchangeRatePresenter(Retrofit retrofit, ExchangeRateContract.View view) {
        this.mRetrofit = retrofit;
        this.mView = view;
    }

    public void getExchangeRate() {
        mRetrofit.create(ExchangeRateApi.class).getExchangeRate("USD", "JPY")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ExchangeRateResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("通信 -> ", "失敗" + e.toString());
                    }

                    @Override
                    public void onNext(ExchangeRateResponse exchangeRateResponse) {
                        mView.bindExchangeRate(exchangeRateResponse);
                    }
                });
    }
}
