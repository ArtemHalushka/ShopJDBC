package com.solvd.shop.interfaces.shop;

import com.solvd.shop.interfaces.IBaseDAO;

import java.util.List;

public interface IOrderHasProductDAO<OrderHasProduct, Product> extends IBaseDAO<OrderHasProduct> {

    List<Product> getAllByOrderId(int id);


    }
