package com.aknur.clothingstore;

public class Pants extends ClothingItem {
    private int waistSize;

    public Pants(int itemId, String name, String size, double price, String brand, int waistSize) {
        super(itemId, name, size, price, brand);
        this.waistSize = waistSize;
    }

    @Override
    public void displayInfo() {
        System.out.println("Pants: " + name + ", waist: " + waistSize + ", price: " + price);
    }

    @Override
    public String getCategory() {
        return "Pants";
    }

    public boolean isLargeWaist() {
        return waistSize >= 34;
    }

    public void ironPants() {
        System.out.println("Pants " + name + " are ironed.");
    }
}
