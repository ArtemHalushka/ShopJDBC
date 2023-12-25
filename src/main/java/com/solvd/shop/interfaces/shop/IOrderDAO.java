package com.solvd.shop.interfaces.shop;

import com.solvd.shop.interfaces.IBaseDAO;

import java.sql.Date;

public interface IOrderDAO<Order> extends IBaseDAO<Order> {

    Order getByDate(Date date);
}
