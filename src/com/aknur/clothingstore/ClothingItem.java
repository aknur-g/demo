package com.aknur.clothingstore;

public abstract class ClothingItem implements Discountable {
    protected int itemId;
    protected String name;
    protected String size;
    protected double price;
    protected String brand;

    public ClothingItem(int itemId, String name, String size, double price, String brand) {
        setItemId(itemId);
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
    }

    public abstract void displayInfo();
    public String getCategory() {
        return "Clothing Item";
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
        if ( itemId < 0){
            throw new NumberFormatException("ID cannot be negative, please try again.");
        }this.itemId = itemId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } this.name = name;
    }

    public void setSize(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("Size cannot be empty.");
        } this.size = size;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new NumberFormatException("Price cannot be negative.");
        }this.price = price;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty.");
        } this.brand = brand;
    }

    @Override
    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Invalid discount percent.");
        } price -= price * percent / 100;
    }

    @Override
    public String toString() {
        return "ClothingItem{ itemId=" + itemId +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }

}
