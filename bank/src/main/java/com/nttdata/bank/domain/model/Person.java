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
public class Person {
    private Long id;
    private String name;
    private String gender;
    private String identification;
    private String address;
    private String phone;
}
