package com.solvd.shop;

import com.solvd.shop.util.ConnectionPool;
import com.solvd.shop.util.DBConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        LOGGER.info(DBConfig.getDatabasePassword());

        ConnectionPool pool = new ConnectionPool();
        pool.getConnection();

    }
}
