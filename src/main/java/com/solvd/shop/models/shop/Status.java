package com.solvd.shop.models.shop;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {

    @JsonProperty("id")
    private int statusId;

    @JsonProperty("statusName")
    private String statusName;

    public Status() {
    }

    public Status(int statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "idStatus=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
