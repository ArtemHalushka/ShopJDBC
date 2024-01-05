package com.solvd.shop.services.address;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.address.ICountryDAO;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.mybatis.dao.address.CountryDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CountryService implements ICountryDAO<Country> {

    private static final Logger LOGGER = LogManager.getLogger(CountryService.class);

    private static CountryDAO countryDAO = null;

    static {
        try {
            countryDAO = (CountryDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("countries");
        } catch (ConnectionDAOException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void insert(Country country) {
        countryDAO.insert(country);
    }

    @Override
    public void update(Country country) {
        countryDAO.update(country);
    }

    @Override
    public void delete(Country country) {
        countryDAO.delete(country);
    }

    @Override
    public Country getByID(int id) {
        return countryDAO.getByID(id);
    }

    @Override
    public List<Country> getAll() {
        return countryDAO.getAll();
    }

    @Override
    public Country getByCountryName(String countryName) {
        return countryDAO.getByCountryName(countryName);
    }
}
