package com.solvd.shop.parser;

import com.solvd.shop.models.address.Address;
import com.solvd.shop.models.address.City;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.models.shop.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JAXBParser {

    public static void marshal(Order order) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Order.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(order, new File("src/main/resources/order.xml"));
    }

    public static Order unmarshal() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Order.class);
        return (Order) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/order.xml"));
    }

    public static void main (String[] args) throws ParseException, JAXBException, FileNotFoundException {
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
        Address address2 = new Address(2 , "222 th ne", "building A", "7777", city2);
        Supplier supplier = new Supplier(1, "Apple", address2);
        Category category = new Category(1, "Smartphones");
        Product product1 = new Product(1, "Iphone X", 200.2, supplier, category, 1);
        Product product2 = new Product(1, "Airpods pro", 50.99, supplier, category, 1);
        products.add(product1);
        products.add(product2);
        order.setProducts(products);
        marshal(order);
        Order order2 = unmarshal();
        System.out.println(order2);
    }
}
