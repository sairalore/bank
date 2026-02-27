package com.nttdata.bank.infrastructure.adapter.persistence;

import com.nttdata.bank.domain.exception.DomainEntityNullException;
import com.nttdata.bank.domain.model.Account;
import com.nttdata.bank.domain.model.Customer;
import com.nttdata.bank.domain.model.Movement;
import com.nttdata.bank.domain.port.MovementRepository;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaAccount;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaMovement;
import com.nttdata.bank.infrastructure.adapter.persistence.repository.SpringAccountRepository;
import com.nttdata.bank.infrastructure.adapter.persistence.repository.SpringMovementRepository;
import com.nttdata.bank.infrastructure.mapper.AccountMapper;
import com.nttdata.bank.infrastructure.mapper.MovementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Saira
 */
@Component
@RequiredArgsConstructor
public class MovementPersistenceAdapter implements MovementRepository {
    private final SpringMovementRepository springMovementRepository;
    private final SpringAccountRepository springAccountRepository;



    @Override
    public Mono<Movement> save(Movement movement) {
        return Mono.fromCallable(() -> {
                    JpaMovement jpaMovement = MovementMapper.toJpaMovement(movement, springAccountRepository);
                    return springMovementRepository.save(jpaMovement);
                }).map(MovementMapper::toDomainMovement)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Movement> findById(Long id) {
        return Mono.fromCallable(() -> springMovementRepository.findById(id).orElse(null))
                .map(MovementMapper::toDomainMovement)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Flux<Movement> findAll() {
        return Flux.fromIterable(springMovementRepository.findAll())
                .map(MovementMapper::toDomainMovement)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return Mono.fromRunnable(() -> springMovementRepository.deleteById(id))
                .then()
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Movement> update(Movement movement) {
        return Mono.fromCallable(() -> {
                    boolean exists = springMovementRepository.existsById(movement.getId());
                    if (!exists) {
                        return null;
                    }
                    JpaMovement jpaMovement = MovementMapper.toJpaMovement(movement, springAccountRepository);
                    return springMovementRepository.save(jpaMovement);
                }).map(MovementMapper::toDomainMovement)
                .subscribeOn(Schedulers.boundedElastic());
    }


    @Override
    public Flux<Movement> findByCustomerIdAndDateRange(Long customerId, LocalDateTime startDate, LocalDateTime endDate) {
        return Mono.fromCallable(() -> springMovementRepository.findByCustomerIdAndDateRange(customerId, startDate, endDate))
                .flatMapMany(Flux::fromIterable)
                .map(MovementMapper::toDomainMovement)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Flux<Movement> findByAccountId(Long accountId) {
        return Mono.fromCallable(() -> springMovementRepository.findByAccountId(accountId))
                .flatMapMany(Flux::fromIterable)
                .map(MovementMapper::toDomainMovement)
                .subscribeOn(Schedulers.boundedElastic());
    }



}
