package com.nttdata.bank.application.port;

import com.nttdata.bank.domain.dto.MovementRegisterRequestDTO;
import com.nttdata.bank.domain.dto.MovementResponseDTO;
import com.nttdata.bank.domain.exception.InsufficientBalanceException;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author Saira
 */
public interface MovementPort {
    MovementResponseDTO registerMovement(MovementRegisterRequestDTO request) throws AccountNotFoundException, InsufficientBalanceException;
}
