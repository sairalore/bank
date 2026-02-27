package com.nttdata.bank.domain.dto;

import java.math.BigDecimal;

/**
 * @author Saira
 */
public record AccountUpdateRequestDTO(String accountId,
                                      String accountType,
                                      BigDecimal balance
) {
}
