package com.customerproject.api.admin;

import com.customerproject.dto.ProductDTO;
import com.customerproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "apiOfProductAdmin")
public class ProductAPI {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/api/admin/product")
    public List<ProductDTO> getProductList(){
        return productService.findAll();
    }

    @PostMapping(value = "/api/admin/product")
    public ResponseEntity<?> addImageProduct(@ModelAttribute ProductDTO productDTO){
        try {
            ProductDTO product = productService.save(productDTO);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/api/admin/product")
    public ResponseEntity<?> updateImageProduct(@ModelAttribute ProductDTO productDTO){
        try {
            ProductDTO product = productService.save(productDTO);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
