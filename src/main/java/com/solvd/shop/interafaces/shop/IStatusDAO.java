package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;

public interface IStatusDAO<Status> extends IBaseDAO<Status> {

    Status getByStatusName(String name);
}
