package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.shop.Position;

import java.util.List;

public interface IPositionDAO extends IBaseDAO {

    Position getBySalary(double salary);

    @Override
    Position getByID(int id);

    @Override
    List<Position> getAll();
}
