package com.aknur.clothingstore;

import menu.Menu;
import menu.MenuManager;
import database.ClothingItemDAO;

public class Main {
    public static void main(String[] args) {

        Menu menu = new MenuManager();
        menu.run();
    }
}
