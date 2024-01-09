package com.solvd.shop.services.shop;

import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.shop.IOrderHasProductDAO;
import com.solvd.shop.jdbc.dao.shop.OrderHasProductDAO;
import com.solvd.shop.models.shop.OrderHasProduct;
import com.solvd.shop.models.shop.Product;

import java.util.List;

public class OrderHasProductService implements IOrderHasProductDAO<OrderHasProduct, Product> {

    private static final OrderHasProductDAO orderHasProductDAO = (OrderHasProductDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("orders_has_products");

    @Override
    public void insert(OrderHasProduct orderHasProduct) {
        orderHasProductDAO.insert(orderHasProduct);
    }

    @Override
    public void update(OrderHasProduct orderHasProduct) {
        orderHasProductDAO.update(orderHasProduct);
    }

    @Override
    public void delete(OrderHasProduct orderHasProduct) {
        orderHasProductDAO.delete(orderHasProduct);
    }

    @Override
    public OrderHasProduct getByID(int id) {
        return orderHasProductDAO.getByID(id);
    }

    @Override
    public List<OrderHasProduct> getAll() {
        return orderHasProductDAO.getAll();
    }

    @Override
    public List<Product> getAllByOrderId(int id) {
        return orderHasProductDAO.getAllByOrderId(id);
    }
}