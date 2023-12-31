package com.solvd.shop.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static List<Connection> availableConnections = new ArrayList<>();
    private static List<Connection> usedConnections = new ArrayList<>();
    private final static int MAX_CONNECTIONS = 10;

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static ConnectionPool instance;

    private ConnectionPool() {
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
            create();

        }
        return instance;
    }

    public static void create() {
        for (int count = 0; count < MAX_CONNECTIONS; count++) {
            availableConnections.add(ConnectionPool.createConnection());
        }
    }

    private static Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DBConfig.getDatabaseUrl(), DBConfig.getDatabaseUser(), DBConfig.getDatabasePassword());
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return conn;
    }

    public static Connection getConnection() {
        if (availableConnections.size() == 0) {
            LOGGER.info("No any available connection, Try connect later.");
            return null;
        } else {
            Connection con = availableConnections.remove(availableConnections.size() - 1);
            usedConnections.add(con);
            return con;
        }
    }

    public static boolean releaseConnection(Connection con) {
        if (null != con) {
            usedConnections.remove(con);
            availableConnections.add(con);
            return true;
        }
        return false;
    }

    public static int getFreeConnectionCount() {
        return availableConnections.size();
    }
}
