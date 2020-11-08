package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNameOrPasswordExistsException extends RuntimeException{
    public UserNameOrPasswordExistsException(String message){
        super(message);
    }
}
