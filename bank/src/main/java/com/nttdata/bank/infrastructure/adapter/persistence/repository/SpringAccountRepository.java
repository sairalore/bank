package com.nttdata.bank.infrastructure.adapter.persistence.repository;

import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Saira
 */
@Repository
public interface SpringAccountRepository extends JpaRepository<JpaAccount, Long> {
    List<JpaAccount> findByCustomerId(Long customerId);
}
