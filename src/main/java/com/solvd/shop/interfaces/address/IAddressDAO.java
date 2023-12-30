package com.solvd.shop.interfaces.address;

import com.solvd.shop.interfaces.IBaseDAO;

public interface IAddressDAO<Address> extends IBaseDAO<Address> {

    Address getByFirstLine(String firstLine);
}
