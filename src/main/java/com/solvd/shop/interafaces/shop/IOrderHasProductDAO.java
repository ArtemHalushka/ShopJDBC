package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;

import java.util.List;

public interface IOrderHasProductDAO<OrderHasProduct> extends IBaseDAO<OrderHasProduct> {

    List<OrderHasProduct> getAllByProductId(int id);
}
