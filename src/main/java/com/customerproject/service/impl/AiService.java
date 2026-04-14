package com.customerproject.service.impl;

import com.customerproject.dto.CustomerRequirementDTO;
import com.customerproject.dto.LeadAiRequestDTO;
import com.customerproject.dto.LeadAiResponseDTO;
import com.customerproject.dto.ProductDTO;
import com.customerproject.service.IAiService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class AiService implements IAiService {

    public LeadAiResponseDTO predictLeadPotential(CustomerRequirementDTO customer, ProductDTO product) {
        double priceDiff = getPriceDiff(customer, product);

        double areaDiff = (product.getArea() - customer.getPreferredArea())
                / customer.getPreferredArea();

        int wardMatch = 0;
        if (customer.getPreferredWardIds() != null && product.getWardId() != null) {
            Long productWardId = product.getWardId().get(0);
            if (customer.getPreferredWardIds().contains(productWardId)) {
                wardMatch = 1;
            }
        }
        if (product.getWardId() != null && !product.getWardId().isEmpty()) {
            System.out.println("ID Phường của Sản phẩm lấy từ Java: " + product.getWardId().get(0));
        }
        System.out.println("Danh sách Phường khách yêu cầu: " + customer.getPreferredWardIds());

        RestTemplate restTemplate = new RestTemplate();

        LeadAiRequestDTO request = new LeadAiRequestDTO(priceDiff, areaDiff, wardMatch);

        try {
            String FASTAPI_URL = "http://127.0.0.1:8000/predict";
            return restTemplate.postForObject(FASTAPI_URL, request, LeadAiResponseDTO.class);
        } catch (Exception e) {
            return new LeadAiResponseDTO(0.0, "N/A");
        }
    }

    private static double getPriceDiff(CustomerRequirementDTO customer, ProductDTO product) {
        double priceDiff = 0.0;
        BigDecimal productPrice = product.getPrice();

        if (productPrice.compareTo(customer.getMaxPrice()) > 0) {
            priceDiff = (productPrice.subtract(customer.getMaxPrice()).doubleValue())
                    / customer.getMaxPrice().doubleValue();
        } else if (productPrice.compareTo(customer.getMinPrice()) < 0) {
            priceDiff = (productPrice.subtract(customer.getMinPrice()).doubleValue())
                    / customer.getMinPrice().doubleValue();
        }
        return priceDiff;
    }
}
