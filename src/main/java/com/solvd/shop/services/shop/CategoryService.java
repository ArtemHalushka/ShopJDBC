package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.ICategoryDAO;
import com.solvd.shop.models.shop.Category;
import com.solvd.shop.mybatis.dao.shop.CategoryDAO;

import java.util.List;

public class CategoryService implements ICategoryDAO<Category> {

    private static final CategoryDAO categoryDAO = new CategoryDAO();

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
