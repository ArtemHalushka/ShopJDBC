package com.solvd.shop.interafaces.address;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.address.Address;

import java.util.List;

public interface IAddressDAO extends IBaseDAO {

    Address getByFirstLine(String firstLine);

    @Override
    Address getByID(int id);

    @Override
    List<Address> getAll();
}
