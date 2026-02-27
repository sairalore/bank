package com.nttdata.bank.infrastructure.exception;

import com.nttdata.bank.domain.exception.InsufficientBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @author Saira
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Map<String, String>> handleInsufficientBalanceException(InsufficientBalanceException ex) { // F3
        return new ResponseEntity<>(
                Map.of("message", "Saldo no disponible", "code", "INSUFFICIENT_BALANCE"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(
                Map.of("message", ex.getMessage(), "code", "INVALID_ARGUMENT"),
                HttpStatus.BAD_REQUEST
        );
    }

}
