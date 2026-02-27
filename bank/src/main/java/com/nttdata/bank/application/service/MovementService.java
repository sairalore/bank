package com.nttdata.bank.application.service;

import com.nttdata.bank.domain.dto.MovementResponseDTO;

import java.util.List;
import java.util.Optional;

/**
 * @author Saira
 */
public interface MovementService {
    Optional<MovementResponseDTO> getMovementById(String movementId);
    List<MovementResponseDTO> getMovementsByAccountId(String accountId);

}
