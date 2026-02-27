package com.nttdata.bank.domain.dto;

/**
 * @author Saira
 */
public record CustomerUpdateRequestDTO(String customerId,
                                       String firstName,
                                       String lastName,
                                       String email,
                                       String phone
) {
}
