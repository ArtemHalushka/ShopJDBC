package com.solvd.shop.interfaces.address;

import com.solvd.shop.interfaces.IBaseDAO;

public interface ICountryDAO<Country> extends IBaseDAO<Country> {

    Country getByCountryName(String countryName);
}
