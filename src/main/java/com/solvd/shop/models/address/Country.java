package com.solvd.shop.models.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "country")
@XmlType(propOrder = {"countryId", "countryName"})
public class Country {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int countryId;

    @XmlElement(name = "countryName")
    @JsonProperty("countryName")
    private String countryName;

    public Country() {
    }

    public Country(int countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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
                "idCountry=" + countryId +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
