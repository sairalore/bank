package com.nttdata.bank.domain.port;

import com.nttdata.bank.domain.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * @author saira
 */
public interface MovementRepository {
    Flux<Movement> findAll();
    Mono<Movement> save(Movement movement);
    Mono<Movement> update(Movement movement);
    Mono<Void> deleteById(Long id);
    Mono<Movement> findById(Long id);
    Flux<Movement> findByAccountId(Long accountId);
    Flux<Movement> findByCustomerIdAndDateRange(Long customerId, LocalDateTime startDate, LocalDateTime endDate); // F4

}
