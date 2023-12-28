package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;

import java.sql.Date;

public interface IOrderDAO<Order> extends IBaseDAO<Order> {

    Order getByDate(Date date);
}
