package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseService;

import java.util.List;

public interface IOrderHasProductService<OrderHasProduct> extends IBaseService<OrderHasProduct> {

    List<OrderHasProduct> getAllByProductId(int id);
}
