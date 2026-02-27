package com.nttdata.bank.domain.dto;

import java.math.BigDecimal;

/**
 * @author Saira
 */
public record AccountCreateRequestDTO(String customerId,
                                      String accountType,
                                      BigDecimal initialBalance
) {
}
