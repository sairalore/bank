package com.nttdata.bank.infrastructure.adapter.persistence;

import com.nttdata.bank.domain.model.Account;
import com.nttdata.bank.domain.model.Customer;
import com.nttdata.bank.domain.port.AccountRepository;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaAccount;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaCustomer;
import com.nttdata.bank.infrastructure.adapter.persistence.repository.SpringAccountRepository;
import com.nttdata.bank.infrastructure.adapter.persistence.repository.SpringCustomerRepository;
import com.nttdata.bank.infrastructure.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author Saira
 */
@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements AccountRepository {
    private final SpringAccountRepository springAccountRepository;
    private final SpringCustomerRepository springCustomerRepository;



    @Override
    public Mono<Account> save(Account account) {
        return Mono.fromCallable(() -> {
                    JpaAccount jpaAccount = AccountMapper.toJpaAccount(account, springCustomerRepository);
                    return springAccountRepository.save(jpaAccount);
                }).map(AccountMapper::toDomainAccount)
                .subscribeOn(Schedulers.boundedElastic());
    }
    @Override
    public Flux<Account> findAll() {
        return Flux.fromIterable(springAccountRepository.findAll())
                .map(AccountMapper::toDomainAccount)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return Mono.fromRunnable(() -> springAccountRepository.deleteById(id))
                .then()
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Account> update(Account account) {
        return Mono.fromCallable(() -> {
                    boolean exists = springAccountRepository.existsById(account.getId());
                    if (!exists) {
                        return null;
                    }
                    JpaAccount jpaAccount = AccountMapper.toJpaAccount(account, springCustomerRepository);
                    return springAccountRepository.save(jpaAccount);
                }).map(AccountMapper::toDomainAccount)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Account> findById(Long id) {
        return Mono.fromCallable(() -> springAccountRepository.findById(id).orElse(null))
                .map(AccountMapper::toDomainAccount)
                .subscribeOn(Schedulers.boundedElastic());
    }
    @Override
    public Flux<Account> findByCustomerId(Long customerId) {
        return Mono.fromCallable(() -> springAccountRepository.findByCustomerId(customerId))
                .flatMapMany(Flux::fromIterable)
                .map(AccountMapper::toDomainAccount)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
