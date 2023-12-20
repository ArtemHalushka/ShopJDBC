package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.shop.Product;

import java.util.List;

public interface IProductDAO extends IBaseDAO {

    Product getByProductName(String name);

    @Override
    Product getByID(int id);

    @Override
    List<Product> getAll();
}
