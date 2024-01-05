package com.solvd.shop.models.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    @JsonProperty("id")
    private int cityId;

    @JsonProperty("cityName")
    private String cityName;

    @JsonProperty("country")
    private Country country;

    public City() {
    }

    public City(int cityId, String cityName, Country country) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.country = country;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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
                "idCity=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", idCountry=" + country +
                '}';
    }
}
