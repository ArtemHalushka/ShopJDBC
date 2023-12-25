package com.solvd.shop;

import com.solvd.shop.models.address.Address;
import com.solvd.shop.models.address.City;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.models.shop.Order;
import com.solvd.shop.models.shop.Product;
import com.solvd.shop.services.address.AddressService;
import com.solvd.shop.services.address.CityService;
import com.solvd.shop.services.address.CountryService;
import com.solvd.shop.services.shop.OrderService;
import com.solvd.shop.services.shop.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        ProductService productService = new ProductService();

        List<Product> product = productService.getAll();
        List<Order> orders = orderService.getAll();

        LOGGER.info(product);
        LOGGER.info(orders);

    }
}
