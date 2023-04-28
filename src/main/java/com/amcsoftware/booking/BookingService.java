package com.amcsoftware.booking;

import com.amcsoftware.car.Car;
import com.amcsoftware.car.CarService;
import com.amcsoftware.user.User;
import com.amcsoftware.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingService {


    private final BookingDao bookingDao;
    private final UserService userService;
    private final CarService carService;

    public BookingService(BookingDao bookingDao, UserService userService, CarService carService) {
        this.bookingDao =  bookingDao;
        this.carService = carService;
        this.userService = userService;
    }

    private void removeUser(User user) {
        for (int i = 0; i < userService.getUsers().size(); i++) {
            if (userService.getUsers().get(i).equals(user)) {
                userService.getUsers().remove(i);
                break;
            }
        }
    }

    private void removeCar(Car car) {
        for (int i = 0; i < CarService.getCars().size(); i++) {
            if (CarService.getCars().get(i).equals(car)) {
                CarService.getCars().remove(i);
                break;
            }
        }
    }

    public void bookACar(String id, String carMake) {
        if (!id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4{1}[a-fA-F0-9]{3}-[89abAB]{1}[a-fA-F0-9]{3}-[a-fA-F0-9]{12}$") ) {
            System.out.println("invalid car id");
            return;
        }

        User user = userService.locateUser(id);
        Car car = carService.locateCar(carMake);

        if(userService.getUsers().contains(user) && user.getAge() < 21) {
            System.out.println("Booking failed - users have to be 21 or older to book a car through AMC Software Booking Service");
            return;
        }

        if(user == null || car == null) {
            System.out.println("invalid or booked id or car - check the id/car and try rebooking");
            return;
        }

       bookingDao.saveBooking(new Booking(UUID.fromString(id), car));

       removeUser(user);

       removeCar(car);
    }

    public void getUserBooking(String id) {
        Booking locatedBooking = null;

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

    public static List<Booking> getAllBookings() {
        return BookingDao.getBookings();
    }

}
