package com.aknur.clothingstore;

public class ClothingItem {
    private int itemId;
    private String name;
    private String size;
    private double price;
    private String brand;

    public ClothingItem( int ItemID, String name, String size, double price, String brand ) {
        this.itemId = itemId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.brand = brand;
    }

    public ClothingItem (){
        this.itemId = 0;
        this.name = "Unknown Item";
        this.size = "S";
        this.price = 0.0;
        this.brand = "No Brand";
    }
    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public void setItemId( int itemId) {
        this.itemId = itemId;
    }
    public void setName( String name){
        this.name = name;
    }
    public void setSize(String size){
        this.size = size;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }

    public void applyDiscount(double percentage) {
        price = price * (1 - percentage / 100);
    }

    public boolean isPremium(){
        return price > 25000;
    }
    @Override
    public String toString() {
        return "ClothingItem{itemId=" + itemId +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }

}
