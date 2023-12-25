package com.solvd.shop.jdbc.dao.shop;

import com.solvd.shop.interfaces.shop.IProductDAO;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.models.shop.Category;
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

public class ProductDAO implements IProductDAO<Product> {

    private final ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(ProductDAO.class);

    public ProductDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void insert(Product product) {
        String query = "INSERT INTO products (name, price, id_supplier, id_category, available_quantity) VALUES ((?), (?), (?), (?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getSupplier().getSupplierId());
            statement.setInt(4, product.getCategory().getCategoryId());
            statement.setInt(5, product.getAvailableQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void update(Product product) {
        String query = "UPDATE products SET name = (?), price = (?), id_supplier = (?), id_category = (?), available_quantity = (?) WHERE id_product = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getSupplier().getSupplierId());
            statement.setInt(4, product.getCategory().getCategoryId());
            statement.setInt(5, product.getAvailableQuantity());
            statement.setInt(6, product.getProductId());

            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void delete(Product product) {
        String query = "DELETE FROM products WHERE id_product = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, product.getProductId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public Product getByID(int id) {
        String query = "SELECT * FROM products WHERE id_product = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Supplier supplier = new Supplier();
                    Category category = new Category();
                    supplier.setSupplierId(resultSet.getInt("id_supplier"));
                    category.setCategoryId(resultSet.getInt("id_category"));

                    return new Product(resultSet.getInt("id_product"), resultSet.getString("name"), resultSet.getDouble("price"), supplier, category, resultSet.getInt("available_quantity"));
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
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM products";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Supplier supplier = new Supplier();
                    Category category = new Category();
                    supplier.setSupplierId(resultSet.getInt("id_supplier"));
                    category.setCategoryId(resultSet.getInt("id_category"));

                    Product product = new Product(resultSet.getInt("id_product"), resultSet.getString("name"), resultSet.getDouble("price"), supplier, category, resultSet.getInt("available_quantity"));
                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return productList;
    }

    @Override
    public Product getByProductName(String name) {
        String query = "SELECT * FROM products WHERE name = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Supplier supplier = new Supplier();
                    Category category = new Category();
                    supplier.setSupplierId(resultSet.getInt("id_supplier"));
                    category.setCategoryId(resultSet.getInt("id_category"));

                    return new Product(resultSet.getInt("id_product"), resultSet.getString("name"), resultSet.getDouble("price"), supplier, category, resultSet.getInt("available_quantity"));
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
