package com.nttdata.bank.application.service;

import com.nttdata.bank.domain.dto.AccountResponseDTO;
import com.nttdata.bank.domain.dto.AccountUpdateRequestDTO;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * @author Saira
 */
public interface AccountService {
    List<AccountResponseDTO> finsAll();
    //Optional<AccountResponseDTO> getAccountById(String accountId);
    //List<AccountResponseDTO> getAccountsByCustomerId(String customerId);
    //AccountResponseDTO updateAccount(AccountUpdateRequestDTO request) throws AccountNotFoundException;
    //void deleteAccount(String accountId) throws AccountNotFoundException;

}
