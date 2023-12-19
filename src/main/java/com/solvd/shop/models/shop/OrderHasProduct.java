package com.solvd.shop.models.shop;

public class OrderHasProduct {

    private Order idOrder;
    private Product idProduct;

    public OrderHasProduct() {
    }

    public OrderHasProduct(Order idOrder, Product idProduct) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
    }

    public Order getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Order idOrder) {
        this.idOrder = idOrder;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String toString() {
        return "OrderHasProduct{" +
                "idOrder=" + idOrder +
                ", idProduct=" + idProduct +
                '}';
    }
}
