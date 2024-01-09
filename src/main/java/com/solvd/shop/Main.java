package com.solvd.shop;

import com.solvd.shop.models.shop.Order;
import com.solvd.shop.services.shop.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        List<Order> orders = orderService.getAll();
        LOGGER.info(orders);
    }
}
