package com.solvd.shop.models.shop;

import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;

import java.sql.Date;

public class Order {

    private int orderId;
    private Date date;
    private Status status;
    private double orderTotal;
    private Buyer buyer;
    private Employee employee;

    public Order() {
    }

    public Order(int orderId, Date date, Status status, double orderTotal, Buyer buyer, Employee employee) {
        this.orderId = orderId;
        this.date = date;
        this.status = status;
        this.orderTotal = orderTotal;
        this.buyer = buyer;
        this.employee = employee;
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
                "idOrder=" + orderId +
                ", date=" + date +
                ", idStatus=" + status +
                ", orderTotal=" + orderTotal +
                ", idBuyer=" + buyer +
                ", idEmployee=" + employee +
                '}';
    }
}
