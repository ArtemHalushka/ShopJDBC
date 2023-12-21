package com.solvd.shop.models.address;

public class City {

    private int idCity;
    private String cityName;
    private Country country;

    public City() {
    }

    public City(int idCity, String cityName, Country country) {
        this.idCity = idCity;
        this.cityName = cityName;
        this.country = country;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", cityName='" + cityName + '\'' +
                ", idCountry=" + country +
                '}';
    }
}
