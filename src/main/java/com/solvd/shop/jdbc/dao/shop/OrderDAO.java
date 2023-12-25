package com.solvd.shop.jdbc.dao.shop;

import com.solvd.shop.interfaces.shop.IOrderDAO;
import com.solvd.shop.jdbc.dao.people.BuyerDAO;
import com.solvd.shop.jdbc.dao.people.EmployeeDAO;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.models.shop.Order;
import com.solvd.shop.models.shop.Product;
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
    private final EmployeeDAO employeeDAO;
    private final BuyerDAO buyerDAO;
    private final StatusDAO statusDAO;
    private final OrderHasProductDAO orderHasProductDAO;

    public OrderDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.employeeDAO = new EmployeeDAO(connectionPool);
        this.buyerDAO = new BuyerDAO(connectionPool);
        this.statusDAO = new StatusDAO(connectionPool);
        this.orderHasProductDAO = new OrderHasProductDAO(connectionPool);
    }

    @Override
    public void insert(Order order) {
        String query = "INSERT INTO orders (date, id_status, order_total, id_buyer, id_employee) VALUES ((?), (?), (?), (?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setDate(1, order.getDate());
            statement.setInt(2, order.getStatus().getStatusId());
            statement.setDouble(3, order.getOrderTotal());
            statement.setInt(4, order.getBuyer().getBuyerId());
            statement.setInt(5, order.getEmployee().getEmployeeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void update(Order order) {
        String query = "UPDATE orders SET date = (?), id_status = (?), order_total = (?), id_buyer = (?), id_employee = (?) WHERE id_order = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setDate(1, order.getDate());
            statement.setInt(2, order.getStatus().getStatusId());
            statement.setDouble(3, order.getOrderTotal());
            statement.setInt(4, order.getBuyer().getBuyerId());
            statement.setInt(5, order.getEmployee().getEmployeeId());
            statement.setInt(6, order.getOrderId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void delete(Order order) {
        String query = "DELETE FROM orders WHERE id_order = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, order.getOrderId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
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
                    Status status = statusDAO.getByID(resultSet.getInt("id_status"));
                    Buyer buyer = buyerDAO.getByID(resultSet.getInt("id_buyer"));
                    Employee employee = employeeDAO.getByID(resultSet.getInt("id_employee"));
                    List<Product> products = orderHasProductDAO.getAllByOrderId(resultSet.getInt("id_order"));
                    return new Order(resultSet.getInt("id_order"), resultSet.getDate("date"), status, resultSet.getDouble("order_total"), buyer, employee, products);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
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
                    Status status = statusDAO.getByID(resultSet.getInt("id_status"));
                    Buyer buyer = buyerDAO.getByID(resultSet.getInt("id_buyer"));
                    Employee employee = employeeDAO.getByID(resultSet.getInt("id_employee"));
                    List<Product> products = orderHasProductDAO.getAllByOrderId(resultSet.getInt("id_order"));
                    Order order = new Order(resultSet.getInt("id_order"), resultSet.getDate("date"), status, resultSet.getDouble("order_total"), buyer, employee, products);
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
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
                    Status status = statusDAO.getByID(resultSet.getInt("id_status"));
                    Buyer buyer = buyerDAO.getByID(resultSet.getInt("id_buyer"));
                    Employee employee = employeeDAO.getByID(resultSet.getInt("id_employee"));
                    List<Product> products = orderHasProductDAO.getAllByOrderId(resultSet.getInt("id_order"));
                    return new Order(resultSet.getInt("id_order"), resultSet.getDate("date"), status, resultSet.getDouble("order_total"), buyer, employee, products);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return null;
    }
}
