package io.manasobi.ui.main;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import dagger.Module;

@Module
public class MainActivityModule {

    private WeakReference<MainActivity> activityWeakReference;

    public MainActivityModule(@NonNull MainActivity mainActivity) {
        this.activityWeakReference = new WeakReference<MainActivity>(mainActivity);
    }
}
