package com.solvd.shop.interfaces.people;

import com.solvd.shop.interfaces.IBaseDAO;

public interface IBuyerDAO<Buyer> extends IBaseDAO<Buyer> {

    Buyer getByName(String name);
}
