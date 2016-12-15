package io.manasobi.dagger2;

import javax.inject.Inject;

/**
 * Created by tw.jang on 2016-12-14.
 */

public class WeatherFacade {

    private WeatherRepository repository;

    @Inject
    public WeatherFacade(WeatherRepository repository){
        this.repository = repository;
    }

    public void fetchWeahter(String cityCode){
        //repository.fetchWeather(cityCode);
    }

}
