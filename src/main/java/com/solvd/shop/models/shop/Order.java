package com.solvd.shop.models.shop;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.parser.adapter.JAXBDateAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.sql.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "order")
@XmlType(propOrder = {"orderId", "date", "status", "orderTotal", "buyer", "employee", "products"})
public class Order {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int orderId;

    @XmlJavaTypeAdapter(JAXBDateAdapter.class)
    @XmlElement(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("date")
    private Date date;

    @XmlElement(name = "status")
    @JsonProperty("status")
    private Status status;

    @XmlElement(name = "orderTotal")
    @JsonProperty("orderTotal")
    private double orderTotal;

    @XmlElement(name = "buyer")
    @JsonProperty("buyer")
    private Buyer buyer;

    @XmlElement(name = "employee")
    @JsonProperty("employee")
    private Employee employee;

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product", type = Product.class)
    @JsonProperty("products")
    private List<Product> products;

    public Order() {
    }

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        this.date = builder.date;
        this.status = builder.status;
        this.orderTotal = builder.orderTotal;
        this.buyer = builder.buyer;
        this.employee = builder.employee;
        this.products = builder.products;
    }

    public static class Builder {

        private final int orderId;
        private Date date;
        private Status status;
        private double orderTotal;
        private final Buyer buyer;
        private Employee employee;
        private final List<Product> products;

        public Builder(int orderId, Buyer buyer, List<Product> products) {
            if (buyer == null || products == null) {
                throw new IllegalArgumentException("id, buyer and products can not be null");
            }
            this.orderId = orderId;
            this.buyer = buyer;
            this.products = products;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder orderTotal(double orderTotal) {
            this.orderTotal = orderTotal;
            return this;
        }

        public Builder employee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Employee getEmployee() {
        return employee;
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
