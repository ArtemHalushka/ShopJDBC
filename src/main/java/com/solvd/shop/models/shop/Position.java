package com.solvd.shop.models.shop;

public class Position {

    private int idPosition;
    private String positionName;
    private double salary;

    public Position() {
    }

    public Position(int idPosition, String positionName, double salary) {
        this.idPosition = idPosition;
        this.positionName = positionName;
        this.salary = salary;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
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
                "idPosition=" + idPosition +
                ", positionName='" + positionName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
