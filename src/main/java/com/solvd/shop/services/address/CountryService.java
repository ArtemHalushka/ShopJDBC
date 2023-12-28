package com.solvd.shop.services.address;

import com.solvd.shop.interfaces.address.ICountryDAO;
import com.solvd.shop.models.address.Country;
<<<<<<< HEAD
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
=======
>>>>>>> 7ed9824819492cd35c8780fa4bb8b827efd99675
import com.solvd.shop.mybatis.dao.address.CountryDAO;

import java.util.List;

public class CountryService implements ICountryDAO<Country> {

<<<<<<< HEAD
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CountryService.class);
=======
>>>>>>> 7ed9824819492cd35c8780fa4bb8b827efd99675
    private static final CountryDAO batisDAO = new CountryDAO();

    @Override
    public void insert(Country country) {
        batisDAO.insert(country);
    }

    @Override
    public void update(Country country) {
        batisDAO.update(country);
    }

    @Override
    public void delete(Country country) {
        batisDAO.delete(country);
    }

    @Override
    public Country getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<Country> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Country getByCountryName(String countryName) {
        return batisDAO.getByCountryName(countryName);
    }
}
