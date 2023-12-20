package com.solvd.shop.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {

    private static final Logger LOGGER = LogManager.getLogger(DBConfig.class);
    private static final Properties properties = new Properties();

    static {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream input = loader.getResourceAsStream("db.properties")) {
            properties.load(input);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    public static String getDatabaseUrl() {
        return properties.getProperty("url");
    }

    public static String getDatabaseUser() {
        return properties.getProperty("user");
    }

    public static String getDatabasePassword() {
        return properties.getProperty("password");
    }
}
