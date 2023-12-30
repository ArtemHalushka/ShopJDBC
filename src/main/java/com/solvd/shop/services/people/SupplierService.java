package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.ISupplierDAO;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.mybatis.dao.people.SupplierDAO;

import java.util.List;

public class SupplierService implements ISupplierDAO<Supplier> {

    private static final SupplierDAO supplierDAO = new SupplierDAO();

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
