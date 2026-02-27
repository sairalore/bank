package com.nttdata.bank.application.service;

/**
 * @author Saira
 */
public interface CustomerService {
    Optional<CustomerResponseDTO> getCustomerById(String customerId);
    CustomerResponseDTO updateCustomer(CustomerUpdateRequestDTO request) throws CustomerNotFoundException;
    void deleteCustomer(String customerId) throws CustomerNotFoundException;
    List<CustomerResponseDTO> getAllCustomers();

}
