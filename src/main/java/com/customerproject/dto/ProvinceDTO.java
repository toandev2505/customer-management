package com.customerproject.dto;

import java.util.List;

public class ProvinceDTO extends BaseDTO<ProvinceDTO> {
    private String code;
    private String name;
    private List<Long> wardIds;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getWardIds() {
        return wardIds;
    }

    public void setWardIds(List<Long> wardIds) {
        this.wardIds = wardIds;
    }
}
