package com.amcsoftware.car;

import java.util.List;

public class CarService {

    public CarService() {

    }

    public static List<Car> getCars() {
        return CarDao.getCars();
    }

    public Car locateCar(String carMake)  {
        Car car = null;
        for(int i = 0; i < CarService.getCars().size(); i++) {
            if (CarService.getCars().get(i) != null && CarService.getCars().get(i).getMake().equalsIgnoreCase(carMake) ) {
                car = CarService.getCars().get(i);
                break;
            }
        }
        return car;
    }

    private int numberOfElectricCars() {
        int count = 0;
        for(Car car : getCars()) {
            if(car != null && car.getEngineType().equals(EngineType.Electric)) {
                count++;
            }
        }
        return count;
    }

    public Car[] getAvailableElectricCars() {
        Car[] availableElectricCars = new Car[numberOfElectricCars()];
        int nextAvailable = 0;
        for(Car car : getCars()) {
            if(car != null && car.getEngineType().equals(EngineType.Electric)) {
                availableElectricCars[nextAvailable++] = car;
            }
        }
        if(availableElectricCars.length == 0) {
            System.out.println("There are no available Electric cars at this time. Check back later");
        }
        return availableElectricCars;
    }

}
