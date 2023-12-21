package com.solvd.shop.models.people;

import com.solvd.shop.models.address.Address;

public class Buyer {

    private int idBuyer;
    private String name;
    private String phoneNumber;
    private Address address;

    public Buyer() {
    }

    public Buyer(int idBuyer, String name, String phoneNumber, Address address) {
        this.idBuyer = idBuyer;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "idBuyer=" + idBuyer +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idAddress=" + address +
                '}';
    }
}
