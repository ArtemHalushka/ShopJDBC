package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.ICategoryDAO;
import com.solvd.shop.models.shop.Category;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.shop.mybatis.dao.shop.CategoryDAO;

import java.util.List;

public class CategoryService implements ICategoryDAO<Category> {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);
    private static final CategoryDAO batisDAO = new CategoryDAO();

    @Override
    public void insert(Category category) {
        batisDAO.insert(category);
    }

    @Override
    public void update(Category category) {
        batisDAO.update(category);
    }

    @Override
    public void delete(Category category) {
        batisDAO.delete(category);
    }

    @Override
    public Category getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<Category> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Category getByCategoryName(String name) {
        return batisDAO.getByCategoryName(name);
    }
}
