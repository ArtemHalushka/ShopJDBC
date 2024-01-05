package com.solvd.shop.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.models.address.City;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.models.shop.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;


public class JacksonParser {

    private static final Logger LOGGER = LogManager.getLogger(JAXBParser.class);

    public static void main(String[] args) {
        try {
            Order order = new Order();
            order.setOrderId(1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = dateFormat.parse("2024-01-01");
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            order.setDate(date);
            Status status = new Status(1, "ordered");
            order.setStatus(status);
            order.setOrderTotal(150.6);
            Country country1 = new Country(1, "USA");
            City city1 = new City(1, "Seattle", country1);
            Address address1 = new Address(1, "150th", "", "9999", city1);
            Buyer buyer = new Buyer(1, "John Smith", "999999999", address1);
            order.setBuyer(buyer);
            Employee employee = new Employee(1, "Michael Merser", new Position(1, "Sales manager", 10000));
            order.setEmployee(employee);
            List<Product> products = new ArrayList<>();
            City city2 = new City(2, "California", country1);
            Address address2 = new Address(2, "222 th ne", "building A", "7777", city2);
            Supplier supplier = new Supplier(1, "Apple", address2);
            Category category = new Category(1, "Smartphones");
            Product product1 = new Product(1, "Iphone X", 200.2, supplier, category, 1);
            Product product2 = new Product(2, "Airpods pro", 50.99, supplier, category, 1);
            products.add(product1);
            products.add(product2);
            order.setProducts(products);
            //parser
            String path = "src/main/resources/order.json";
            File file = new File(path);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(INDENT_OUTPUT);
            objectMapper.writeValue(file, order);
            Order parseOrder = objectMapper.readValue(file, Order.class);
            LOGGER.info(parseOrder);
        } catch (IOException | ParseException e) {
            LOGGER.info(e);
        }
    }
}
