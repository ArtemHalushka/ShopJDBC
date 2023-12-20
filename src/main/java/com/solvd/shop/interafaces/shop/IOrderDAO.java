package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.shop.Order;

import java.util.Date;
import java.util.List;

public interface IOrderDAO extends IBaseDAO {

    Order getByDate(Date date);

    @Override
    Order getByID(int id);

    @Override
    List<Order> getAll();
}
