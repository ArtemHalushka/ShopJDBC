package com.solvd.shop.interafaces.address;

import com.solvd.shop.interafaces.IBaseService;

public interface IAddressService<Address> extends IBaseService<Address> {

    Address getByFirstLine(String firstLine);
}
