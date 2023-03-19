package com.amcsoftware.booking;

import com.amcsoftware.car.Car;

import java.util.Objects;
import java.util.UUID;

public class Booking {
    private UUID userid;
    private Car car;

    public Booking(UUID userid, Car car) {
        this.userid = userid;
        this.car = car;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(userid, booking.userid) && Objects.equals(car, booking.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, car);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userid=" + userid +
                ", car=" + car +
                '}';
    }
}
