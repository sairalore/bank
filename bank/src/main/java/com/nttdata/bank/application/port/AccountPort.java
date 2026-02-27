package com.nttdata.bank.application.port;

import com.nttdata.bank.domain.dto.AccountCreateRequestDTO;
import com.nttdata.bank.domain.dto.AccountResponseDTO;
import com.nttdata.bank.domain.exception.NotFoundException;

/**
 * @author Saira
 */
public interface AccountPort {
    AccountResponseDTO createAccount(AccountCreateRequestDTO request) throws NotFoundException;
}
