package com.solvd.shop.factory;

public class ConnectionDAOFactory {

    public IBaseDAOFactory getDAOFactory(DBConnectionType DBConnectionType) throws ConnectionDAOException {

        if (DBConnectionType == DBConnectionType.JDBC) {
            return new JDBCDAOFactory();
        } else if (DBConnectionType == DBConnectionType.MYBATIS) {
            return new MyBatisDAOFactory();
        }
        throw new ConnectionDAOException("This Connection Type not available...");
    }
}