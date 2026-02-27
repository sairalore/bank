package com.nttdata.bank.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author Saira
 */

@Entity
@Table(name = "cuenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JpaAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_cuenta", unique = true, nullable = false)
    private String accountNumber;
    @Column(name = "tipo_cuenta", nullable = false)
    private String type;
    @Column(name = "saldo_inicial", nullable = false)
    private BigDecimal initialBalance;
    @Column(name = "estado", nullable = false)
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private JpaCustomer customer;
}
