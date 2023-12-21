package com.solvd.shop.jdbc.dao.shop;

import com.solvd.shop.interafaces.shop.IOrderHasProductDAO;
import com.solvd.shop.models.shop.Order;
import com.solvd.shop.models.shop.OrderHasProduct;
import com.solvd.shop.models.shop.Product;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHasProductDAO implements IOrderHasProductDAO<OrderHasProduct> {

    private final ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(OrderHasProductDAO.class);

    public OrderHasProductDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void insert(OrderHasProduct orderHasProduct) {
        String query = "INSERT INTO orders_has_products (id_order, id_product) VALUES ((?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, orderHasProduct.getIdOrder().getIdOrder());
            statement.setInt(2, orderHasProduct.getIdProduct().getIdProduct());

            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void update(OrderHasProduct orderHasProduct) {
        String query = "UPDATE orders_has_products SET id_product = (?) WHERE id_order = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, orderHasProduct.getIdProduct().getIdProduct());
            statement.setInt(2, orderHasProduct.getIdOrder().getIdOrder());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void delete(OrderHasProduct orderHasProduct) {
        String query = "DELETE FROM orders_has_products WHERE id_order = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, orderHasProduct.getIdOrder().getIdOrder());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public OrderHasProduct getByID(int id) {
        String query = "SELECT * FROM orders_has_products WHERE id_order = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    Product product = new Product();
                    order.setIdOrder(resultSet.getInt("id_order"));
                    product.setIdProduct(resultSet.getInt("id_product"));
                    return new OrderHasProduct(order, product);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return null;
    }

    @Override
    public List<OrderHasProduct> getAll() {
        List<OrderHasProduct> orderHasProductList = new ArrayList<>();
        String query = "SELECT * FROM orders_has_products";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    Product product = new Product();
                    order.setIdOrder(resultSet.getInt("id_order"));
                    product.setIdProduct(resultSet.getInt("id_product"));
                    OrderHasProduct orderHasProduct = new OrderHasProduct(order, product);
                    orderHasProductList.add(orderHasProduct);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return orderHasProductList;
    }

    @Override
    public List<OrderHasProduct> getAllByProductId(int id) {
        List<OrderHasProduct> orderHasProductList = new ArrayList<>();
        String query = "SELECT * FROM orders_has_products WHERE id_product = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    Product product = new Product();
                    order.setIdOrder(resultSet.getInt("id_order"));
                    product.setIdProduct(resultSet.getInt("id_product"));
                    OrderHasProduct orderHasProduct = new OrderHasProduct(order, product);
                    orderHasProductList.add(orderHasProduct);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return orderHasProductList;
    }
}
