package com.solvd.shop.models.people;

import com.solvd.shop.models.shop.Position;

public class Employee {

    private int idEmployee;
    private String name;
    private Position idPosition;

    public Employee() {
    }

    public Employee(int idEmployee, String name, Position idPosition) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.idPosition = idPosition;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Position idPosition) {
        this.idPosition = idPosition;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", name='" + name + '\'' +
                ", idPosition=" + idPosition +
                '}';
    }
}
