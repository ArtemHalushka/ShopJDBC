package com.solvd.shop.parser;

import com.solvd.shop.models.shop.Order;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JAXBUtil<T> {

    private static final Logger LOGGER = LogManager.getLogger(JAXBUtil.class);

    public static <T> void marshal(T object, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(Order.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(object, new File(path));
        } catch (JAXBException e) {
            LOGGER.info(e);
        }
    }

    public static <T> T unmarshal(String path, Class<T> type) {
        try {
            JAXBContext context = JAXBContext.newInstance(type);
            return (T) context.createUnmarshaller().unmarshal(new FileReader(path));
        } catch (JAXBException | IOException e) {
            LOGGER.info(e);
        }
        throw new RuntimeException();
    }
}
