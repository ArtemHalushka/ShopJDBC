package com.solvd.shop.interfaces.people;

import com.solvd.shop.interfaces.IBaseDAO;

public interface ISupplierDAO<Supplier> extends IBaseDAO<Supplier> {

    Supplier getByName(String name);
}
