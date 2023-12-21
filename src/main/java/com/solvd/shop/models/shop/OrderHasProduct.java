package com.solvd.shop.models.shop;

public class OrderHasProduct {

    private Order order;
    private Product product;

    public OrderHasProduct() {
    }

    public OrderHasProduct(Order order, Product product) {
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
