package com.solvd.shop.services.people;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.people.ISupplierDAO;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.mybatis.dao.people.SupplierDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SupplierService implements ISupplierDAO<Supplier> {

    private static final Logger LOGGER = LogManager.getLogger(SupplierService.class);

    private static SupplierDAO supplierDAO = null;

    static {
        try {
            supplierDAO = (SupplierDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("suppliers");
        } catch (ConnectionDAOException e) {
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
