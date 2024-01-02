package com.solvd.shop.factory;

import com.solvd.shop.interfaces.IBaseDAO;
import com.solvd.shop.jdbc.dao.address.AddressDAO;
import com.solvd.shop.jdbc.dao.address.CityDAO;
import com.solvd.shop.jdbc.dao.address.CountryDAO;
import com.solvd.shop.jdbc.dao.people.BuyerDAO;
import com.solvd.shop.jdbc.dao.people.EmployeeDAO;
import com.solvd.shop.jdbc.dao.people.SupplierDAO;
import com.solvd.shop.jdbc.dao.shop.*;

public class JDBCDAOFactory implements IBaseDAOFactory {

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
