package com.solvd.shop.models.shop;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orderHasProduct")
@XmlType(propOrder = {"order", "product"})
public class OrderHasProduct {

    @XmlElement(name = "order")
    private Order order;

    @XmlElement(name = "product")
    private Product product;

    public OrderHasProduct() {
    }

    public OrderHasProduct(Order order, Product products) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderHasProduct{" +
                "idOrder=" + order +
                ", idProduct=" + product +
                '}';
    }
}
