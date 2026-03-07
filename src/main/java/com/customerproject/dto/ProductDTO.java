package com.customerproject.dto;

import com.customerproject.entity.Direction;
import com.customerproject.entity.StatusOfProduct;
import com.customerproject.entity.TypeOfProduct;

import java.math.BigDecimal;

public class ProductDTO {
    private String title;
    private TypeOfProduct type;
    private String address;
    private String district_id;
    private BigDecimal price;
    private Double area;
    private Integer bedrooms;
    private Direction direction;
    private StatusOfProduct status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TypeOfProduct getType() {
        return type;
    }

    public void setType(TypeOfProduct type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public StatusOfProduct getStatus() {
        return status;
    }

    public void setStatus(StatusOfProduct status) {
        this.status = status;
    }
}
