package io.manasobi.dagger2;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by tw.jang on 2016-12-14.
 */

public class WeatherRepository {

    private Context mContext;

    @Inject
    public WeatherRepository(Context context) {
        mContext = context;
    }


}