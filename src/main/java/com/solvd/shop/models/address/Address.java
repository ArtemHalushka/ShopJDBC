package com.solvd.shop.models.address;

public class Address {

    private int addressId;
    private String firstLine;
    private String secondLine;
    private String zipCode;
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
}
