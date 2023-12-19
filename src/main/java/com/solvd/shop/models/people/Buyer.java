package com.solvd.shop.models.people;

import com.solvd.shop.models.address.Address;

public class Buyer {

    private int idBuyer;
    private String name;
    private String phoneNumber;
    private Address idAddress;

    public Buyer() {
    }

    public Buyer(int idBuyer, String name, String phoneNumber, Address idAddress) {
        this.idBuyer = idBuyer;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.idAddress = idAddress;
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

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "idBuyer=" + idBuyer +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idAddress=" + idAddress +
                '}';
    }
}
