package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IProductDAO;
import com.solvd.shop.models.shop.Product;
import com.solvd.shop.mybatis.dao.shop.ProductDAO;

import java.util.List;

public class ProductService implements IProductDAO<Product> {

    private static final ProductDAO productDAO = new ProductDAO();

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