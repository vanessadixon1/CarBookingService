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

}
