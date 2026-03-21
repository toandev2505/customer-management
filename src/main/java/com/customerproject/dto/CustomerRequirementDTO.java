package com.customerproject.dto;

import com.customerproject.entity.TypeOfProduct;

import java.math.BigDecimal;
import java.util.List;

public class CustomerRequirementDTO extends BaseDTO<CustomerDTO> {
    private Long customerId;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Double preferredArea;
    private List<Long> preferredWardIds;
    private List<String> wardNames;

    private TypeOfProduct propertyType;
    private String note;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getPreferredArea() {
        return preferredArea;
    }

    public void setPreferredArea(Double preferredArea) {
        this.preferredArea = preferredArea;
    }

    public List<Long> getPreferredWardIds() {
        return preferredWardIds;
    }

    public void setPreferredWardIds(List<Long> preferredWardIds) {
        this.preferredWardIds = preferredWardIds;
    }

    public List<String> getWardNames() {
        return wardNames;
    }

    public void setWardNames(List<String> wardNames) {
        this.wardNames = wardNames;
    }

    public TypeOfProduct getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(TypeOfProduct propertyType) {
        this.propertyType = propertyType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
