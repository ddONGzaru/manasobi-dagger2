package io.manasobi.di;

import dagger.Module;
import dagger.Provides;
import io.manasobi.presenter.ExchangeRatePresenter;

/**
 * Created by tw.jang on 2016-12-19.
 */

@Module
public class ExchangeRateModule {

    private final ExchangeRatePresenter.View mView;

    public ExchangeRateModule(ExchangeRatePresenter.View mView) {
        this.mView = mView;
    }

    @Provides
    ExchangeRatePresenter.View provideExchangeRateView() {
        return mView;
    }
}
