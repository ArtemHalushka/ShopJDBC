package com.solvd.shop.parser;

import com.solvd.shop.models.address.Address;
import com.solvd.shop.models.address.City;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.models.shop.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JAXBMain {

    private static final Logger LOGGER = LogManager.getLogger(JAXBMain.class);

    public static void main(String[] args) throws ParseException {
        String path = "src/main/resources/order.xml";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = dateFormat.parse("2024-01-01");
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        Status status = new Status(1, "ordered");
        Country country1 = new Country(1, "USA");
        City city1 = new City(1, "Seattle", country1);
        Address address1 = new Address(1, "150th", "", "9999", city1);
        Buyer buyer = new Buyer(1, "John Smith", "999999999", address1);
        Employee employee = new Employee(1, "Michael Merser", new Position(1, "Sales manager", 10000));
        List<Product> products = new ArrayList<>();
        City city2 = new City(2, "California", country1);
        Address address2 = new Address(2, "222 th ne", "building A", "7777", city2);
        Supplier supplier = new Supplier(1, "Apple", address2);
        Category category = new Category(1, "Smartphones");
        Product product1 = new Product(1, "Iphone X", 200.2, supplier, category, 1);
        Product product2 = new Product(2, "Airpods pro", 50.99, supplier, category, 1);
        products.add(product1);
        products.add(product2);
        Order order = new Order.Builder(1, buyer, products).orderTotal(150).date(date).employee(employee).status(status).build();
        JAXBUtil.marshal(order, path);
        Order order2 = (Order) JAXBUtil.unmarshal(path, Order.class);
        LOGGER.info(order2);
    }
}
