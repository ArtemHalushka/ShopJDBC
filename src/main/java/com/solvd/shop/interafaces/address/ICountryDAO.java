package com.solvd.shop.interafaces.address;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.address.Country;

import java.util.List;

public interface ICountryDAO extends IBaseDAO {

    Country getByCountryName(String countryName);

    @Override
    Country getByID(int id);

    @Override
    List<Country> getAll();
}
