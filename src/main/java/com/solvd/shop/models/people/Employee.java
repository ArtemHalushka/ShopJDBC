package com.solvd.shop.models.people;

import com.solvd.shop.models.shop.Position;

public class Employee {

    private int employeeId;
    private String name;
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
