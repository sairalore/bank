package com.nttdata.bank.domain.port;

import com.nttdata.bank.domain.model.Movement;
import com.nttdata.bank.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Saira
 */
public interface PersonRepository {
    Flux<Person> findAll();
    Mono<Person> save(Person person);
    Mono<Person> update(Person person);
    Mono<Void> deleteById(Long id);
    Mono<Person> findById(Long id);
    Mono<Person> findByIdentification(String identification);

}
