package com.amcsoftware.car;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {
    private String make;
    private String model;
    private EngineType engineType;
    private BigDecimal price;

    public Car(String make, String model, EngineType engineType, BigDecimal price) {
        this.make = make;
        this.model = model;
        this.engineType = engineType;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make) && Objects.equals(model, car.model) && engineType == car.engineType && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, engineType, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", engineType=" + engineType +
                ", price=" + price +
                '}';
    }
}
