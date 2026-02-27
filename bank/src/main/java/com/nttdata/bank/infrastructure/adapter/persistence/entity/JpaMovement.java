package com.nttdata.bank.infrastructure.adapter.persistence.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * @author Saira
 */


@Entity
@Table(name = "movimiento")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class JpaMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime date;

    @Column(name = "tipo_movimiento", nullable = false, length = 10)
    private String type;

    @Column(name = "valor", nullable = false, precision = 19, scale = 2)
    private BigDecimal value;

    @Column(name = "saldo_inicial", nullable = false, precision = 19, scale = 2)
    private BigDecimal initialBalance; // Saldo antes del movimiento

    @Column(name = "saldo_disponible", nullable = false, precision = 19, scale = 2)
    private BigDecimal availableBalance; // Saldo después del movimiento

    // Relación con JpaAccount
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id", nullable = false)
    private JpaAccount account; // Referencia a la cuenta asociada
    
}
