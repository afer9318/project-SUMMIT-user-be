package com.B2B.SP.user.exceptions.customexceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(Throwable cause){
        super(cause);
    }
}
