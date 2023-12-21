package com.solvd.shop.interafaces.people;

import com.solvd.shop.interafaces.IBaseService;

public interface IBuyerService<Buyer> extends IBaseService<Buyer> {

    Buyer getByName(String name);
}