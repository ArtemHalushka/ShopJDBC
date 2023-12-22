package com.solvd.shop;

import com.solvd.shop.models.address.City;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.services.address.CityService;
import com.solvd.shop.services.address.CountryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        CityService cityService = new CityService();

        City city = cityService.getByID(2);

        CountryService countryService = new CountryService();

        Country country = countryService.getByID(2);
        LOGGER.info(city.toString());
        LOGGER.info(country.toString());
    }
}
