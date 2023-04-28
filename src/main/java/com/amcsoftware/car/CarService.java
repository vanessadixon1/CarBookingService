package com.amcsoftware.car;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    public CarService() {
    }

    public static List<Car> getCars() {
        return CarDao.getCars();
    }

    public Car locateCar(String carMake) {
        Car car = null;
        for (int i = 0; i < getCars().size(); i++) {
            if (CarService.getCars().get(i).getMake().equalsIgnoreCase(carMake)) {
                car =  CarService.getCars().get(i);
            }
        }
        return car;
    }

    public List<Car> getAvailableElectricCars() {

        return getCars().stream().filter(car -> car.getEngineType().equals(EngineType.Electric))
                .collect(Collectors.toList());
    }

}
