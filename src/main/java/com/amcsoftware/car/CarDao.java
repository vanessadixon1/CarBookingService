package com.amcsoftware.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    private static final List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("Dodge", "Ram", EngineType.Electric, new BigDecimal("98.98")));
        cars.add(new Car("Honda", "Accord", EngineType.Gas, new BigDecimal("59.98")));
        cars.add(new Car("Toyota", "Camry", EngineType.Hybrid, new BigDecimal("38.98")));
        cars.add(new Car("Ford", "F150", EngineType.Electric, new BigDecimal("209.99")));
    }

    public static List<Car> getCars() {
        return cars;
    }
}
