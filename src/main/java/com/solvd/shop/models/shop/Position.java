package com.solvd.shop.models.shop;

public class Position {

    private int positionId;
    private String positionName;
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
