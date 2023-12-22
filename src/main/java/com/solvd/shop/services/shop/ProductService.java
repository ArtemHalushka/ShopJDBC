package com.solvd.shop.services.shop;

import com.solvd.shop.interafaces.shop.IProductDAO;
import com.solvd.shop.jdbc.dao.shop.ProductDAO;
import com.solvd.shop.models.shop.Product;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductDAO<Product> {

    private static ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(ProductService.class);

    private static final ProductDAO productDAO = new ProductDAO(connectionPool);

    static {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void insert(Product product) {
        productDAO.insert(product);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void delete(Product product) {
        productDAO.delete(product);
    }

    @Override
    public Product getByID(int id) {
        return productDAO.getByID(id);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public Product getByProductName(String name) {
        return productDAO.getByProductName(name);
    }
}
