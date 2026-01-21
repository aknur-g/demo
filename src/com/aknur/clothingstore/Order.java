package com.aknur.clothingstore;

public class Order {
    private int orderId;
    private String customerName;
    private double totalAmount;
    private String status;

    public Order(int orderId, String customerName, double totalAmount, String status) {
        this.orderId = orderId;
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setStatus(status);
    }

    public Order() {
        this.orderId = 0;
        this.customerName = "Unknown";
        this.totalAmount = 0.0;
        this.status = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public String getStatus() {
        return status;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } this.customerName = customerName;
    }
    public void setTotalAmount(double totalAmount) {
        if (totalAmount < 0){
            throw new NumberFormatException(" Amount cannot be negative.");
        } this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addAmount(double amount) {
        if (amount > 0) {
            totalAmount += amount;
        }
    }

    public void completeOrder() {
        status = "Completed";
    }

    public boolean isPending() {
        return "Pending".equals(status);
    }

    @Override
    public String toString() {
        return "Order{orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
