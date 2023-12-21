package com.solvd.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static List<Connection> availableConnections = new ArrayList<>();
    private static List<Connection> usedConnections = new ArrayList<>();
    private final int MAX_CONNECTIONS = 5;

    public ConnectionPool() throws SQLException {
        for (int count = 0; count < MAX_CONNECTIONS; count++) {
            availableConnections.add(this.createConnection());
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DBConfig.getDatabaseUrl(), DBConfig.getDatabaseUser(), DBConfig.getDatabasePassword());
    }

    public Connection getConnection() {
        if (availableConnections.size() == 0) {
            System.out.println("No any available connection, Try connect later.");
            return null;
        } else {
            Connection con = availableConnections.remove(availableConnections.size() - 1);
            usedConnections.add(con);
            return con;
        }
    }

    public boolean releaseConnection(Connection con) {
        if (null != con) {
            usedConnections.remove(con);
            availableConnections.add(con);
            return true;
        }
        return false;
    }

    public int getFreeConnectionCount() {
        return availableConnections.size();
    }
}
