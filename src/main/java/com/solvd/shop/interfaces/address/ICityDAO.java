package com.solvd.shop.interfaces.address;

import com.solvd.shop.interfaces.IBaseDAO;

public interface ICityDAO<City> extends IBaseDAO<City> {

    City getByCityName(String cityName);
}
