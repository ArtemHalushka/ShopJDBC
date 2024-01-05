package com.solvd.shop.models.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "address")
@XmlType(propOrder = {"addressId", "firstLine", "secondLine", "zipCode", "city"})
public class Address {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int addressId;

    @XmlElement(name = "firstLine")
    @JsonProperty("firstLine")
    private String firstLine;

    @XmlElement(name = "secondLine")
    @JsonProperty("secondLine")
    private String secondLine;

    @XmlElement(name = "zipCode")
    @JsonProperty("zipCode")
    private String zipCode;

    @XmlElement(name = "city")
    @JsonProperty("city")
    private City city;

    public Address() {
    }

    public Address(int addressId, String firstLine, String secondLine, String zipCode, City city) {
        this.addressId = addressId;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.zipCode = zipCode;
        this.city = city;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city=" + city +
                '}';
    }
}
