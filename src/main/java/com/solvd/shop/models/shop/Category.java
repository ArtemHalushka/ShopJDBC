package com.solvd.shop.models.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "category")
@XmlType(propOrder = {"categoryId", "categoryName"})
public class Category {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int categoryId;

    @XmlElement(name = "categoryName")
    @JsonProperty("categoryName")
    private String categoryName;

    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
