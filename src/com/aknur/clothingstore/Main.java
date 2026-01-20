package com.aknur.clothingstore;

import menu.MenuManager;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<ClothingItem> items = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        MenuManager menuManager =
                new MenuManager(items, customers, orders);

        menuManager.run();
    }
}
