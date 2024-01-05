package com.solvd.shop.services.shop;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.shop.IProductDAO;
import com.solvd.shop.models.shop.Product;
import com.solvd.shop.mybatis.dao.shop.ProductDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductService implements IProductDAO<Product> {

    private static final Logger LOGGER = LogManager.getLogger(ProductService.class);

    private static ProductDAO productDAO = null;

    static {
        try {
            productDAO = (ProductDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("products");
        } catch (ConnectionDAOException e) {
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