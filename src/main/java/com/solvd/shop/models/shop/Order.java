package com.solvd.shop.models.shop;

import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;

import java.sql.Date;

public class Order {

    private int idOrder;
    private Date date;
    private Status idStatus;
    private double orderTotal;
    private Buyer idBuyer;
    private Employee idEmployee;

    public Order() {
    }

    public Order(int idOrder, Date date, Status idStatus, double orderTotal, Buyer idBuyer, Employee idEmployee) {
        this.idOrder = idOrder;
        this.date = date;
        this.idStatus = idStatus;
        this.orderTotal = orderTotal;
        this.idBuyer = idBuyer;
        this.idEmployee = idEmployee;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Buyer getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(Buyer idBuyer) {
        this.idBuyer = idBuyer;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", date=" + date +
                ", idStatus=" + idStatus +
                ", orderTotal=" + orderTotal +
                ", idBuyer=" + idBuyer +
                ", idEmployee=" + idEmployee +
                '}';
    }
}
