package com.solvd.shop.jdbc.dao.shop;

import com.solvd.shop.interfaces.shop.ICategoryDAO;
import com.solvd.shop.models.shop.Category;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO<Category> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CategoryDAO.class);

    @Override
    public void insert(Category category) {
        String query = "INSERT INTO categories (category) VALUES ((?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, category.getCategoryName());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void update(Category category) {
        String query = "UPDATE categories SET category = (?) WHERE id_category = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, category.getCategoryName());
            statement.setInt(2, category.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void delete(Category category) {
        String query = "DELETE FROM categories WHERE id_category = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, category.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public Category getByID(int id) {
        String query = "SELECT * FROM categories WHERE id_category = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Category(resultSet.getInt("id_category"), resultSet.getString("category"));
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
    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<>();
        String query = "SELECT * FROM categories";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {

                    Category category = new Category(resultSet.getInt("id_category"), resultSet.getString("category"));
                    categoryList.add(category);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return categoryList;
    }


    @Override
    public Category getByCategoryName(String name) {
        String query = "SELECT * FROM categories WHERE category = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Category(resultSet.getInt("id_category"), resultSet.getString("category"));
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
