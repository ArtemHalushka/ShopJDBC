package com.solvd.shop.interafaces.people;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.people.Buyer;

import java.util.List;

public interface IBuyerDAO extends IBaseDAO {

    Buyer getByName(String name);

    @Override
    Buyer getByID(int id);

    @Override
    List<Buyer> getAll();
}
