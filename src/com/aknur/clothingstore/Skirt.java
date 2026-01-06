package com.aknur.clothingstore;

public class Skirt extends ClothingItem {

    private String length;

    public Skirt(int itemId, String name, String size, double price, String brand, String length) {
        super(itemId, name, size, price, brand);
        this.length = length;
    }
    @Override
    public void displayInfo() {
        System.out.println(
                "Skirt: " + name +
                        ", length: " + length +
                        ", price: " + price
        );
    }

    @Override
    public String getCategory() {
        return "Skirt";
    }
    public String getLengthType() {
        return length;
    }
}
