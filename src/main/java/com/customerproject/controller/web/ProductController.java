package com.customerproject.controller.web;

import com.customerproject.dto.ProductDTO;
import com.customerproject.entity.Direction;
import com.customerproject.security.CustomUser;
import com.customerproject.service.IProductService;
import com.customerproject.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "controllerOfProductWeb")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProvinceService provinceService;

    @GetMapping(value = "/product")
    public ModelAndView showList(@ModelAttribute("model") ProductDTO modelSearch){
        ModelAndView mav = new ModelAndView("web/product-list");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CustomUser) { // MyUserDetail là class Custom User của bạn
            Long loggedInUserId = ((CustomUser) principal).getId();
            mav.addObject("loggedInCustomerId", loggedInUserId);
        }

        List<ProductDTO> products = productService.search(modelSearch);
        modelSearch.setListResult(products);

        mav.addObject("model", modelSearch);
        mav.addObject("provinces", provinceService.findAll());
        mav.addObject("directions", Direction.values());
        return mav;
    }

    @GetMapping(value = "/product/detail")
    public ModelAndView productDetail(@RequestParam("id") Long id) {
        ModelAndView mav = new ModelAndView("web/product-detail");
        ProductDTO product = productService.findById(id);
        mav.addObject("product", product);
        return mav;
    }
}
