package com.solvd.shop.interafaces.address;

import com.solvd.shop.interafaces.IBaseDAO;

public interface IAddressDAO<Address> extends IBaseDAO<Address> {

    Address getByFirstLine(String firstLine);
}
