package com.solvd.shop.services.address;

import com.solvd.shop.interfaces.address.ICityDAO;
import com.solvd.shop.jdbc.dao.address.CityDAO;
import com.solvd.shop.models.address.City;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CityService implements ICityDAO<City> {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CityService.class);
    private static final CityDAO cityDAO = new CityDAO(connectionPool);

    @Override
    public void insert(City city) {
        cityDAO.insert(city);
    }

    @Override
    public void update(City city) {
        cityDAO.update(city);
    }

    @Override
    public void delete(City city) {
        cityDAO.delete(city);
    }

    @Override
    public City getByID(int id) {
        return cityDAO.getByID(id);
    }

    @Override
    public List<City> getAll() {
        return cityDAO.getAll();
    }

    @Override
    public City getByCityName(String cityName) {
        return cityDAO.getByCityName(cityName);
    }
}
