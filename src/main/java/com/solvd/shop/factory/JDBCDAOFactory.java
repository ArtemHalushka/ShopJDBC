package com.solvd.shop.factory;

import com.solvd.shop.interfaces.IBaseDAO;
import com.solvd.shop.jdbc.dao.address.*;
import com.solvd.shop.jdbc.dao.people.*;
import com.solvd.shop.jdbc.dao.shop.*;
import com.solvd.shop.util.ConnectionPool;

public class JDBCDAOFactory implements BaseDAOFactory {

    private final ConnectionPool connectionPool;

    public JDBCDAOFactory(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public IBaseDAO getDAO(String tableName) {
        return switch (tableName) {
            case "cities" -> new CityDAO(connectionPool);
            case "countries" -> new CountryDAO(connectionPool);
            case "addresses" -> new AddressDAO(connectionPool);
            case "buyers" -> new BuyerDAO(connectionPool);
            case "employees" -> new EmployeeDAO(connectionPool);
            case "suppliers" -> new SupplierDAO(connectionPool);
            case "categories" -> new CategoryDAO(connectionPool);
            case "orders" -> new OrderDAO(connectionPool);
            case "orders_has_products" -> new OrderHasProductDAO(connectionPool);
            case "positions" -> new PositionDAO(connectionPool);
            case "products" -> new ProductDAO(connectionPool);
            case "statuses" -> new StatusDAO(connectionPool);
            default -> null;
        };
    }
}
