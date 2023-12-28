package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;

public interface IPositionDAO<Position> extends IBaseDAO<Position> {

    Position getBySalary(double salary);
}
