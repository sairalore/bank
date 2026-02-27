package com.nttdata.bank.infrastructure.dto;

import lombok.*;
/**
 * @author saira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {
    private Long id;
    private String name;
    private String gender;
    private String identification;
    private String address;
    private String phone;
}
