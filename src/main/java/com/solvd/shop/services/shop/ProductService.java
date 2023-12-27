package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IProductDAO;
import com.solvd.shop.models.shop.Product;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.shop.mybatis.dao.shop.ProductDAO;

import java.util.List;

public class ProductService implements IProductDAO<Product> {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(ProductService.class);
    private static final ProductDAO batisDAO = new ProductDAO();

    @Override
    public void insert(Product product) {
        batisDAO.insert(product);
    }

    @Override
    public void update(Product product) {
        batisDAO.update(product);
    }

    @Override
    public void delete(Product product) {
        batisDAO.delete(product);
    }

    @Override
    public Product getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<Product> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Product getByProductName(String name) {
        return batisDAO.getByProductName(name);
    }
}