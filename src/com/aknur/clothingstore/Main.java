package com.aknur.clothingstore;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Clothing Store Management System!!");
        System.out.println("This system will help manage clothing items and categories easily.");
        System.out.println("It will allow adding new products, updating inventory, and viewing sales.");
        System.out.println("Future updates will include customer management and order tracking.");
        System.out.println("Project initialized successfully by Galymzhankyzy Aknur IT-2501");

        System.out.println("=== Clothing Store Management System ===\n");

        ClothingItem item1 = new ClothingItem(101, "Jacket", "L", 25000, "Zara");
        ClothingItem item2 = new ClothingItem(102, "T-Shirt", "M", 8000, "Qazaq Republic");
        ClothingItem item3 = new ClothingItem();

        Customer customer1 = new Customer(1, "Aknur Galymzhankyzy", "S", 90);
        Customer customer2 = new Customer(2, "Moritz Hau", "L", 150);

        Order order1 = new Order(5001, customer1.getName(), 0.0, "Pending");


        System.out.println("--- CLOTHING ITEMS ---");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println();

        System.out.println("--- CUSTOMERS ---");
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println();

        System.out.println("--- ORDER ---");
        System.out.println(order1);
        System.out.println();

        System.out.println("--- TESTING GETTERS ---");
        System.out.println("Item1 price: " + item1.getPrice());
        System.out.println("Customer1 points: " + customer1.getLoyaltyPoints());
        System.out.println();

        System.out.println("--- TESTING SETTERS ---");
        item3.setName("Jeans");
        item3.setPrice(15000);
        item3.setBrand("Levis");
        System.out.println(item3);
        System.out.println();

        System.out.println("--- TESTING METHODS ---");
        item1.applyDiscount(10);
        System.out.println("Discounted item1 price: " + item1.getPrice());
        System.out.println("Item1 is premium: " + item1.isPremium());

        customer1.addPoints(20);
        System.out.println("Customer1 VIP: " + customer1.isVIP());

        order1.addAmount(item1.getPrice());
        order1.completeOrder();
        System.out.println(order1);

        System.out.println("\n=== Program Complete ===");
    }
}
