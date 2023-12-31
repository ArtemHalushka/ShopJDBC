package com.solvd.shop.factory;

import com.solvd.shop.util.ConnectionPool;

public class ConnectionDAOFactory {

    public BaseDAOFactory getDAOFactory(FactoryEnum factoryEnum) {
        if (factoryEnum == FactoryEnum.JDBC) {
            return new JDBCDAOFactory(ConnectionPool.getInstance());
        } else if (factoryEnum == FactoryEnum.MYBATIS) {
            return new MyBatisDAOFactory();
        }
        return null;
    }
}
