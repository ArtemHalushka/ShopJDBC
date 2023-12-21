package com.solvd.shop.interafaces.address;

import com.solvd.shop.interafaces.IBaseService;

public interface ICityService<City> extends IBaseService<City> {

    City getByCityName(String cityName);
}