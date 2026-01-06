package com.aknur.clothingstore;

public class ClothingItem {
    private int itemId;
    private String name;
    private String size;
    private double price;
    private String brand;


    public ClothingItem(int itemId, String name, String size, double price, String brand) {
        this.itemId = itemId;
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
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

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }
    public void setSize(String size) {
        if (size != null && !size.isEmpty()) {
            this.size = size;
        } else {
            this.size = "S";
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative. Set to 0.");
            this.price = 0;
        }
    }
    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        } else {
            this.brand = "No Brand";
        }
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
