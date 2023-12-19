package com.solvd.shop.models.shop;

import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.models.people.Supplier;

import java.util.Date;

public class Product {

    private int idProduct;
    private String productName;
    private double price;
    private Supplier idSupplier;
    private Category idCategory;
    private int availableQuantity;

    public Product() {
    }

    public Product(int idProduct, String productName, double price, Supplier idSupplier, Category idCategory, int availableQuantity) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.idSupplier = idSupplier;
        this.idCategory = idCategory;
        this.availableQuantity = availableQuantity;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    public Supplier getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Supplier idSupplier) {
        this.idSupplier = idSupplier;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
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
                "idProduct=" + idProduct +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", idSupplier=" + idSupplier +
                ", idCategory=" + idCategory +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}
