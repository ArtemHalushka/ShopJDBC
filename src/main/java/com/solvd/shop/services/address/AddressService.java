package com.solvd.shop.services.address;

import com.solvd.shop.interafaces.address.IAddressService;
import com.solvd.shop.jdbc.dao.address.AddressDAO;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class AddressService implements IAddressService<Address> {

    private static ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(AddressService.class);

    private static final AddressDAO addressDAO = new AddressDAO(connectionPool);

    static {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void insert(Address address) {
        addressDAO.insert(address);
    }

    @Override
    public void update(Address address) {
        addressDAO.update(address);
    }

    @Override
    public void delete(Address address) {
        addressDAO.delete(address);
    }

    @Override
    public Address getByID(int id) {
        return addressDAO.getByID(id);
    }

    @Override
    public List<Address> getAll() {
        return addressDAO.getAll();
    }

    @Override
    public Address getByFirstLine(String firstLine) {
        return addressDAO.getByFirstLine(firstLine);
    }
}
