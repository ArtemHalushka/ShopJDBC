package com.solvd.shop.interafaces.address;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.address.City;

import java.util.List;

public interface ICityDAO extends IBaseDAO {

    City getByCityName(String cityName);

    @Override
    City getByID(int id);

    @Override
    List<City> getAll();
}
