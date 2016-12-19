package io.manasobi.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.manasobi.domain.entity.ExchangeRateResponse;
import io.manasobi.domain.ExchangeRateApi;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tw.jang on 2016-12-19.
 */

public class ExchangeRatePresenter {

    private Retrofit mRetrofit;
    private View mView;

    @Inject
    public ExchangeRatePresenter(Retrofit retrofit, View view) {
        this.mRetrofit = retrofit;
        this.mView = view;
    }

    public void getExchangeRate() {
        mRetrofit.create(ExchangeRateApi.class)
                 .getExchangeRate("USD", "KRW")
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

    public interface View {
        void bindExchangeRate(ExchangeRateResponse exchangeRateResponse);
    }
}
