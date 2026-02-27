package com.nttdata.bank.infrastructure.adapter.persistence.repository;

import com.nttdata.bank.domain.model.Person;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Saira
 */
@Repository
public interface SpringPersonRepository extends JpaRepository<JpaPerson, Long> {
    Optional<JpaPerson> findByIdentification(String identification);
}
