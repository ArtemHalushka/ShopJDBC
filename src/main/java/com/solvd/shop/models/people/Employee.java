package com.solvd.shop.models.people;

import com.solvd.shop.models.shop.Position;

public class Employee {

    private int idEmployee;
    private String name;
    private Position position;

    public Employee() {
    }

    public Employee(int idEmployee, String name, Position position) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.position = position;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", name='" + name + '\'' +
                ", idPosition=" + position +
                '}';
    }
}
