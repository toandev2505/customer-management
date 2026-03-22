package com.customerproject.api.admin;

import com.customerproject.dto.WardDTO;
import com.customerproject.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ward")
public class WardAPI {
    @Autowired
    private IWardService wardService;

    @GetMapping
    public List<WardDTO> getWardsByProvince(@RequestParam("provinceId") Long provinceId) {
        return wardService.findByProvinceId(provinceId);
    }
}
