package com.aknur.clothingstore;

public class BasicClothingItem extends ClothingItem {

    public BasicClothingItem(int id, String name, String size, double price, String brand) {
        super(id, name, size, price, brand);
    }
    @Override
    public void displayInfo() {
        System.out.println(
                "Item: " + getName() +
                        ", Size: " + getSize() +
                        ", Price: " + getPrice() +
                        ", Brand: " + getBrand()
        );
    }
    @Override
    public String getCategory() {
        return "Clothing item";
    }
}
