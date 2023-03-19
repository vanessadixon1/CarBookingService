package com.amcsoftware.car;

public class CarService {

    private CarDao carDao;

    public CarService() {
        this.carDao = new CarDao();
    }

    public static Car[] getCars() {
        return CarDao.getCars();
    }

    public Car locateCar(String carMake)  {
        Car car = null;
        for(int i = 0; i < CarService.getCars().length; i++) {
            if (CarService.getCars()[i] != null && CarService.getCars()[i].getMake().equalsIgnoreCase(carMake) ) {
                car = CarService.getCars()[i];
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
