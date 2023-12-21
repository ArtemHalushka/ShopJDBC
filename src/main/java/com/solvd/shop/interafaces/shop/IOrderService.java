package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseService;

import java.sql.Date;

public interface IOrderService<Order> extends IBaseService<Order> {

    Order getByDate(Date date);
}
