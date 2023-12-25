package com.solvd.shop.interfaces.shop;

import com.solvd.shop.interfaces.IBaseDAO;

public interface IStatusDAO<Status> extends IBaseDAO<Status> {

    Status getByStatusName(String name);
}
