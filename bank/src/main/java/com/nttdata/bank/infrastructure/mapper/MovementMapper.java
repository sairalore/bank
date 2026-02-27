package com.nttdata.bank.infrastructure.mapper;

import com.nttdata.bank.domain.model.Movement;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaAccount;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaMovement;
import com.nttdata.bank.infrastructure.adapter.persistence.repository.SpringAccountRepository;

/**
 * @author saira
 */
public class MovementMapper {
    public static JpaMovement toJpaMovement(Movement domainMovement, SpringAccountRepository springAccountRepository) {
        if(domainMovement == null) return null;
        if(domainMovement.getAccount() == null) return null;
        JpaAccount jpaAccount = springAccountRepository.findById(domainMovement.getAccount().getId())
                .orElse(null);
        //if(domainMovement == null) throw new DomainEntityNullException("Debe existir un movimiento a guardar");
        //if(domainMovement.getAccount() == null) throw new DomainEntityNullException("Debe existir la cuenta antes de crear el movmiento");

        return JpaMovement.builder()
                .id(domainMovement.getId())
                .date(domainMovement.getDate())
                .type(domainMovement.getType())
                .value(domainMovement.getValue())
                .initialBalance(domainMovement.getInitialBalance())
                .availableBalance(domainMovement.getAvailableBalance())
                .account(jpaAccount)
                .build();
    }

    public static Movement toDomainMovement(JpaMovement jpaMovement) {
        return Movement.builder()
                .id(jpaMovement.getId())
                .date(jpaMovement.getDate())
                .type(jpaMovement.getType())
                .value(jpaMovement.getValue())
                .initialBalance(jpaMovement.getInitialBalance())
                .availableBalance(jpaMovement.getAvailableBalance())
                .accountNumber(jpaMovement.getAccount() != null ? jpaMovement.getAccount().getAccountNumber() : null)
                .build();
    }

}
