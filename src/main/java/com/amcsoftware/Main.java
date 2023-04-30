package com.amcsoftware;

import com.amcsoftware.booking.BookingDao;
import com.amcsoftware.booking.BookingService;
import com.amcsoftware.car.CarService;
import com.amcsoftware.user.UserArrayDataAccessService;
import com.amcsoftware.user.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BookingDao bookingDao = new BookingDao();
        CarService carService = new CarService();
        UserArrayDataAccessService userArrayDataAccessService = new UserArrayDataAccessService();

        UserService userService = new UserService(userArrayDataAccessService);
        BookingService bookingService = new BookingService(bookingDao, userService, carService);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to AMC Software Car Booking Service\n ");

        menu();

        boolean isAnswerYes = false;

        while(!isAnswerYes) {
            try {
                int answer = Integer.parseInt(scanner.nextLine());
                switch (answer) {
                    case 1:
                        System.out.println("Enter a user id\n ");
                        String id = scanner.nextLine();
                        System.out.println("Enter a car make");
                        String car = scanner.nextLine();
                        bookingService.bookACar(id, car);
                        menu();
                        break;
                    case 2:
                        System.out.println("Enter the user's id\n");
                        String userid = scanner.nextLine();
                        bookingService.getUserBooking(userid);
                        menu();
                        break;
                    case 3:
                        int bookingSize = BookingService.getAllBookings().size();
                        var viewBooking = bookingSize == 0 ? "no bookings" : BookingService.getAllBookings();
                        System.out.println(viewBooking);
                        menu();
                        break;
                    case 4:
                        System.out.println(CarService.getCars());
                        menu();
                        break;
                    case 5:
                        int availableElectricCarsSize = carService.getAvailableElectricCars().size();
                        var availableElectricCars = availableElectricCarsSize == 0 ? "no electric cars available" : carService.getAvailableElectricCars();
                        System.out.println(availableElectricCars);
                        menu();
                        break;
                    case 6:
                        System.out.println(userService.getUsers());
                        menu();
                        break;
                    case 7:
                        System.out.println("Exit Complete");
                        isAnswerYes = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid character\nEnter only characters 1-7");
            }
        }
    }

    public static void menu() {
        System.out.println("\nEnter a number 1 - 7\n");
        System.out.println(
              "1️⃣ - Book Car \n2️⃣ - View User Booking\n3️⃣ - View All Bookings" +
                      "\n4️⃣ - View Available Cars\n5️⃣ - View Available Electric Cars\n6️⃣ - View all users\n7️⃣ - Exit");

    }
}
