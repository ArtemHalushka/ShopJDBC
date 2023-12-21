package com.solvd.shop.interafaces.people;

import com.solvd.shop.interafaces.IBaseDAO;

public interface ISupplierDAO<Supplier> extends IBaseDAO<Supplier> {

    Supplier getByName(String name);
}
