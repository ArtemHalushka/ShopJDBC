package com.solvd.shop.models.shop;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;

import java.sql.Date;
import java.util.List;

public class Order {

    @JsonProperty("id")
    private int orderId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("date")
    private Date date;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("orderTotal")
    private double orderTotal;

    @JsonProperty("buyer")
    private Buyer buyer;

    @JsonProperty("employee")
    private Employee employee;

    @JsonProperty("products")
    private List<Product> products;

    public Order() {
    }

    public Order(int orderId, Date date, Status status, double orderTotal, Buyer buyer, Employee employee, List<Product> products) {
        this.orderId = orderId;
        this.date = date;
        this.status = status;
        this.orderTotal = orderTotal;
        this.buyer = buyer;
        this.employee = employee;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", status=" + status +
                ", orderTotal=" + orderTotal +
                ", buyer=" + buyer +
                ", employee=" + employee +
                ", products=" + products +
                '}';
    }
}
