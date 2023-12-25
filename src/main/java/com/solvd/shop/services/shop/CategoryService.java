package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.ICategoryDAO;
import com.solvd.shop.jdbc.dao.shop.CategoryDAO;
import com.solvd.shop.models.shop.Category;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryDAO<Category> {

    private static ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);

    private static final CategoryDAO categoryDAO = new CategoryDAO(connectionPool);

    static {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }


    @Override
    public void insert(Category category) {
        categoryDAO.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }

    @Override
    public void delete(Category category) {
        categoryDAO.delete(category);
    }

    @Override
    public Category getByID(int id) {
        return categoryDAO.getByID(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

    @Override
    public Category getByCategoryName(String name) {
        return categoryDAO.getByCategoryName(name);
    }
}
