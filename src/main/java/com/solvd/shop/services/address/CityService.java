package com.solvd.shop.services.address;

import com.solvd.shop.interfaces.address.ICityDAO;
import com.solvd.shop.mybatis.dao.address.CityDAO;
import com.solvd.shop.models.address.City;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class CityService implements ICityDAO<City> {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CityService.class);
    private static final CityDAO batisDAO = new CityDAO();

    @Override
    public void insert(City city) {
        batisDAO.insert(city);
    }

    @Override
    public void update(City city) {
        batisDAO.update(city);
    }

    @Override
    public void delete(City city) {
        batisDAO.delete(city);
    }

    @Override
    public City getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<City> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public City getByCityName(String cityName) {
        return batisDAO.getByCityName(cityName);
    }
}
