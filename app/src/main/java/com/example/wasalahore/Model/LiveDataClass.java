package com.example.wasalahore.Model;

public class LiveDataClass {

    int speed;
    int rpm;
    int fuel;

    public LiveDataClass(int speed, int rpm, int fuel) {
        this.speed = speed;
        this.rpm = rpm;
        this.fuel = fuel;
    }

    public LiveDataClass() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
