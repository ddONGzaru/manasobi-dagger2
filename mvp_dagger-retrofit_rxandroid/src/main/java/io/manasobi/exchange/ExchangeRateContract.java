package io.manasobi.exchange;

import io.manasobi.data.ExchangeRateResponse;

/**
 * Created by tw.jang on 2016-12-19.
 */

public interface ExchangeRateContract {
    interface View {
        void bindExchangeRate(ExchangeRateResponse exchangeRateResponse);
    }

    interface Presenter {
        void getExchangeRate();
    }
}
