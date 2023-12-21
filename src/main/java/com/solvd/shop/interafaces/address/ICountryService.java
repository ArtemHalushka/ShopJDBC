package com.solvd.shop.interafaces.address;

import com.solvd.shop.interafaces.IBaseService;

public interface ICountryService<Country> extends IBaseService<Country> {

    Country getByCountryName(String countryName);
}