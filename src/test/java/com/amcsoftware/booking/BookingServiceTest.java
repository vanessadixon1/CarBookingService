package com.amcsoftware.booking;

import com.amcsoftware.car.CarService;
import com.amcsoftware.user.User;
import com.amcsoftware.user.UserArrayDataAccessService;
import com.amcsoftware.user.UserService;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingServiceTest {
    BookingDao bookingDao = new BookingDao();
    CarService carService = new CarService();
    UserArrayDataAccessService userArrayDataAccessService = new UserArrayDataAccessService();
    UserService userService = new UserService(userArrayDataAccessService);
    BookingService bookingService = new BookingService(bookingDao,userService, carService);


    @ParameterizedTest(name = "Must Be 21 to Book")
    @ValueSource(strings = {"user has been booked", "successful booking", "Booking failed - users have to be 21 or older to book a car through AMC Software Booking Service" })
    public void validateUnderAgeBookingError(String arg) {
       bookingService.bookACar("adfa2477-74cc-49f2-a6fa-34c164f881b8", "Ford");
       assertEquals(arg, "Booking failed - users have to be 21 or older to book a car through AMC Software Booking Service" );
    }

    @ParameterizedTest(name = "validate Booking Msgs")
    @ValueSource(strings = {"17ffe8d2-870a-4e57-9070-90bf3260dce9" })
    public void validateUserBookingMessages(String args) {
        bookingService.bookACar("17ffe8d2-870a-4e57-9070-90bf3260dce9", "Ford");
        bookingService.getUserBooking(args);
        assertEquals("user "+args+" has the following booking", "user 17ffe8d2-870a-4e57-9070-90bf3260dce9 has the following booking");
        assertEquals("Booking{userid="+args+", car=Car{make='Ford', model='F150', engineType=Electric, price=209.99}}", "Booking{userid=17ffe8d2-870a-4e57-9070-90bf3260dce9, car=Car{make='Ford', model='F150', engineType=Electric, price=209.99}}");
    }

}
