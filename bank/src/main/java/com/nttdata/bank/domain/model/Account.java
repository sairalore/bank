package com.nttdata.bank.domain.model;
import com.nttdata.bank.domain.exception.InsufficientBalanceException;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
/**
 * @author saira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private Long id;
    private String accountNumber;
    private String type;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
    private Boolean status;
    private Long customerId;
    private Customer customer;

    // Lógica de negocio intrínseca - independiente de la capa de persistencia
    public void debit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a debitar debe ser positivo.");
        }
        if (this.currentBalance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Saldo no disponible"); // F3
        }
        this.currentBalance = this.currentBalance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a acreditar debe ser positivo.");
        }
        this.currentBalance = this.currentBalance.add(amount);
    }

}
