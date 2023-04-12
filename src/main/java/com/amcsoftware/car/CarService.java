package com.amcsoftware.car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public CarService() {
    }

    public static List<Car> getCars() {
        return CarDao.getCars();
    }

    public Car locateCar(String carMake) {
        Car car = null;
        for (int i = 0; i < CarService.getCars().size(); i++) {
            if (CarService.getCars().get(i).getMake().equalsIgnoreCase(carMake)) {
                car = CarService.getCars().get(i);
            }
        }
        return car;
    }

    public List<Car> getAvailableElectricCars() {
        List<Car> availableElectricCars = new ArrayList<>();
        for(Car car : getCars()) {
            if(car != null && car.getEngineType().equals(EngineType.Electric)) {
                availableElectricCars.add(car);
            }
        }
        return availableElectricCars;
    }

}
