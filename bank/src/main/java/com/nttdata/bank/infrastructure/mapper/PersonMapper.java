package com.nttdata.bank.infrastructure.mapper;

import com.nttdata.bank.domain.model.Person;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaPerson;

/**
 * @author Saira
 */
public class PersonMapper {

    public static JpaPerson toJpaPerson(Person domainPerson) {
        if(domainPerson == null) return null;
        return JpaPerson.builder()
                .id(domainPerson.getId())
                .name(domainPerson.getName())
                .gender(domainPerson.getGender())
                .identification(domainPerson.getIdentification())
                .address(domainPerson.getAddress())
                .phone(domainPerson.getPhone())
                .build();
    }

    public static Person toDomainPerson(JpaPerson jpaPerson) {
        if(jpaPerson == null) return null;
        return Person.builder()
                .id(jpaPerson.getId())
                .name(jpaPerson.getName())
                .gender(jpaPerson.getGender())
                .identification(jpaPerson.getIdentification())
                .address(jpaPerson.getAddress())
                .phone(jpaPerson.getPhone())
                .build();
    }

}
