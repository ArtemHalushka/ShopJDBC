package com.solvd.shop.services.address;

import com.solvd.shop.interfaces.address.IAddressDAO;
import com.solvd.shop.jdbc.dao.address.AddressDAO;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.util.ConnectionPool;

import java.util.List;

public class AddressService implements IAddressDAO<Address> {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final AddressDAO addressDAO = new AddressDAO(connectionPool);
    private static IAddressDAO batisDAO;

    @Override
    public void insert(Address address) {
        batisDAO.insert(address);
    }

    @Override
    public void update(Address address) {
        batisDAO.update(address);
    }

    @Override
    public void delete(Address address) {
        batisDAO.delete(address);
    }

    @Override
    public Address getByID(int id) {
        return (Address) batisDAO.getByID(id);
    }

    @Override
    public List<Address> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Address getByFirstLine(String firstLine) {
        return (Address) batisDAO.getByFirstLine(firstLine);
    }
}
