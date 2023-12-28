package com.solvd.shop.models.people;

import com.solvd.shop.models.address.Address;

public class Buyer {

    private int buyerId;
    private String name;
    private String phoneNumber;
    private Address address;

    public Buyer() {
    }

    public Buyer(int buyerId, String name, String phoneNumber, Address address) {
        this.buyerId = buyerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
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
                "idBuyer=" + buyerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idAddress=" + address +
                '}';
    }
}
