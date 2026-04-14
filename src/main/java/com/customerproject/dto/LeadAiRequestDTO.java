package com.customerproject.dto;

public class LeadAiRequestDTO {
    private Double price_diff;
    private Double area_diff;
    private Integer ward_match;

    public LeadAiRequestDTO(Double price_diff, Double area_diff, Integer ward_match) {
        this.price_diff = price_diff;
        this.area_diff = area_diff;
        this.ward_match = ward_match;
    }

    public Double getPrice_diff() {
        return price_diff;
    }

    public void setPrice_diff(Double price_diff) {
        this.price_diff = price_diff;
    }

    public Double getArea_diff() {
        return area_diff;
    }

    public void setArea_diff(Double area_diff) {
        this.area_diff = area_diff;
    }

    public Integer getWard_match() {
        return ward_match;
    }

    public void setWard_match(Integer ward_match) {
        this.ward_match = ward_match;
    }
}
