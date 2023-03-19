package com.amcsoftware.booking;

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
            System.out.println(booking.getCar().getMake() + " has been booked");
        }catch (IndexOutOfBoundsException e) {

        }
    }
}
