package com.solvd.shop.models.address;

public class City {

    private int idCity;
    private String cityName;
    private Country idCountry;

    public City() {
    }

    public City(int idCity, String cityName, Country idCountry) {
        this.idCity = idCity;
        this.cityName = cityName;
        this.idCountry = idCountry;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Country idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", cityName='" + cityName + '\'' +
                ", idCountry=" + idCountry +
                '}';
    }
}
