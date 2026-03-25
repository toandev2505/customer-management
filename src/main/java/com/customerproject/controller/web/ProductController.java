package com.customerproject.controller.web;

import com.customerproject.dto.ProductDTO;
import com.customerproject.entity.Direction;
import com.customerproject.service.IProductService;
import com.customerproject.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "controllerOfProductWeb")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProvinceService provinceService;

    @GetMapping(value = "/product")
    public ModelAndView showList(){
        ModelAndView mav = new ModelAndView("web/product-list");
        ProductDTO productDTO = new ProductDTO();
        productDTO.setListResult(productService.findAll());
        mav.addObject("model", productDTO);
        mav.addObject("provinces", provinceService.findAll());
        mav.addObject("directions", Direction.values());
        return mav;
    }
}
