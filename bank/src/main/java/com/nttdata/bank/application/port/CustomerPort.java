package com.nttdata.bank.application.port;

import com.nttdata.bank.domain.dto.CustomerCreateRequestDTO;
import com.nttdata.bank.domain.dto.CustomerResponseDTO;

/**
 * @author Saira
 */
public interface CustomerPort {
    CustomerResponseDTO createCustomer(CustomerCreateRequestDTO request);
}
