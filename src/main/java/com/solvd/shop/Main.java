package com.solvd.shop;

import com.solvd.shop.models.address.City;
import com.solvd.shop.services.address.CityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        CityService cityService = new CityService();

        City city = cityService.getByID(2);

        LOGGER.info(city.toString());
    }
}
