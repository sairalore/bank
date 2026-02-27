package com.nttdata.bank.domain.dto;

/**
 * @author Saira
 */
public record CustomerCreateRequestDTO(String firstName,
                                       String lastName,
                                       String email,
                                       String phone
) {
}
