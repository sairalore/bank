package com.nttdata.bank.infrastructure.dto;

import com.nttdata.bank.domain.model.Customer;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author Saira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDTO {
    private Long id;
    private String accountNumber;
    private String type;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
    private Boolean status;
    private Long idCustomer;
}
