package com.nttdata.bank.infrastructure.adapter.persistence.entity;

import com.nttdata.bank.domain.model.Person;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author Saira
 */
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "persona_id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JpaCustomer extends JpaPerson{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@OneToOne
    //@JoinColumn(name = "persona_id", nullable = false)
    //private JpaPerson person;
    @Column(name = "contrasena", nullable = false)
    private String password;
    @Column(name = "estado", nullable = false)
    private Boolean status;
}
