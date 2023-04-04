package com.amcsoftware.booking;

import com.amcsoftware.car.Car;
import com.amcsoftware.car.CarDao;
import com.amcsoftware.car.CarService;
import com.amcsoftware.user.User;
import com.amcsoftware.user.UserService;

import java.util.UUID;

public class BookingService {

    public static final int AVAILABLECARS = CarDao.getCars().length;

    private BookingDao bookingDao;

    private UserService userService;
    private CarService carService;

    public BookingService(BookingDao bookingDao, UserService userService, CarService carService) {
        this.bookingDao =  bookingDao;

        this.carService = carService;
        this.userService = userService;
    }

    public void bookACar(String id, String carMake) {

        if (!id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4{1}[a-fA-F0-9]{3}-[89abAB]{1}[a-fA-F0-9]{3}-[a-fA-F0-9]{12}$") ) {
            System.out.println("invalid car id");
            return;
        }

        User user = userService.locateUser(id);
        Car car = carService.locateCar(carMake);

        if (user != null && car != null) {

            if(user.getAge() < 21) {
                System.out.println("Booking failed - users have to be 21 or older to book a car through AMC Software Booking Service");
                return;
            }
            Booking newBooking = new Booking(user.getId(), car);
            bookingDao.saveBooking(newBooking);

            for (int i = 0; i < userService.getUsers().length; i++) {
                if (userService.getUsers()[i] != null && userService.getUsers()[i].equals(user)) {
                    userService.getUsers()[i] = null;
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

    public void getUserBooking(String id) {
        Booking locatedBooking  = null;

        for(Booking userBooking : BookingDao.getBookings()) {
            if(userBooking != null && userBooking.getUserid().equals(UUID.fromString(id))) {
                locatedBooking = userBooking;
            }
        }

        if(locatedBooking != null) {
            System.out.println("user " + UUID.fromString(id) + " has the following booking\n" + locatedBooking );
        } else {
            System.out.println("no booking for the id " + UUID.fromString(id) + " exist");
        }

    }

    public static Booking[] getAllBookings() {
        return BookingDao.getBookings();
    }

}
