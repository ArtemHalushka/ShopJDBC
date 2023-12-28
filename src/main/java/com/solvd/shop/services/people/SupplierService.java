package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.ISupplierDAO;
import com.solvd.shop.models.people.Supplier;
<<<<<<< HEAD
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
=======
>>>>>>> 7ed9824819492cd35c8780fa4bb8b827efd99675
import com.solvd.shop.mybatis.dao.people.SupplierDAO;

import java.util.List;

public class SupplierService implements ISupplierDAO<Supplier> {

<<<<<<< HEAD
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(SupplierService.class);
=======
>>>>>>> 7ed9824819492cd35c8780fa4bb8b827efd99675
    private static final SupplierDAO batisDAO = new SupplierDAO();

    @Override
    public void insert(Supplier supplier) {
        batisDAO.insert(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        batisDAO.update(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        batisDAO.delete(supplier);
    }

    @Override
    public Supplier getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<Supplier> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Supplier getByName(String name) {
        return batisDAO.getByName(name);
    }
}
