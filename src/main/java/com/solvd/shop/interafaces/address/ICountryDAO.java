package com.solvd.shop.interafaces.address;

import com.solvd.shop.interafaces.IBaseDAO;

public interface ICountryDAO<Country> extends IBaseDAO<Country> {

    Country getByCountryName(String countryName);
}
