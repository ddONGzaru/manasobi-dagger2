package io.manasobi.exchange;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tw.jang on 2016-12-19.
 */

@Module
public class ExchangeRateModule {
    private final ExchangeRateContract.View mView;

    public ExchangeRateModule(ExchangeRateContract.View mView) {
        this.mView = mView;
    }

    @Provides
    ExchangeRateContract.View provideExchangeRateView() {
        return mView;
    }
}
