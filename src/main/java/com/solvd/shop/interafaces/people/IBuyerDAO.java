package com.solvd.shop.interafaces.people;

import com.solvd.shop.interafaces.IBaseDAO;

public interface IBuyerDAO<Buyer> extends IBaseDAO<Buyer> {

    Buyer getByName(String name);
}
