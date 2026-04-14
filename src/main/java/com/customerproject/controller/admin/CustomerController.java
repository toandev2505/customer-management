package com.customerproject.controller.admin;

import com.customerproject.dto.CustomerDTO;
import com.customerproject.dto.CustomerRequirementDTO;
import com.customerproject.dto.LeadAiResponseDTO;
import com.customerproject.dto.ProductDTO;
import com.customerproject.service.IAiService;
import com.customerproject.service.ICustomerRequirementService;
import com.customerproject.service.ICustomerService;
import com.customerproject.service.IProductService;
import com.customerproject.util.MessageUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller(value = "controllerOfCustomer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    IProductService productService;

    @Autowired
    ICustomerRequirementService customerRequirementService;

    @Autowired
    IAiService aiService;

    @Autowired
    MessageUtil messageUtil;

    @RequestMapping(value = "/admin/customer-management", method = RequestMethod.GET)
    public ModelAndView showList(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/customer-list");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setListResult(customerService.findAllWithActive());
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", customerDTO);
        return mav;
    }

    @RequestMapping(value = "/admin/customer-management/edit", method = RequestMethod.GET)
    public ModelAndView editList(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/customer-edit");
        CustomerDTO customerDTO = new CustomerDTO();
        if (id != null){
            customerDTO = customerService.findById(id);
        }
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", customerDTO);
        return mav;
    }

    @RequestMapping(value = "/admin/customer-management/detail", method = RequestMethod.GET)
    public ModelAndView showDetail(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/customer-detail");
        CustomerDTO customerDTO = new CustomerDTO();
        List<CustomerRequirementDTO> requirementDTOList = new ArrayList<>();
        if (id != null){
            customerDTO = customerService.findById(id);
            requirementDTOList = customerRequirementService.findAllByCustomerId(id);

            if (!requirementDTOList.isEmpty()) {
                List<ProductDTO> allProducts = productService.findAll();

                for (ProductDTO product : allProducts) {
                    double bestScore = 0.0;
                    String bestLabel = "COLD";

                    // Duyệt qua TẤT CẢ yêu cầu của khách hàng này
                    for (CustomerRequirementDTO require : requirementDTOList) {
                        LeadAiResponseDTO aiResult = aiService.predictLeadPotential(require, product);

                        // Nếu yêu cầu này khớp hơn yêu cầu trước đó, thì lấy điểm này
                        if (aiResult.getScore() > bestScore) {
                            bestScore = aiResult.getScore();
                            bestLabel = aiResult.getLabel();
                        }
                    }

                    // Gán kết quả tốt nhất tìm được cho sản phẩm
                    product.setAiScore(bestScore);
                    product.setAiLabel(bestLabel);
                }

                // Sắp xếp sản phẩm theo điểm số từ cao xuống thấp
                allProducts.sort((p1, p2) -> p2.getAiScore().compareTo(p1.getAiScore()));
                mav.addObject("recommendedProducts", allProducts);
            }

        }
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", customerDTO);
        mav.addObject("requirements", requirementDTOList);
        return mav;
    }

    @RequestMapping(value = "/admin/customer-management/requirement/edit", method = RequestMethod.GET)
    public ModelAndView addRequirementList(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/customer-requirement-edit");
        CustomerRequirementDTO customerRequirementDTO = new CustomerRequirementDTO();

        return mav;
    }

    @RequestMapping(value = "/admin/history-customer-management", method = RequestMethod.GET)
    public ModelAndView showUnactiveList(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/history-customer-list");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setListResult(customerService.findAllWithUnactive());
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", customerDTO);
        return mav;
    }
}
