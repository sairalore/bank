package com.nttdata.bank.infrastructure.adapter.persistence.repository;

import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Saira
 */
@Repository
public interface SpringCustomerRepository extends JpaRepository<JpaCustomer, Long> {
    Optional<JpaCustomer> findByIdentification(String identification);
}
