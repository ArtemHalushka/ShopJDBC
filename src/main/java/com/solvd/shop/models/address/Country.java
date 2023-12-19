package com.solvd.shop.models.address;

public class Country {

    private int idCountry;
    private String countryName;

    public Country() {
    }

    public Country(int idCountry, String countryName) {
        this.idCountry = idCountry;
        this.countryName = countryName;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountry=" + idCountry +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
