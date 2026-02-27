package com.nttdata.bank.infrastructure.mapper;

import com.nttdata.bank.domain.model.Account;
import com.nttdata.bank.domain.model.Customer;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaAccount;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaCustomer;
import com.nttdata.bank.infrastructure.adapter.persistence.repository.SpringCustomerRepository;


/**
 * @author Saira
 */
public class AccountMapper {

    public static JpaAccount toJpaAccount(Account domainAccount, SpringCustomerRepository springCustomerRepository) {
        if(domainAccount == null) return null;
        if(domainAccount.getCustomer() == null || domainAccount.getCustomer().getId() == null || domainAccount.getCustomerId() == null) return null;

        JpaCustomer jpaCustomer =  springCustomerRepository.findById(domainAccount.getCustomerId()).orElse(null);

        return JpaAccount.builder()
                .accountNumber(domainAccount.getAccountNumber())
                .type(domainAccount.getType())
                .initialBalance(domainAccount.getInitialBalance())
                .status(domainAccount.getStatus())
                .customer(jpaCustomer)
                .build();
    }

    public static Account toDomainAccount(JpaAccount jpaAccount) {
        if(jpaAccount == null ) return null;
        Customer customer = (jpaAccount.getCustomer() != null) ?
                Customer.builder()
                        .id(jpaAccount.getCustomer().getId())
                        .name(jpaAccount.getCustomer().getName())
                        .build() : null;

        return Account.builder()
                .accountNumber(jpaAccount.getAccountNumber())
                .type(jpaAccount.getType())
                .initialBalance(jpaAccount.getInitialBalance())
                .currentBalance(jpaAccount.getInitialBalance())
                .status(jpaAccount.getStatus())
                .customerId(jpaAccount.getCustomer() != null ? jpaAccount.getCustomer().getId() : null)
                .customer(customer)
                .build();
    }
}
