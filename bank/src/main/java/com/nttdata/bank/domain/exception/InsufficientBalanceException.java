package com.nttdata.bank.domain.exception;
/**
 * @author Saira
 * */
public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
