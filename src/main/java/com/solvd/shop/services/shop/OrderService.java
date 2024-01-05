package com.solvd.shop.services.shop;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.shop.IOrderDAO;
import com.solvd.shop.models.shop.Order;
import com.solvd.shop.mybatis.dao.shop.OrderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class OrderService implements IOrderDAO<Order> {

    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);

    private static OrderDAO orderDAO = null;

    static {
        try {
            orderDAO = (OrderDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("orders");
        } catch (ConnectionDAOException e) {
            LOGGER.info(e);
        }
    }

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
