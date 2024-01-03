package com.solvd.shop.models.shop;

import com.solvd.shop.models.people.Supplier;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "product")
@XmlType(propOrder = {"productId", "productName", "price", "supplier", "category", "availableQuantity"})
public class Product {

    @XmlAttribute(name = "id")
    private int productId;
    @XmlElement(name = "productName")
    private String productName;
    @XmlElement(name = "price")
    private double price;
    @XmlElement(name = "supplier")
    private Supplier supplier;
    @XmlElement(name = "category")
    private Category category;
    @XmlElement(name = "availableQuantity")
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
