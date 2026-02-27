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
public class CustomerDTO {
    private Long id;
    private Long idPerson;
    private String password;
    private Boolean status;
}
