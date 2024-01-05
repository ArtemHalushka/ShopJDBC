package com.solvd.shop.services.shop;

import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.shop.IOrderDAO;
import com.solvd.shop.models.shop.Order;
import com.solvd.shop.mybatis.dao.shop.OrderDAO;

import java.sql.Date;
import java.util.List;

public class OrderService implements IOrderDAO<Order> {

    private static final OrderDAO orderDAO = (OrderDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("orders");

    @Override
    public void insert(Order order) {
        orderDAO.insert(order);
    }

    @Override
    public void update(Order order) {
        orderDAO.update(order);
    }

    @Override
    public void delete(Order order) {
        orderDAO.delete(order);
    }

    @Override
    public Order getByID(int id) {
        return orderDAO.getByID(id);
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public Order getByDate(Date date) {
        return orderDAO.getByDate(date);
    }
}
