package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.shop.Status;

import java.util.List;

public interface IStatusDAO extends IBaseDAO {

    Status getByStatusName(String name);

    @Override
    Status getByID(int id);

    @Override
    List<Status> getAll();
}
