package com.aknur.clothingstore;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<ClothingItem> items = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the Clothing Store Management System!!");
        System.out.println("This system will help manage clothing items and categories easily.");
        System.out.println("It will allow adding new products, updating inventory, and viewing sales.");
        System.out.println("Future updates will include customer management and order tracking.");
        System.out.println("Project initialized successfully by Galymzhankyzy Aknur IT-2501");
        System.out.println("\n=== Clothing Store Management System ===\n");

        items.add(new ClothingItem(1, "Jacket", "M", 30000, "Zara"));
        items.add(new ClothingItem(2, "T-Shirt", "L", 8000, "H&M"));

        customers.add(new Customer(1, "Aknur Galymzhankyzy", "S", 90));
        customers.add(new Customer(2, "Moritz Hau", "L", 150));

        orders.add(new Order(1001, "Aknur Galymzhankyzy", 38000, "Completed"));
        orders.add(new Order(1002, "Moritz Hau", 8000, "Pending"));

        // Step 3: Menu loop
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // IMPORTANT

            switch (choice) {
                case 1:
                    addClothingItem();
                    break;
                case 2:
                    viewAllItems();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    viewAllCustomers();
                    break;
                case 5:
                    addOrder();
                    break;
                case 6:
                    viewAllOrders();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== CLOTHING STORE SYSTEM ===");
        System.out.println("1. Add Clothing Item");
        System.out.println("2. View All Clothing Items");
        System.out.println("3. Add Customer");
        System.out.println("4. View All Customers");
        System.out.println("5. Add Order");
        System.out.println("6. View All Orders");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addClothingItem() {
        System.out.println("\n--- Add Clothing Item ---");

        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter size: ");
        String size = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();

        ClothingItem item = new ClothingItem(id, name, size, price, brand);
        items.add(item);

        System.out.println("Clothing item added successfully!");
    }

    private static void viewAllItems() {
        System.out.println("\n--- All Clothing Items ---");

        if (items.isEmpty()) {
            System.out.println("No clothing items found.");
            return;
        }

        for (ClothingItem item : items) {
            System.out.println(item);
        }
    }

    private static void addCustomer() {
        System.out.println("\n--- Add Customer ---");

        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter preferred size: ");
        String size = scanner.nextLine();

        System.out.print("Enter loyalty points: ");
        int points = scanner.nextInt();
        scanner.nextLine();

        Customer customer = new Customer(id, name, size, points);
        customers.add(customer);

        System.out.println("Customer added successfully!");
    }

    private static void viewAllCustomers() {
        System.out.println("\n--- All Customers ---");

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void addOrder() {
        System.out.println("\n--- Add Order ---");

        System.out.print("Enter order ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter total amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter status (Pending/Completed): ");
        String status = scanner.nextLine();

        Order order = new Order(id, name, amount, status);
        orders.add(order);

        System.out.println("Order added successfully!");
    }

    private static void viewAllOrders() {
        System.out.println("\n--- All Orders ---");

        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
