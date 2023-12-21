package com.solvd.shop.jdbc.dao.shop;

import com.solvd.shop.interafaces.shop.IOrderDAO;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.models.shop.Order;
import com.solvd.shop.models.shop.Status;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO<Order> {

    private final ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);

    public OrderDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void insert(Order order) {
        String query = "INSERT INTO orders (date, id_status, order_total, id_buyer, id_employee) VALUES ((?), (?), (?), (?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setDate(1, order.getDate());
            statement.setInt(2, order.getIdStatus().getIdStatus());
            statement.setDouble(3, order.getOrderTotal());
            statement.setInt(4, order.getIdBuyer().getIdBuyer());
            statement.setInt(5, order.getIdEmployee().getIdEmployee());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void update(Order order) {
        String query = "UPDATE orders SET date = (?), id_status = (?), order_total = (?), id_buyer = (?), id_employee = (?) WHERE id_order = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setDate(1, order.getDate());
            statement.setInt(2, order.getIdStatus().getIdStatus());
            statement.setDouble(3, order.getOrderTotal());
            statement.setInt(4, order.getIdBuyer().getIdBuyer());
            statement.setInt(5, order.getIdEmployee().getIdEmployee());
            statement.setInt(6, order.getIdOrder());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void delete(Order order) {
        String query = "DELETE FROM orders WHERE id_order = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, order.getIdOrder());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public Order getByID(int id) {
        String query = "SELECT * FROM orders WHERE id_order = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Status status = new Status();
                    Buyer buyer = new Buyer();
                    Employee employee = new Employee();
                    status.setIdStatus(resultSet.getInt("id_status"));
                    buyer.setIdBuyer(resultSet.getInt("id_buyer"));
                    employee.setIdEmployee(resultSet.getInt("id_employee"));

                    return new Order(resultSet.getInt("id_order"), resultSet.getDate("date"), status, resultSet.getDouble("order_total"), buyer, employee);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return null;
    }


    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        String query = "SELECT * FROM orders";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Status status = new Status();
                    Buyer buyer = new Buyer();
                    Employee employee = new Employee();
                    status.setIdStatus(resultSet.getInt("id_status"));
                    buyer.setIdBuyer(resultSet.getInt("id_buyer"));
                    employee.setIdEmployee(resultSet.getInt("id_employee"));

                    Order order = new Order(resultSet.getInt("id_order"), resultSet.getDate("date"), status, resultSet.getDouble("order_total"), buyer, employee);
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return orderList;
    }

    @Override
    public Order getByDate(Date date) {
        String query = "SELECT * FROM orders WHERE date = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setDate(1, date);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Status status = new Status();
                    Buyer buyer = new Buyer();
                    Employee employee = new Employee();
                    status.setIdStatus(resultSet.getInt("id_status"));
                    buyer.setIdBuyer(resultSet.getInt("id_buyer"));
                    employee.setIdEmployee(resultSet.getInt("id_employee"));

                    return new Order(resultSet.getInt("id_order"), resultSet.getDate("date"), status, resultSet.getDouble("order_total"), buyer, employee);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return null;
    }
}
