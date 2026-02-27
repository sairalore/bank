package com.nttdata.bank.domain.dto;

import java.time.LocalDateTime;

/**
 * @author Saira
 */
public record CustomerResponseDTO(String customerId,
                                  String firstName,
                                  String lastName,
                                  String email,
                                  String phone,
                                  LocalDateTime createdAt,
                                  LocalDateTime updatedAt
) {
}
