package com.solvd.shop.interafaces.address;

import com.solvd.shop.interafaces.IBaseDAO;

public interface ICityDAO<City> extends IBaseDAO<City> {

    City getByCityName(String cityName);
}
