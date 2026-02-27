package com.nttdata.bank.domain.port;

import com.nttdata.bank.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author saira
 */
public interface CustomerRepository {
    Flux<Customer> findAll();
    Mono<Customer> save(Customer customer);
    Mono<Customer> update(Customer customer);
    Mono<Void> deleteById(Long id);
    Mono<Customer> findById(Long id);
    Mono<Customer> findByIdentification(String identification);
}
