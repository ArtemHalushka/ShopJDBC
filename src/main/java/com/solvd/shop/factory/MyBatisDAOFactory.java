package com.solvd.shop.factory;

import com.solvd.shop.interfaces.IBaseDAO;
import com.solvd.shop.mybatis.dao.address.*;
import com.solvd.shop.mybatis.dao.people.*;
import com.solvd.shop.mybatis.dao.shop.*;

public class MyBatisDAOFactory implements BaseDAOFactory {

    @Override
    public IBaseDAO getDAO(String tableName) {
        return switch (tableName) {
            case "cities" -> new CityDAO();
            case "countries" -> new CountryDAO();
            case "addresses" -> new AddressDAO();
            case "buyers" -> new BuyerDAO();
            case "employees" -> new EmployeeDAO();
            case "suppliers" -> new SupplierDAO();
            case "categories" -> new CategoryDAO();
            case "orders" -> new OrderDAO();
            case "orders_has_products" -> new OrderHasProductDAO();
            case "positions" -> new PositionDAO();
            case "products" -> new ProductDAO();
            case "statuses" -> new StatusDAO();
            default -> null;
        };
    }
}
