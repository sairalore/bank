package com.nttdata.bank.application;

import com.nttdata.bank.application.port.AccountPort;
import com.nttdata.bank.application.port.CustomerPort;
import com.nttdata.bank.application.service.AccountService;
import com.nttdata.bank.domain.dto.AccountResponseDTO;
import com.nttdata.bank.domain.dto.AccountUpdateRequestDTO;
import com.nttdata.bank.domain.model.Account;
import com.nttdata.bank.domain.port.AccountRepository;
import com.nttdata.bank.domain.port.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Saira
 */
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;


    @Override
    public List<AccountResponseDTO> finAll() {
        Flux<Account> accounts = accountRepository.findAll();
        //List<AccountResponseDTO>  accountResponseDTOS = new ArrayList<>();
        accounts.toStream().map(item ->
            AccountResponseDTO.
        ).collect(Collectors.toList());
        return List.of();
    }
}
