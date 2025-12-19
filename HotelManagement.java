import java.util.Scanner;

class Hotel {
    String name;
    String address;

    Hotel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    void showHotelInfo() {
        System.out.println("\n====================================");
        System.out.println("     Welcome to " + name);
        System.out.println(" Address: " + address);
        System.out.println("====================================\n");
    }
}

abstract class Room {
    String roomType;
    double pricePerDay;
    boolean booked;

    Room(String roomType, double pricePerDay) {
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.booked = false;
    }

    abstract void showDetails();

    void bookRoom(String customerName, int days) {
        if (!booked) {
            booked = true;
            double total = pricePerDay * days;
            System.out.println(customerName + " booked the " + roomType + " for " + days + " days.");
            System.out.println("Total Price: Rs. " + total);
        } else {
            System.out.println(roomType + " is already booked!");
        }
    }
}

class StandardRoom extends Room {
    StandardRoom(double pricePerDay) {
        super("Standard Room", pricePerDay);
    }

    void showDetails() {
        System.out.println(roomType + " | Price per day: Rs." + pricePerDay);
        System.out.println("Facilities: Bed, Fan, Bathroom, and TV.");
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(double pricePerDay) {
        super("Deluxe (Luxury) Room", pricePerDay);
    }

    void showDetails() {
        System.out.println(roomType + " | Price per day: Rs." + pricePerDay);
        System.out.println("Facilities: AC, Wi-Fi, Mini Bar, and Smart TV.");
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    void bookRoom(Room room, int days) {
        room.bookRoom(name, days);
    }
}

public class HotelManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Fixed hotel info
        Hotel hotel = new Hotel("HOTELY", "ABC Road");
        hotel.showHotelInfo();

        // Room setup
        Room standard = new StandardRoom(5000);
        Room deluxe = new DeluxeRoom(9000);

        System.out.println("---- ROOM DETAILS ----");
        standard.showDetails();
        System.out.println();
        deluxe.showDetails();

        // Customer info
        System.out.print("\nEnter your name: ");
        String custName = sc.nextLine();
        Customer customer = new Customer(custName);

        // Room selection
        System.out.print("Choose room to book (1 for Standard, 2 for Deluxe): ");
        int choice = sc.nextInt();

        System.out.print("Enter number of days to stay: ");
        int days = sc.nextInt();

        System.out.println("\n---- BOOKING DETAILS ----");
        if (choice == 1) {
            customer.bookRoom(standard, days);
        } else if (choice == 2) {
            customer.bookRoom(deluxe, days);
        } else {
            System.out.println("Invalid room choice!");
        }

        System.out.println("\nThank you for choosing HOTELY! Have a pleasant stay!");
        sc.close();
    }
}
