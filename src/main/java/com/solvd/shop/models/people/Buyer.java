package com.solvd.shop.models.people;

import com.solvd.shop.models.address.Address;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "buyer")
@XmlType(propOrder = {"buyerId", "name", "phoneNumber", "address"})
public class Buyer {

    @XmlAttribute(name = "id")
    private int buyerId;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "phoneNumber")
    private String phoneNumber;
    @XmlElement(name = "address")
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
