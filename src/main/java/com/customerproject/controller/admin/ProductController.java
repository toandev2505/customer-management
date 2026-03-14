package com.customerproject.controller.admin;

import com.customerproject.dto.ProductDTO;
import com.customerproject.entity.Direction;
import com.customerproject.entity.TypeOfProduct;
import com.customerproject.service.IProductService;
import com.customerproject.service.impl.WardService;
import com.customerproject.util.MessageUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller(value = "controllerOfProduct")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private WardService wardService;

    @GetMapping(value = "/admin/product")
    public ModelAndView showList(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/product-list");
        ProductDTO productDTO = new ProductDTO();
        productDTO.setListResult(productService.findAll());
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", productDTO);
        return mav;
    }

    @GetMapping(value = "/admin/product/edit")
    public ModelAndView editList(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/product-edit");
        ProductDTO productDTO = new ProductDTO();
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("wards", wardService.findAll());
        mav.addObject("directions", Direction.values());
        mav.addObject("types", TypeOfProduct.values());
        mav.addObject("model", productDTO);
        return mav;
    }

    @GetMapping(value = "/admin/product/detail")
    public ModelAndView productDetail(@RequestParam("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/product-detail");

        ProductDTO productDTO = productService.findById(id);

        mav.addObject("model", productDTO);
        return mav;
    }
}
