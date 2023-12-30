package com.solvd.shop.services.address;

import com.solvd.shop.interfaces.address.IAddressDAO;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.mybatis.dao.address.AddressDAO;

import java.util.List;

public class AddressService implements IAddressDAO<Address> {

    private static final AddressDAO addressDAO = new AddressDAO();

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
