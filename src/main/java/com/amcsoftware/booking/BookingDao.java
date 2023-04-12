package com.amcsoftware.booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    private static List<Booking> bookings;

    public BookingDao() {
        bookings = new ArrayList<>();
    }

    public static List<Booking> getBookings() {
        return bookings;
    }

    public void saveBooking(Booking booking) {
        bookings.add(booking);
        System.out.println(booking.getCar().getMake() + " has been booked " + LocalDateTime.now() );
    }
}
