package com.aknur.clothingstore;

public class Customer {
    private int customerId;
    private String name;
    private String preferredSize;
    private int loyaltyPoints;

    public Customer(int customerId, String name, String preferredSize, int loyaltyPoints) {
        this.customerId = customerId;
        setName(name);
        setPreferredSize(preferredSize);
        setLoyaltyPoints(loyaltyPoints);
    }

    public Customer() {
        this.customerId = 0;
        this.name = "Unknown Customer";
        this.preferredSize = "S";
        this.loyaltyPoints = 0;
    }

    public int getCustomerId (){
        return customerId;
    }
    public String getName() {
        return name;
    }

    public String getPreferredSize() {
        return preferredSize;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        this.name = name;
    }

    public void setPreferredSize(String preferredSize) {
        if (preferredSize == null || preferredSize.isEmpty()) {
            throw new IllegalArgumentException("Preferred size cannot be empty");
        }
        this.preferredSize = preferredSize;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            this.loyaltyPoints = 0;
        }
    }

    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    public boolean isVIP() {
        return loyaltyPoints >= 100;
    }

    @Override
    public String toString() {
        return "Customer{customerId=" + customerId +
                ", name='" + name + '\'' +
                ", preferredSize='" + preferredSize + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}

