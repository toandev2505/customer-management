package com.customerproject.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "customer_requirement")
public class CustomerRequirementEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Column(name = "min_price")
    private BigDecimal minPrice;

    @Column(name = "max_price")
    private BigDecimal maxPrice;

    @Column(name = "preferred_area")
    private Double preferredArea;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "requirement_ward", joinColumns = @JoinColumn(name = "requirement_id"),
            inverseJoinColumns = @JoinColumn(name = "ward_id"))
    private List<WardEntity> preferredWards;

    @Column(name = "property_type")
    private TypeOfProduct propertyType;

    @Column(name = "note")
    private String note;

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
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

    public TypeOfProduct getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(TypeOfProduct propertyType) {
        this.propertyType = propertyType;
    }

    public List<WardEntity> getPreferredWards() {
        return preferredWards;
    }

    public void setPreferredWards(List<WardEntity> preferredWards) {
        this.preferredWards = preferredWards;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
