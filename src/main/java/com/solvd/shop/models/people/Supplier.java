package com.solvd.shop.models.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.shop.models.address.Address;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "supplier")
@XmlType(propOrder = {"supplierId", "supplierName", "address"})
public class Supplier {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int supplierId;

    @XmlElement(name = "supplierName")
    @JsonProperty("supplierName")
    private String supplierName;

    @XmlElement(name = "address")
    @JsonProperty("address")
    private Address address;

    public Supplier() {
    }

    public Supplier(int supplierId, String supplierName, Address address) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.address = address;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "idSupplier=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", idAddress=" + address +
                '}';
    }
}
