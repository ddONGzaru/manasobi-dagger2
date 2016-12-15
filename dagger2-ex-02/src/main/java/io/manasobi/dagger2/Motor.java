package io.manasobi.dagger2;

/**
 * Created by tw.jang on 2016-12-15.
 */

public class Motor {

    private int speed;

    public Motor() {
        this.speed = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public void accelerate(int value) {
        speed = speed + value;
    }

    public void setSpeed(int value) {
        speed = value;
    }

    public void brake() {
        speed = 0;
    }
}