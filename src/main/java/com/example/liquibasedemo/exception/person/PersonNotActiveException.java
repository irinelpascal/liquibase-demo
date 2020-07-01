package com.example.liquibasedemo.exception.person;

import com.example.liquibasedemo.exception.CustomException;

public class PersonNotActiveException extends CustomException {

    public PersonNotActiveException(String message, String message1) {
        super(message, message1);
    }

    public PersonNotActiveException(String message, Throwable cause, String message1) {
        super(message, cause, message1);
    }

    public PersonNotActiveException() {
    }
}
