package com.nttdata.bank.infrastructure.adapter.persistence;

import com.nttdata.bank.domain.model.Person;
import com.nttdata.bank.domain.port.PersonRepository;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaPerson;
import com.nttdata.bank.infrastructure.adapter.persistence.repository.SpringPersonRepository;
import com.nttdata.bank.infrastructure.mapper.PersonMapper;
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
public class PersonPersistenceAdapter implements PersonRepository {
    private final SpringPersonRepository springPersonRepository;


    @Override
    public Mono<Person> save(Person person) {
        return Mono.fromCallable(() -> springPersonRepository.save(PersonMapper.toJpaPerson(person)))
                .map(PersonMapper::toDomainPerson)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Person> findById(Long id) {
        return Mono.fromCallable(() -> springPersonRepository.findById(id).orElse(null))
                .map(PersonMapper::toDomainPerson)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.fromIterable(springPersonRepository.findAll())
                .map(PersonMapper::toDomainPerson)
                .subscribeOn(Schedulers.boundedElastic()); // Para findAll se puede usar Flux.fromIterable
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return Mono.fromRunnable(() -> springPersonRepository.deleteById(id))
                .then()
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Person> update(Person person) {
        return Mono.fromCallable(() -> {
                    if (!springPersonRepository.existsById(person.getId())) {
                        return null;
                    }
                    return springPersonRepository.save(PersonMapper.toJpaPerson(person));
                }).map(PersonMapper::toDomainPerson)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Person> findByIdentification(String identification) {
        return Mono.fromCallable(() -> springPersonRepository.findByIdentification(identification).orElse(null))
                .map(PersonMapper::toDomainPerson)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
