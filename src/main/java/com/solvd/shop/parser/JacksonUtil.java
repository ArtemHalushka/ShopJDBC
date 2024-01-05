package com.solvd.shop.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.shop.models.shop.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

public class JacksonUtil<T> {

    private static final Logger LOGGER = LogManager.getLogger(JacksonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(INDENT_OUTPUT);
    }

    public static <T> void marshal(T object, String path) {
        try {
            File file = new File(path);
            objectMapper.writeValue(file, object);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    public static <T> T unmarshal(String path) {
        try {
            File file = new File(path);
            return (T) objectMapper.readValue(file, Order.class);
        } catch (IOException e) {
            LOGGER.info(e);
        }
        throw new RuntimeException();
    }
}