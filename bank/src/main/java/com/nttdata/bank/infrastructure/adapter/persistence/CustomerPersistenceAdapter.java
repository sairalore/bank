package com.nttdata.bank.infrastructure.adapter.persistence;

import com.nttdata.bank.domain.model.Customer;
import com.nttdata.bank.domain.port.CustomerRepository;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaCustomer;
import com.nttdata.bank.infrastructure.adapter.persistence.repository.SpringCustomerRepository;
import com.nttdata.bank.infrastructure.mapper.CustomerMapper;
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
public class CustomerPersistenceAdapter implements CustomerRepository {
    private final SpringCustomerRepository springCustomerRepository;


    @Override
    public Mono<Customer> save(Customer customer) {
        return Mono.fromCallable(() -> springCustomerRepository.save(CustomerMapper.toJpaCustomer(customer)))
                .map(CustomerMapper::toDomainCustomer)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Customer> findById(Long id) {
        return Mono.fromCallable(() -> springCustomerRepository.findById(id).orElse(null))
                .map(CustomerMapper::toDomainCustomer)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Flux<Customer> findAll() {
        return Flux.fromIterable(springCustomerRepository.findAll())
                .map(CustomerMapper::toDomainCustomer)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return Mono.fromRunnable(() -> springCustomerRepository.deleteById(id))
                .then()
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return Mono.fromCallable(() -> {
                    boolean exists = springCustomerRepository.existsById(customer.getId());
                    if (!exists) {
                        return null;
                    }
                    return springCustomerRepository.save(CustomerMapper.toJpaCustomer(customer));
                }).map(CustomerMapper::toDomainCustomer)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Customer> findByIdentification(String identification) {
        return Mono.fromCallable(() -> springCustomerRepository.findByIdentification(identification).orElse(null))
                .map(CustomerMapper::toDomainCustomer)
                .subscribeOn(Schedulers.boundedElastic());
    }

}
