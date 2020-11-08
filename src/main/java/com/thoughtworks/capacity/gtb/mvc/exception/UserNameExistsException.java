package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNameExistsException extends RuntimeException{
    public UserNameExistsException(String message){
        super(message);
    }
}
