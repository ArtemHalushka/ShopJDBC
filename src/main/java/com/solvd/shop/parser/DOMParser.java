package com.solvd.shop.parser;

import com.solvd.shop.models.address.City;
import com.solvd.shop.models.address.Country;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser {

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/main/resources/xml/city.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            City parseCity = new City();
            Element rootElement = doc.getDocumentElement();
            parseCity.setCityId(Integer.parseInt(rootElement.getAttribute("id")));

            NodeList nodeList = rootElement.getElementsByTagName("cityName");
            parseCity.setCityName(nodeList.item(0).getTextContent());

            Element countryElement = (Element) rootElement.getElementsByTagName("country").item(0);
            Country parseCountry = new Country();

            parseCountry.setCountryId(Integer.parseInt(countryElement.getAttribute("id")));

            NodeList countryNodeList = rootElement.getElementsByTagName("countryName");
            parseCountry.setCountryName(countryNodeList.item(0).getTextContent());

            parseCity.setCountry(parseCountry);

            System.out.println(parseCity);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
