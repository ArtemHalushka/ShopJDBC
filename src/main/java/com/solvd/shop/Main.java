package com.solvd.shop;

import com.solvd.shop.models.shop.Order;
import com.solvd.shop.services.shop.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        OrderService orderService = new OrderService();

        Order order = orderService.getByID(2);

        LOGGER.info(order);
    }
}
