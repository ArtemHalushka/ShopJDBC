package com.solvd.shop.services.address;

import com.solvd.shop.interfaces.address.ICountryDAO;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.mybatis.dao.address.CountryDAO;

import java.util.List;

public class CountryService implements ICountryDAO<Country> {

    private static final CountryDAO countryDAO = new CountryDAO();

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
