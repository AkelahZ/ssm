package com.soecode.lyf.entity;

public class Supply {
    private Integer supplyId;

    private String supplyName;

    public Integer getSupplyId() {
        return supplyId;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "supplyId=" + supplyId +
                ", supplyName='" + supplyName + '\'' +
                '}';
    }

    public void setSupplyId(Integer supplyId) {
        this.supplyId = supplyId;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName == null ? null : supplyName.trim();
    }
}