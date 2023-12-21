package com.solvd.shop.interafaces.people;

import com.solvd.shop.interafaces.IBaseService;

public interface ISupplierService<Supplier> extends IBaseService<Supplier> {

    Supplier getByName(String name);
}