package com.customerproject.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ward")
public class WardEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private ProvinceEntity province;

    @OneToMany(mappedBy = "ward")
    private List<ProductEntity> products;

    @ManyToMany(mappedBy = "preferredWards")
    private List<CustomerRequirementEntity> customerRequirements = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProvinceEntity getProvince() {
        return province;
    }

    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public List<CustomerRequirementEntity> getCustomerRequirements() {
        return customerRequirements;
    }

    public void setCustomerRequirements(List<CustomerRequirementEntity> customerRequirements) {
        this.customerRequirements = customerRequirements;
    }
}
