package com.nttdata.bank.domain.port;

import com.nttdata.bank.domain.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author saira
 */
public interface  AccountRepository {
    Flux<Account> findAll();
    Mono<Account> save(Account account);
    Mono<Account> update(Account account);
    Mono<Void> deleteById(Long id);
    Mono<Account> findById(Long id);
    Flux<Account> findByCustomerId(Long customerId);
}
