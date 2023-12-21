package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.interafaces.IBaseService;

public interface IPositionService<Position> extends IBaseService<Position> {

    Position getBySalary(double salary);
}
