package com.solvd.shop.interfaces.shop;

import com.solvd.shop.interfaces.IBaseDAO;

public interface IProductDAO<Product> extends IBaseDAO<Product> {

    Product getByProductName(String name);
}
