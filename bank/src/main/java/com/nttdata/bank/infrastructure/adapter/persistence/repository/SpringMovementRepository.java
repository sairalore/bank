package com.nttdata.bank.infrastructure.adapter.persistence.repository;

import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaCustomer;
import com.nttdata.bank.infrastructure.adapter.persistence.entity.JpaMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Saira
 */
@Repository
public interface SpringMovementRepository extends JpaRepository<JpaMovement,Long> {
    List<JpaMovement> findByAccountId(Long accountId);
    // Asegúrate de que las relaciones bidireccionales estén bien mapeadas si las usas así en la entidad JpaMovement
    // O realiza joins explícitos si no es posible navegar directamente en el nombre del método
    //@Query("SELECT m FROM JpaMovement m JOIN m.account a JOIN a.customer c WHERE c.id = :customerId AND m.date BETWEEN :startDate AND :endDate")
    //List<JpaMovement> findByCustomerAndDateRange(Long customerId, LocalDateTime startDate, LocalDateTime endDate);
    List<JpaMovement> findByAccountCustomerAndDateBetween(JpaCustomer customer, LocalDateTime start, LocalDateTime end);

    // Consulta para el reporte (F4), filtrando por cliente y rango de fechas
    @Query("SELECT m FROM JpaMovement m JOIN m.account a WHERE a.customer.id = :customerId AND m.date BETWEEN :startDate AND :endDate ORDER BY m.date ASC")
    List<JpaMovement> findByCustomerIdAndDateRange(Long customerId, LocalDateTime startDate, LocalDateTime endDate);


}


