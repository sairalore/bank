package com.nttdata.bank.infrastructure.mapper;

import com.nttdata.bank.domain.model.Customer;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaCustomer;

/**
 * @author Saira
 */
public class CustomerMapper {

    public static JpaCustomer toJpaCustomer(Customer domainCustomer) {
        if(domainCustomer == null) return null;
        return JpaCustomer.builder()
                .id(domainCustomer.getId())
                .name(domainCustomer.getName())
                .gender(domainCustomer.getGender())
                .identification(domainCustomer.getIdentification())
                .address(domainCustomer.getAddress())
                .phone(domainCustomer.getPhone())
                .password(domainCustomer.getPassword())
                .status(domainCustomer.getStatus())
                .build();
    }

    public static Customer toDomainCustomer(JpaCustomer jpaCustomer) {
        if(jpaCustomer == null) return null;
        return Customer.builder()
                .id(jpaCustomer.getId())
                .name(jpaCustomer.getName())
                .gender(jpaCustomer.getGender())
                .identification(jpaCustomer.getIdentification())
                .address(jpaCustomer.getAddress())
                .phone(jpaCustomer.getPhone())
                .password(jpaCustomer.getPassword())
                .status(jpaCustomer.getStatus())
                .build();
    }

}
