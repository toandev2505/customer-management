package com.customerproject.service;

import com.customerproject.dto.CustomerRequirementDTO;
import com.customerproject.dto.LeadAiResponseDTO;
import com.customerproject.dto.ProductDTO;

public interface IAiService {
    LeadAiResponseDTO predictLeadPotential(CustomerRequirementDTO customer, ProductDTO product);
}
