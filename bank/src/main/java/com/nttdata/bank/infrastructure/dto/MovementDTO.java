package com.nttdata.bank.infrastructure.dto;
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
public class MovementDTO {
    private Long id;
    private Long accountId;
    private LocalDateTime date;
    private String type;
    private BigDecimal value;
    private BigDecimal initialBalance;
    private BigDecimal availableBalance;

}
