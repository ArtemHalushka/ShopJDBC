package com.solvd.shop.factory;

import com.solvd.shop.interfaces.IBaseDAO;

public interface BaseDAOFactory {

    IBaseDAO getDAO(String tableName);
}
