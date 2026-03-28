package com.customerproject.api.web;

import com.customerproject.dto.ProductDTO;
import com.customerproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "apiOfProductWeb")
public class ProductAPI {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/api/web/product")
    public List<ProductDTO> getProductList(){
        return productService.findAll();
    }
}