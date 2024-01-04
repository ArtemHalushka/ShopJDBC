package com.solvd.shop.models.address;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "city")
@XmlType(propOrder = {"cityId", "cityName", "country"})
public class City {

    @XmlAttribute(name = "id")
    private int cityId;
    @XmlElement(name = "cityName")
    private String cityName;
    @XmlElement(name = "country")
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
