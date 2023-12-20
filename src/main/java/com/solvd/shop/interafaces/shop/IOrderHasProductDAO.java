package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.shop.OrderHasProduct;

import java.util.List;

public interface IOrderHasProductDAO extends IBaseDAO {

    OrderHasProduct getByProductId(int id);

    @Override
    OrderHasProduct getByID(int id);

    @Override
    List<OrderHasProduct> getAll();
}
