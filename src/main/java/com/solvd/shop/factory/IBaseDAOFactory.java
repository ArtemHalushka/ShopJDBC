package com.solvd.shop.factory;

import com.solvd.shop.interfaces.IBaseDAO;

public interface IBaseDAOFactory {

    IBaseDAO getDAO(String tableName);
}
