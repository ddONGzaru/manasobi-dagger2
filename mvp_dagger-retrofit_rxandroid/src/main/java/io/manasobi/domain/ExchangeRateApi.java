package io.manasobi.domain;

import io.manasobi.domain.entity.ExchangeRateResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by tw.jang on 2016-12-19.
 */

public interface ExchangeRateApi {
    String URL = "/latest";

    @GET(URL)
    Observable<ExchangeRateResponse> getExchangeRate(@Query("base") String base,
                                                     @Query("symbols") String symbols);
}
