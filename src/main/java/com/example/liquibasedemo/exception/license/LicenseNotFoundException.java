package com.example.liquibasedemo.exception.license;

import com.example.liquibasedemo.exception.CustomException;

public class LicenseNotFoundException extends CustomException {

    public LicenseNotFoundException(String message, String message1) {
        super(message, message1);
    }

    public LicenseNotFoundException(String message, Throwable cause, String message1) {
        super(message, cause, message1);
    }

    public LicenseNotFoundException() {
    }
}
