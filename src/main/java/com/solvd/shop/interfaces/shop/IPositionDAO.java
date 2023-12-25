package com.solvd.shop.interfaces.shop;

import com.solvd.shop.interfaces.IBaseDAO;

public interface IPositionDAO<Position> extends IBaseDAO<Position> {

    Position getBySalary(double salary);
}
