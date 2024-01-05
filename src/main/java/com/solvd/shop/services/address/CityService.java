package com.solvd.shop.services.address;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.address.ICityDAO;
import com.solvd.shop.models.address.City;
import com.solvd.shop.mybatis.dao.address.CityDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CityService implements ICityDAO<City> {

    private static final Logger LOGGER = LogManager.getLogger(CityService.class);

    private static CityDAO cityDAO = null;

    static {
        try {
            cityDAO = (CityDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("cities");
        } catch (ConnectionDAOException e) {
            LOGGER.info(e);
        }
    }


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
