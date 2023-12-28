package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;

public interface IProductDAO<Product> extends IBaseDAO<Product> {

    Product getByProductName(String name);
}
