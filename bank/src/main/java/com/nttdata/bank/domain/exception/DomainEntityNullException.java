package com.nttdata.bank.domain.exception;
/**
 * @author Saira
 * */
public class DomainEntityNullException extends RuntimeException{
    public DomainEntityNullException(String message) {
        super(message);
    }
}
