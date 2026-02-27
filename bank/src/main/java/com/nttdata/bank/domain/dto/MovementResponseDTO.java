package com.nttdata.bank.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Saira
 */
public record MovementResponseDTO(String movementId,
                                  String accountId,
                                  String movementType,
                                  BigDecimal amount,
                                  LocalDateTime movementDate,
                                  String description,
                                  BigDecimal balanceAfterMovement
) {
}
