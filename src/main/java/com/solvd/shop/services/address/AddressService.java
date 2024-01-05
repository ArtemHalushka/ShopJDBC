package com.solvd.shop.services.address;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.address.IAddressDAO;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.mybatis.dao.address.AddressDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AddressService implements IAddressDAO<Address> {

    private static final Logger LOGGER = LogManager.getLogger(AddressService.class);

    private static AddressDAO addressDAO = null;

    static {
        try {
            addressDAO = (AddressDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("addresses");
        } catch (ConnectionDAOException e) {
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
