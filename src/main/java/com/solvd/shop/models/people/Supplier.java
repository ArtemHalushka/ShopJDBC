package com.solvd.shop.models.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.shop.models.address.Address;

public class Supplier {

    @JsonProperty("id")
    private int supplierId;

    @JsonProperty("supplierName")
    private String supplierName;

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
