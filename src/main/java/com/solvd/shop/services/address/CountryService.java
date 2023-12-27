package com.solvd.shop.services.address;

import com.solvd.shop.interfaces.address.ICountryDAO;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.mybatis.dao.address.CountryDAO;

import java.util.List;

public class CountryService implements ICountryDAO<Country> {

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
