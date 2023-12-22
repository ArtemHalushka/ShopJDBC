package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.shop.OrderHasProduct;

import java.util.List;

public interface IOrderHasProductDAO<OrderHasProduct, Product> extends IBaseDAO<OrderHasProduct> {

    List<Product> getAllByOrderId(int id);


    }
