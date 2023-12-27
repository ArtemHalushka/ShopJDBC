package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IOrderHasProductDAO;
import com.solvd.shop.models.shop.OrderHasProduct;
import com.solvd.shop.models.shop.Product;
import com.solvd.shop.mybatis.dao.shop.OrderHasProductDAO;

import java.util.List;

public class OrderHasProductService implements IOrderHasProductDAO<OrderHasProduct, Product> {

    private static final OrderHasProductDAO batisDAO = new OrderHasProductDAO();

    @Override
    public void insert(OrderHasProduct orderHasProduct) {
        batisDAO.insert(orderHasProduct);
    }

    @Override
    public void update(OrderHasProduct orderHasProduct) {
        batisDAO.update(orderHasProduct);
    }

    @Override
    public void delete(OrderHasProduct orderHasProduct) {
        batisDAO.delete(orderHasProduct);
    }

    @Override
    public OrderHasProduct getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<OrderHasProduct> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public List<Product> getAllByOrderId(int id) {
        return batisDAO.getAllByOrderId(id);
    }
}