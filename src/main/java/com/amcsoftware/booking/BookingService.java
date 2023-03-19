package com.amcsoftware.booking;

import com.amcsoftware.car.Car;
import com.amcsoftware.car.CarDao;
import com.amcsoftware.car.CarService;
import com.amcsoftware.user.User;
import com.amcsoftware.user.UserService;

public class BookingService {

    public static final int AVAILABLECARS = CarDao.getCars().length;

    private BookingDao bookingDao;
    private CarDao carDao;
    private UserService userService;
    private CarService carService;

    public BookingService() {
        this.bookingDao = new BookingDao();
        this.carDao = new CarDao();
        this.carService = new CarService();
        this.userService = new UserService();
    }

    public void bookACar(String id, String carMake) {

        if (!id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4{1}[a-fA-F0-9]{3}-[89abAB]{1}[a-fA-F0-9]{3}-[a-fA-F0-9]{12}$") ) {
            System.out.println("invalid car id");
            return;
        }

        User user = userService.locateUser(id);
        Car car = carService.locateCar(carMake);

        if (user != null && car != null) {
            Booking newBooking = new Booking(user.getId(), car);
            bookingDao.saveBooking(newBooking);

            for (int i = 0; i < UserService.getUsers().length; i++) {
                if (UserService.getUsers()[i] != null && UserService.getUsers()[i].equals(user)) {
                    UserService.getUsers()[i] = null;
                }
            }

            for (int i = 0; i < CarService.getCars().length; i++) {
                if (CarService.getCars()[i] != null && CarService.getCars()[i].equals(car)) {
                    CarService.getCars()[i] = null;
                }
            }
        } else {
            System.out.println("invalid or booked id/car - check the id/car and try rebooking");
        }
    }

    public static Booking[] getAllBookings() {
        return BookingDao.getBookings();
    }
}
