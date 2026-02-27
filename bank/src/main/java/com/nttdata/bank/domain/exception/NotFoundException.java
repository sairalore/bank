package com.nttdata.bank.domain.exception;
/**
 * @author Saira
 * */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
