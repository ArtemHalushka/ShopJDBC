package com.solvd.shop.interafaces.people;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.people.Supplier;

import java.util.List;

public interface ISupplierDAO extends IBaseDAO {

    Supplier getByName(String name);

    @Override
    Supplier getByID(int id);

    @Override
    List<Supplier> getAll();
}
