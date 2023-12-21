package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseService;

public interface IStatusService<Status> extends IBaseService<Status> {

    Status getByStatusName(String name);
}
