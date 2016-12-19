package io.manasobi.domain.entity;

import lombok.Data;

/**
 * Created by tw.jang on 2016-12-19.
 */

@Data
public class ExchangeRateResponse {

    private String base;

    private String date;

    private CountryCode rates;

    public void setRates(CountryCode rates) {

        System.out.println(rates);

        this.rates = rates;
    }
}
