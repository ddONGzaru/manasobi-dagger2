package io.manasobi.dagger2;

import android.support.annotation.NonNull;

/**
 * Created by tw.jang on 2016-12-15.
 */

public class Bike {

    private Motor motor;

    public Bike(@NonNull Motor motor) {
        this.motor = motor;
    }

    public void increaseSpped() {
        this.motor.setSpeed(this.motor.getSpeed() + 1);
    }

    public void decreaseSpeed() {
        if (this.motor.getSpeed() > 0) {
            this.motor.setSpeed(this.motor.getSpeed() - 1);
        }
    }

    public int getSpeed() {
        return this.motor.getSpeed();
    }
}