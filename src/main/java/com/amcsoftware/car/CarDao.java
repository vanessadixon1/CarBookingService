package com.amcsoftware.car;

import java.math.BigDecimal;

public class CarDao {

    private static final Car[] cars ;

    static {
        cars = new Car[]{
            new Car("Dodge", "Ram", EngineType.Electric, new BigDecimal("98.98")),
            new Car("Honda", "Accord", EngineType.Gas, new BigDecimal("59.98")),
            new Car("Toyota", "Camry", EngineType.Hybrid, new BigDecimal("38.98")),
            new Car("Ford", "F150", EngineType.Electric, new BigDecimal("209.99")),
        };
    }

    public static Car[] getCars() {
        return cars;
    }
}
