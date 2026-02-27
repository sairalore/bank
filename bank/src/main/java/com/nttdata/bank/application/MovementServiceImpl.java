package com.nttdata.bank.application;

import com.nttdata.bank.domain.model.Movement;
import com.nttdata.bank.domain.port.AccountRepository;
import com.nttdata.bank.domain.port.MovementRepository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Saira
 */
public class MovementServiceImpl {
    private final AccountRepository accountRepository;
    private final MovementRepository movementRepository;

    public Mono<Movement> registerMovement(com.nttdata.bank.application.service.dto.MovementRegistrationDTO movementDto) {
        return accountRepository.findById(movementDto.getAccountId())
                .flatMap(account -> {
                    BigDecimal oldValue = account.getCurrentBalance();
                    Movement movement = new Movement(
                            null,
                            account.getId(),
                            LocalDateTime.now(),
                            movementDto.getType(),
                            movementDto.getValue(),
                            oldValue,
                            null // Balance after will be calculated
                    );
                    movement.validatePositiveValue(); // F2

                    if ("DEBITO".equalsIgnoreCase(movement.getType())) {
                        account.debit(movement.getValue()); // F2, F3: Lanza InsufficientBalanceException
                    } else if ("CREDITO".equalsIgnoreCase(movement.getType())) {
                        account.credit(movement.getValue()); // F2
                    } else {
                        return Mono.error(new IllegalArgumentException("Tipo de movimiento inválido: " + movement.getType()));
                    }

                    movement.setAvailableBalance(account.getCurrentBalance()); // Actualiza después de la operación
                    return accountRepository.save(account) // Persiste la cuenta con saldo actualizado
                            .doOnNext(updatedAccount -> System.out.println("Account updated: " + updatedAccount.getCurrentBalance()))
                            .then(movementRepository.save(movement)); // Luego persiste el movimiento
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Cuenta no encontrada")));
    }

}
