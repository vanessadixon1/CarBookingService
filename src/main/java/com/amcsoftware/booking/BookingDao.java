package com.amcsoftware.booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BookingDao {
    private static Booking[] bookings;
    private static final int BOOKINGLIMIT = BookingService.AVAILABLECARS;
    private int nextAvailableCar = 0;

    public BookingDao() {
        bookings = new Booking[BOOKINGLIMIT];
    }

    public static Booking[] getBookings() {
        return bookings;
    }

    public void saveBooking(Booking booking) {
        try{
            bookings[nextAvailableCar++] = booking;
            System.out.println(booking.getCar().getMake() + " has been booked " + LocalDateTime.now() );
        }catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
