package com.nttdata.bank.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Saira
 */
public record AccountResponseDTO(String accountId,
                                 String customerId,
                                 String accountNumber,
                                 String accountType,
                                 BigDecimal balance,
                                 LocalDateTime createdAt,
                                 LocalDateTime updatedAt
) {
}
