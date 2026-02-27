package com.nttdata.bank.domain.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author saira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movement {
    private Long id;
    private LocalDateTime date;
    private String type;
    private BigDecimal value;
    private BigDecimal initialBalance;
    private BigDecimal availableBalance;
    private String accountNumber;
    private Account account;

    public void validatePositiveValue() {
        if (this.value == null || this.value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El valor del movimiento debe ser mayor que cero.");
        }
    }

}
