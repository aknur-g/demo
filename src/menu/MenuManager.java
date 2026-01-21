package menu;

import com.aknur.clothingstore.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<ClothingItem> items;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;
    private Scanner scanner;

    public MenuManager() {
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        items.add(new Pants(1, "Classic Pants", "M", 25000, "Lichi", 32));
        items.add(new Skirt(2, "Autumn Skirt", "S", 18000, "Bershka", "midi"));

        customers.add(new Customer(1, "Aknur", "S", 90));
        customers.add(new Customer(2, "Moritz Hau", "L", 150));

        orders.add(new Order(1001, "Aknur", 38000, "Completed"));
        orders.add(new Order(1002, "Moritz Hau", 8000, "Pending"));
    }

    private void viewAllItems() {
        if (items.isEmpty()) {
            System.out.println("No clothing items found.");
            return;
        }

        for (ClothingItem item : items) {
            System.out.println(item);
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- Polymorphism Demo ---");

        for (ClothingItem item : items) {
            item.displayInfo();
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== CLOTHING STORE SYSTEM ===");
        System.out.println("1. Add Clothing Item");
        System.out.println("2. View All Clothing Items");
        System.out.println("3. Polymorphism demo");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addClothingItem();
                        break;
                    case 2:
                        viewAllItems();
                        break;
                    case 3:
                        demonstratePolymorphism();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void addClothingItem() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Size: ");
            String size = scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Brand: ");
            String brand = scanner.nextLine();

            ClothingItem item = new Pants(id, name, size, price, brand, 32);
            item.applyDiscount(10);

            items.add(item);

            System.out.println("Item added successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }
}

