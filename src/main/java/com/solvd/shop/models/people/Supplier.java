package com.solvd.shop.models.people;

import com.solvd.shop.models.address.Address;

public class Supplier {

    private int idSupplier;
    private String supplierName;
    private Address idAddress;

    public Supplier() {
    }

    public Supplier(int idSupplier, String supplierName, Address idAddress) {
        this.idSupplier = idSupplier;
        this.supplierName = supplierName;
        this.idAddress = idAddress;
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

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "idSupplier=" + idSupplier +
                ", supplierName='" + supplierName + '\'' +
                ", idAddress=" + idAddress +
                '}';
    }
}
