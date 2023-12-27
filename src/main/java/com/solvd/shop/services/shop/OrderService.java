package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IOrderDAO;
import com.solvd.shop.mybatis.dao.shop.OrderDAO;
import com.solvd.shop.models.shop.Order;

import java.sql.Date;
import java.util.List;

public class OrderService implements IOrderDAO<Order> {

    private static final OrderDAO batisDAO = new OrderDAO();

    @Override
    public void insert(Order order) {
        batisDAO.insert(order);
    }

    @Override
    public void update(Order order) {
        batisDAO.update(order);
    }

    @Override
    public void delete(Order order) {
        batisDAO.delete(order);
    }

    @Override
    public Order getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<Order> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Order getByDate(Date date) {
        return batisDAO.getByDate(date);
    }
}
