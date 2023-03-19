package com.amcsoftware;

import com.amcsoftware.booking.BookingService;
import com.amcsoftware.car.Car;
import com.amcsoftware.car.CarService;
import com.amcsoftware.user.UserService;

import java.util.Arrays;

import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        BookingService bookingService = new BookingService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to AMC Software Car Booking Service\n ");

        menu();

        boolean isAnswerYes = false;

        while(!isAnswerYes) {
            try {
                int answer = Integer.parseInt(scanner.nextLine());
                switch (answer) {
                    case 1:
                        System.out.println("Enter your user id\n ");
                        String id = scanner.nextLine();
                        System.out.println("Enter a car make");
                        String car = scanner.nextLine();
                        bookingService.bookACar(id, car);
                        menu();
                        break;
                    case 2:
                        System.out.println(Arrays.toString(BookingService.getAllBookings()));
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println(Arrays.toString(CarService.getCars()));
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println(Arrays.toString(UserService.getUsers()));
                        menu();
                        break;
                    case 7:
                        System.out.println("Exit Complete");
                        isAnswerYes = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid character\nEnter only character 1-7");
//                scanner.nextLine();
//                System.out.println("Enter");
            }



        }

    }

    public static void menu() {
        System.out.println("\n\tEnter a number 1 - 7\n");
        System.out.println(
              "1️⃣ - Book Car \n2️⃣ - View All User Booked Cars\n3️⃣ - View All Bookings" +
                      "\n4️⃣ - View Available Cars\n5️⃣ - View Available Electric Cars\n6️⃣ - View all users\n7️⃣ - Exit");

    }
}
