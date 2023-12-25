package com.solvd.shop;

import com.solvd.shop.models.address.Address;
import com.solvd.shop.models.address.City;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.models.shop.Order;
import com.solvd.shop.services.address.AddressService;
import com.solvd.shop.services.address.CityService;
import com.solvd.shop.services.address.CountryService;
import com.solvd.shop.services.shop.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        CityService cityService = new CityService();

        Country moldova = new Country(10, "Moldova");

        City city = cityService.getByID(2);

        CountryService countryService = new CountryService();

        countryService.insert(moldova);

        OrderService orderService = new OrderService();

        Order order = orderService.getByID(2);

        AddressService addressService = new AddressService();

        Address address = new Address(10, "adsada", "adsadasda", "dasdawda", city);

        addressService.insert(address);
        Country country = countryService.getByID(2);
        LOGGER.info(order);
        LOGGER.info(city.toString());
        LOGGER.info(country.toString());
    }
}
