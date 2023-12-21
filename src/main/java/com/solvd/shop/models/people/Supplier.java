package com.solvd.shop.models.people;

import com.solvd.shop.models.address.Address;

public class Supplier {

    private int idSupplier;
    private String supplierName;
    private Address address;

    public Supplier() {
    }

    public Supplier(int idSupplier, String supplierName, Address address) {
        this.idSupplier = idSupplier;
        this.supplierName = supplierName;
        this.address = address;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
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
                "idSupplier=" + idSupplier +
                ", supplierName='" + supplierName + '\'' +
                ", idAddress=" + address +
                '}';
    }
}
