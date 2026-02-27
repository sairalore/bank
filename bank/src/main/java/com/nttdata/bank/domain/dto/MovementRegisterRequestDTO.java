package com.nttdata.bank.domain.dto;

import java.math.BigDecimal;

/**
 * @author Saira
 */
public record MovementRegisterRequestDTO(String accountId,
                                         String movementType,
                                         BigDecimal amount,
                                         String description,
                                         String targetAccountId
) {
}
