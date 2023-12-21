package com.solvd.shop.services.people;

import com.solvd.shop.interafaces.people.ISupplierService;
import com.solvd.shop.jdbc.dao.people.SupplierDAO;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class SupplierService implements ISupplierService<Supplier> {

    private static ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(SupplierService.class);

    private static final SupplierDAO supplierDAO = new SupplierDAO(connectionPool);

    static {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }


    @Override
    public void insert(Supplier supplier) {
        supplierDAO.insert(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierDAO.update(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        supplierDAO.delete(supplier);
    }

    @Override
    public Supplier getByID(int id) {
        return supplierDAO.getByID(id);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDAO.getAll();
    }

    @Override
    public Supplier getByName(String name) {
        return supplierDAO.getByName(name);
    }
}
