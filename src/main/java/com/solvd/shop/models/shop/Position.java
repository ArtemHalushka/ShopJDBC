package com.solvd.shop.models.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "position")
@XmlType(propOrder = {"positionId", "positionName", "salary"})
public class Position {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int positionId;

    @XmlElement(name = "positionName")
    @JsonProperty("positionName")
    private String positionName;

    @XmlElement(name = "salary")
    @JsonProperty("salary")
    private double salary;

    public Position() {
    }

    public Position(int positionId, String positionName, double salary) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.salary = salary;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Position{" +
                "idPosition=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
