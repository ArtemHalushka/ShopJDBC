package com.solvd.shop.services.shop;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.shop.ICategoryDAO;
import com.solvd.shop.models.shop.Category;
import com.solvd.shop.mybatis.dao.shop.CategoryDAO;
import com.solvd.shop.services.address.CountryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CategoryService implements ICategoryDAO<Category> {

    private static final Logger LOGGER = LogManager.getLogger(CountryService.class);

    private static CategoryDAO categoryDAO = null;

    static {
        try {
            categoryDAO = (CategoryDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("categories");
        } catch (ConnectionDAOException e) {
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
