package com.nttdata.bank.domain.model;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author saira
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Customer extends Person{
    //private Long id;
    private String password;
    private Boolean status;
    //private Person person;
}
