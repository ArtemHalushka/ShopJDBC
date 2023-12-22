package com.solvd.shop.models.shop;

import com.solvd.shop.models.people.Supplier;


public class Product {

    private int productId;
    private String productName;
    private double price;
    private Supplier supplier;
    private Category category;
    private int availableQuantity;

    public Product() {
    }

    public Product(int productId, String productName, double price, Supplier supplier, Category category, int availableQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.supplier = supplier;
        this.category = category;
        this.availableQuantity = availableQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", idSupplier=" + supplier +
                ", idCategory=" + category +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}
