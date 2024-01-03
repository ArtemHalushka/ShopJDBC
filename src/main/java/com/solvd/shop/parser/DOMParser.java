package com.solvd.shop.parser;

import com.solvd.shop.models.address.Address;
import com.solvd.shop.models.address.City;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.models.shop.Category;
import com.solvd.shop.models.shop.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class DOMParser {

    private static final Logger LOGGER = LogManager.getLogger(DOMParser.class);

    public static void main(String[] args) {
        try {
            //Validate Schema
            String xsdPath = "src/main/resources/xml/xsd/buyer.xsd";
            String xmlPath = "src/main/resources/xml/buyer.xml";
            if (validate(xsdPath, xmlPath)) {
                LOGGER.info("Validation Successful!");
            } else {
                LOGGER.info("Validation failed...");
            }
            //DOM
            File inputFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            Element rootElement = doc.getDocumentElement();
            //Buyer Object
            Buyer parseBuyer = new Buyer();
            parseBuyer.setBuyerId(Integer.parseInt(rootElement.getAttribute("id")));
            NodeList nodeList = rootElement.getElementsByTagName("buyerName");
            parseBuyer.setName(nodeList.item(0).getTextContent());
            nodeList = rootElement.getElementsByTagName("phoneNumber");
            parseBuyer.setPhoneNumber(nodeList.item(0).getTextContent());
            nodeList = rootElement.getElementsByTagName("phoneNumber");
            parseBuyer.setPhoneNumber(nodeList.item(0).getTextContent());
            //Address Object
            Element buyerAddressElement = (Element) rootElement.getElementsByTagName("address").item(0);
            parseBuyer.setAddress(parseAddress(buyerAddressElement));
            //Product Object
            Element productElement = (Element) rootElement.getElementsByTagName("product").item(0);
            Product parseProduct = new Product();
            parseProduct.setProductId(Integer.parseInt(productElement.getAttribute("id")));
            NodeList productNodeList = rootElement.getElementsByTagName("productName");
            parseProduct.setProductName(productNodeList.item(0).getTextContent());
            productNodeList = rootElement.getElementsByTagName("price");
            parseProduct.setPrice(Double.parseDouble(productNodeList.item(0).getTextContent()));
            productNodeList = rootElement.getElementsByTagName("availableQuantity");
            parseProduct.setAvailableQuantity(Integer.parseInt(productNodeList.item(0).getTextContent()));
            //Supplier Object
            Element supplierElement = (Element) productElement.getElementsByTagName("supplier").item(0);
            Supplier parseSupplier = new Supplier();
            parseSupplier.setSupplierId(Integer.parseInt(supplierElement.getAttribute("id")));
            NodeList supplierNodeList = supplierElement.getElementsByTagName("supplierName");
            parseSupplier.setSupplierName(supplierNodeList.item(0).getTextContent());
            parseProduct.setSupplier(parseSupplier);
            //Supplier Address
            Element supplierAddressElement = (Element) supplierElement.getElementsByTagName("address").item(0);
            parseSupplier.setAddress(parseAddress(supplierAddressElement));
            //Category Object
            Element categoryElement = (Element) productElement.getElementsByTagName("category").item(0);
            Category parseCategory = new Category();
            parseCategory.setCategoryId(Integer.parseInt(categoryElement.getAttribute("id")));
            NodeList categoryNodeList = categoryElement.getElementsByTagName("categoryName");
            parseCategory.setCategoryName(categoryNodeList.item(0).getTextContent());
            parseProduct.setCategory(parseCategory);
            LOGGER.info(parseBuyer);
            LOGGER.info(parseProduct);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Address parseAddress(Element addressElement) {
        Address parseAddress = new Address();
        City parseCity = new City();
        Country parseCountry = new Country();
        //Address
        parseAddress.setAddressId(Integer.parseInt(addressElement.getAttribute("id")));
        NodeList addressNodeList = addressElement.getElementsByTagName("firstLine");
        parseAddress.setFirstLine(addressNodeList.item(0).getTextContent());
        addressNodeList = addressElement.getElementsByTagName("secondLine");
        parseAddress.setSecondLine(addressNodeList.item(0).getTextContent());
        addressNodeList = addressElement.getElementsByTagName("zipCode");
        parseAddress.setZipCode(addressNodeList.item(0).getTextContent());
        //City
        Element cityElement = (Element) addressElement.getElementsByTagName("city").item(0);
        parseCity.setCityId(Integer.parseInt(cityElement.getAttribute("id")));
        NodeList cityNodeList = cityElement.getElementsByTagName("cityName");
        parseCity.setCityName(cityNodeList.item(0).getTextContent());
        //Country
        Element countryElement = (Element) cityElement.getElementsByTagName("country").item(0);
        parseCountry.setCountryId(Integer.parseInt(countryElement.getAttribute("id")));
        NodeList countryNodeList = countryElement.getElementsByTagName("countryName");
        parseCountry.setCountryName(countryNodeList.item(0).getTextContent());
        //Set relationships
        parseAddress.setCity(parseCity);
        parseCity.setCountry(parseCountry);
        return parseAddress;
    }

    public static boolean validate(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            LOGGER.info(e);
            return false;
        }
        return true;
    }
}


