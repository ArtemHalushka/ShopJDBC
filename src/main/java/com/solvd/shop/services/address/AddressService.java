package com.solvd.shop.services.address;

import com.solvd.shop.interfaces.address.IAddressDAO;
<<<<<<< HEAD
import com.solvd.shop.mybatis.dao.address.AddressDAO;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.util.ConnectionPool;
=======
import com.solvd.shop.models.address.Address;
import com.solvd.shop.mybatis.dao.address.AddressDAO;
>>>>>>> 7ed9824819492cd35c8780fa4bb8b827efd99675

import java.util.List;

public class AddressService implements IAddressDAO<Address> {

<<<<<<< HEAD
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
=======
>>>>>>> 7ed9824819492cd35c8780fa4bb8b827efd99675
    private static final AddressDAO batisDAO = new AddressDAO();

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
        return batisDAO.getByID(id);
<<<<<<< HEAD
=======

>>>>>>> 7ed9824819492cd35c8780fa4bb8b827efd99675
    }

    @Override
    public List<Address> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Address getByFirstLine(String firstLine) {
        return batisDAO.getByFirstLine(firstLine);
    }
}
