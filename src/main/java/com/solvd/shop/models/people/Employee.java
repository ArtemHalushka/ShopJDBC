package com.solvd.shop.models.people;

import com.solvd.shop.models.shop.Position;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "employee")
@XmlType(propOrder = {"employeeId", "name", "position"})
public class Employee {

    @XmlAttribute(name = "id")
    private int employeeId;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "position")
    private Position position;

    public Employee() {
    }

    public Employee(int employeeId, String name, Position position) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + employeeId +
                ", name='" + name + '\'' +
                ", idPosition=" + position +
                '}';
    }
}
