package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseService;

public interface IProductService<Product> extends IBaseService<Product> {

    Product getByProductName(String name);
}

